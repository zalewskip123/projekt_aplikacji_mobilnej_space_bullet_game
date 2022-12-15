package com.example.space_bullet_game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button changeStartToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_start);

        changeStartToMenu = (Button) findViewById(R.id.button20);
        changeStartToMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == changeStartToMenu.getId()) {
            Intent intent = new Intent(this, Menu_main.class);
            startActivity(intent);
        }
    }
}