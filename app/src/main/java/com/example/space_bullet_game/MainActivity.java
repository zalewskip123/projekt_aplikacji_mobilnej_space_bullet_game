package com.example.space_bullet_game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_start);

        timer = new Timer();
        Intent intent = new Intent(this, Menu_main.class);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 5000);
    }
}