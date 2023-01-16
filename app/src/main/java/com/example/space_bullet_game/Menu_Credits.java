package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Credits extends AppCompatActivity implements View.OnClickListener
{
    private Button creditsExit;

    Integer color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_credits);

        color = getIntent().getIntExtra("shipColor",0);

        creditsExit = (Button) findViewById(R.id.exitCredits);
        creditsExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == creditsExit.getId())
        {
            Intent intent = new Intent(this, Menu_main.class);
            intent.putExtra("customColor",color);
            startActivity(intent);
        }
    }
}