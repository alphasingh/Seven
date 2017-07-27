package com.example.android.seven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.example.android.seven.R.id.imageonly;

public class onlyimage extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlyimage);
        int imageID = getIntent().getExtras().getInt("imageonly");
        img = (ImageView) findViewById(imageonly);
        img.setImageResource(imageID);
    }
}
