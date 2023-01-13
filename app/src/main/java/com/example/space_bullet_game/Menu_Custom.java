package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu_Custom extends AppCompatActivity implements View.OnClickListener
{
    private Button customExit;

    ImageView preview;
    ImageButton buttonWhite;
    ImageButton buttonGray;
    ImageButton buttonBlack;
    ImageButton buttonPurple;
    ImageButton buttonBlue;
    ImageButton buttonGreen;
    ImageButton buttonRed;
    ImageButton buttonYellow;
    ImageButton buttonOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_custom);

        customExit = (Button) findViewById(R.id.exitCustom);
        customExit.setOnClickListener(this);

        preview = findViewById(R.id.spaceShip);
        buttonWhite = findViewById(R.id.selectWhite);
        buttonGray = findViewById(R.id.selectGray);
        buttonBlack = findViewById(R.id.selectBlack);
        buttonPurple = findViewById(R.id.selectPurple);
        buttonBlue = findViewById(R.id.selectBlue);
        buttonGreen = findViewById(R.id.selectGreen);
        buttonRed = findViewById(R.id.selectRed);
        buttonYellow = findViewById(R.id.selectYellow);
        buttonOrange = findViewById(R.id.selectOrange);

        buttonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_white);
                buttonWhite.setImageResource(R.drawable.secect);
            }
        });

        buttonGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_gray);
                buttonGray.setImageResource(R.drawable.secect);
            }
        });

        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_black);
                buttonBlack.setImageResource(R.drawable.secect);
            }
        });

        buttonPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_purple);
                buttonPurple.setImageResource(R.drawable.secect);
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_blue);
                buttonBlue.setImageResource(R.drawable.secect);
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_green);
                buttonGreen.setImageResource(R.drawable.secect);
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_red);
                buttonRed.setImageResource(R.drawable.secect);
            }
        });

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_yellow);
                buttonYellow.setImageResource(R.drawable.secect);
            }
        });

        buttonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                preview.setImageResource(R.drawable.spaceship_orange);
                buttonOrange.setImageResource(R.drawable.secect);
            }
        });
    }

    private void clear(){
        buttonWhite.setImageResource(R.drawable.blank);
        buttonGray.setImageResource(R.drawable.blank);
        buttonBlack.setImageResource(R.drawable.blank);
        buttonPurple.setImageResource(R.drawable.blank);
        buttonBlue.setImageResource(R.drawable.blank);
        buttonGreen.setImageResource(R.drawable.blank);
        buttonRed.setImageResource(R.drawable.blank);
        buttonYellow.setImageResource(R.drawable.blank);
        buttonOrange.setImageResource(R.drawable.blank);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == customExit.getId())
        {
            Intent intent = new Intent(this, Menu_main.class);
            startActivity(intent);
        }
    }
}