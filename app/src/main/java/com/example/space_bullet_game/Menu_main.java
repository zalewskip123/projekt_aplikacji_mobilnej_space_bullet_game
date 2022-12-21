package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_main extends AppCompatActivity implements View.OnClickListener
{
    private Button changeMenuToPlay;
    private Button changeMenuToCustom;
    private Button changeMenuToScoreboard;
    private Button changeMenuToCredits;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        changeMenuToPlay = (Button) findViewById(R.id.button7);
        changeMenuToPlay.setOnClickListener(this);

        changeMenuToCustom = (Button) findViewById(R.id.button6);
        changeMenuToCustom.setOnClickListener(this);

        changeMenuToScoreboard = (Button) findViewById(R.id.button5);
        changeMenuToScoreboard.setOnClickListener(this);

        changeMenuToCredits = (Button) findViewById(R.id.button3);
        changeMenuToCredits.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == changeMenuToPlay.getId())
        {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }
        else if(v.getId() == changeMenuToCustom.getId())
        {
            Intent intent = new Intent(this, Menu_Custom.class);
            startActivity(intent);
        }
        else if(v.getId() == changeMenuToScoreboard.getId())
        {
            Intent intent = new Intent(this, Menu_scoreboard.class);
            startActivity(intent);
        }
        else if(v.getId() == changeMenuToCredits.getId())
        {
            //Intent intent = new Intent(this, Menu_credits.class);
            //startActivity(intent);
        }
    }
}