package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Credits extends AppCompatActivity implements View.OnClickListener
{
    private Button creditsExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_credits);

        creditsExit = (Button) findViewById(R.id.exitCredits);
        creditsExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == creditsExit.getId())
        {
            Intent intent = new Intent(this, Menu_main.class);
            startActivity(intent);
        }
    }
}