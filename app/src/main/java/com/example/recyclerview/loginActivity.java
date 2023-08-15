package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText loginUser, loginPass;
    Button loginBtn, regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // id define
        loginBtn = findViewById(R.id.loginBtn);
        regBtn = findViewById(R.id.regBtn);
        loginUser = findViewById(R.id.loginUser);
        loginPass = findViewById(R.id.loginPass);

        // Registration Activity on
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registration = new Intent(loginActivity.this,registrationActivity.class);
                startActivity(registration);
                finish();
            }
        });


        // login user
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLogin();
                if (!loginUser.getText().toString().equals("")) {
                    Intent home = new Intent(loginActivity.this, homeActivity.class);
                    startActivity(home);
                    finish();
                } else {
                    Toast.makeText(loginActivity.this, "Please enter number & pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void saveLogin() {
        SharedPreferences preferences = getSharedPreferences("SharedPreference",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (!loginUser.getText().toString().equals("")) {
            editor.putString("user", loginUser.getText().toString());
            editor.apply();
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}