package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {

    TextView userId;
    Toolbar toolbar;
    Button listViewBtn;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // id define
        userId = findViewById(R.id.userId);
        listViewBtn = findViewById(R.id.listViewBtn);
        toolbar = findViewById(R.id.toolbar);


        //toolbar show
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //step 3
        toolbar.setTitle("Recycler List");
        toolbar.setSubtitle("recycler view");

        //step 4




        // id show
        SharedPreferences preferences = getSharedPreferences("SharedPreference",MODE_PRIVATE);
        user = preferences.getString("user","");
        userId.setText("User Id: " + user);


//         list view show
        listViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listView = new Intent(homeActivity.this, MainActivity.class);
                startActivity(listView);
            }
        });




    }


    // menu bar show here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // menu selection
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.listViewMenu){
            Intent listView = new Intent(homeActivity.this, MainActivity.class);
            startActivity(listView);
        } else if (itemId == R.id.logMenu) {
            SharedPreferences preferences = getSharedPreferences("SharedPreference",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();

            Intent login = new Intent(homeActivity.this, loginActivity.class);

            startActivity(login);
            finish();
        } else {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


}