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
    Integer color;

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

        //Preview save control
        color = getIntent().getIntExtra("shipColor", 0);

        switch (color) {
            case (1):
                preview.setImageResource(R.drawable.spaceship_white);
                buttonWhite.setImageResource(R.drawable.secect);
                break;
            case (2):
                preview.setImageResource(R.drawable.spaceship_gray);
                buttonGray.setImageResource(R.drawable.secect);
                break;
            case (3):
                preview.setImageResource(R.drawable.spaceship_black);
                buttonBlack.setImageResource(R.drawable.secect);
                break;
            case (4):
                preview.setImageResource(R.drawable.spaceship_purple);
                buttonPurple.setImageResource(R.drawable.secect);
                break;
            case (5):
                preview.setImageResource(R.drawable.spaceship_blue);
                buttonBlue.setImageResource(R.drawable.secect);
                break;
            case (6):
                preview.setImageResource(R.drawable.spaceship_green);
                buttonGreen.setImageResource(R.drawable.secect);
                break;
            case (7):
                preview.setImageResource(R.drawable.spaceship_red);
                buttonRed.setImageResource(R.drawable.secect);
                break;
            case (8):
                preview.setImageResource(R.drawable.spaceship_yellow);
                buttonYellow.setImageResource(R.drawable.secect);
                break;
            case (9):
                preview.setImageResource(R.drawable.spaceship_orange);
                buttonOrange.setImageResource(R.drawable.secect);
                break;
            default:
                preview.setImageResource(R.drawable.blank);
                break;
        }

        // Button color change
        buttonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 1;
                preview.setImageResource(R.drawable.spaceship_white);
                buttonWhite.setImageResource(R.drawable.secect);
            }
        });

        buttonGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 2;
                preview.setImageResource(R.drawable.spaceship_gray);
                buttonGray.setImageResource(R.drawable.secect);
            }
        });

        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 3;
                preview.setImageResource(R.drawable.spaceship_black);
                buttonBlack.setImageResource(R.drawable.secect);
            }
        });

        buttonPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 4;
                preview.setImageResource(R.drawable.spaceship_purple);
                buttonPurple.setImageResource(R.drawable.secect);
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 5;
                preview.setImageResource(R.drawable.spaceship_blue);
                buttonBlue.setImageResource(R.drawable.secect);
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 6;
                preview.setImageResource(R.drawable.spaceship_green);
                buttonGreen.setImageResource(R.drawable.secect);
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 7;
                preview.setImageResource(R.drawable.spaceship_red);
                buttonRed.setImageResource(R.drawable.secect);
            }
        });

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 8;
                preview.setImageResource(R.drawable.spaceship_yellow);
                buttonYellow.setImageResource(R.drawable.secect);
            }
        });

        buttonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                clear();
                color = 9;
                preview.setImageResource(R.drawable.spaceship_orange);
                buttonOrange.setImageResource(R.drawable.secect);
            }
        });
    }

    //Check mark clear
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
            intent.putExtra("customColor",color);
            startActivity(intent);
        }
    }
}