package com.biniyam.birthday_witch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int TIME_OUT=3200;
    TextView title,me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        me= findViewById(R.id.me);

        Typeface mytype= Typeface.createFromAsset(getAssets(),"fonts/productsansregular.ttf");


        me.setTypeface(mytype);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this, Game.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);

    }
}
