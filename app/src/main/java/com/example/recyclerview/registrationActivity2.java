package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrationActivity2 extends AppCompatActivity {
    EditText regUserName, regAddress, regEmail;
    Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        // id define
        regUserName = findViewById(R.id.regUserName);
        regAddress = findViewById(R.id.regAddress);
        regEmail = findViewById(R.id.regEmail);
        signupBtn = findViewById(R.id.signupBtn);



        // reg to login transfer
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regToLog = new Intent(registrationActivity2.this,loginActivity.class);
                startActivity(regToLog);
            }
        });
    }
}