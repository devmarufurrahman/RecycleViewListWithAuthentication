package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrationActivity extends AppCompatActivity {

    EditText regUser, regPass, regPassConfirm;
    Button nextRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // id define
        regPass = findViewById(R.id.regPass);
        regPassConfirm = findViewById(R.id.regPassConfirm);
        regUser = findViewById(R.id.regUser);
        nextRegBtn = findViewById(R.id.nextRegBtn);

        // goto next registration  page
        nextRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextReg = new Intent(registrationActivity.this,registrationActivity2.class);
                startActivity(nextReg);
            }
        });
    }
}