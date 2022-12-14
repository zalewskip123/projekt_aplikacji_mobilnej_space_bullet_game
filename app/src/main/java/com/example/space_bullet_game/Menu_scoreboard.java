package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_scoreboard extends AppCompatActivity implements View.OnClickListener
{
    private Button changeScoreboardToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_scoreboard);

        changeScoreboardToMenu = (Button) findViewById(R.id.button1);
        changeScoreboardToMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == changeScoreboardToMenu.getId())
        {
            Intent intent = new Intent(this, Menu_main.class);
            startActivity(intent);
        }
    }
}