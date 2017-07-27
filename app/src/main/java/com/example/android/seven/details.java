package com.example.android.seven;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity{

    TextView text;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String name= getIntent().getExtras().getString("name");
        int d = getIntent().getExtras().getInt("details");
        int img = getIntent().getExtras().getInt("image");
        this.setTitle(name);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        image = (ImageView) findViewById(R.id.image);
        text = (TextView) findViewById(R.id.text);
        image.setImageResource(img);
        text.setText(d);
        text.setTextSize(20f);
    }
}
