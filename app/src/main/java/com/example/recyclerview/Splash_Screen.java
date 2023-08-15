package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {
    public static String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);




        // login authentication

        SharedPreferences preferences = getSharedPreferences("SharedPreference",MODE_PRIVATE);
        user = preferences.getString("user","");


        // splash screen dellay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!user.equals("")) {
                    Intent home = new Intent(Splash_Screen.this,homeActivity.class);
                    startActivity(home);
                } else {
                    Intent login = new Intent(Splash_Screen.this, loginActivity.class);
                    startActivity(login);
                }

                finish();
            }
        },3000);
    }


}