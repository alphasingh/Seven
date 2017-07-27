package com.example.android.seven;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alphasingh on 26-06-2017.
 * To avoid the white screen due to cold start
 * Rather show the user something else during this time
 * Don't waste user's time with a splash screen
 */

public class SplashActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
