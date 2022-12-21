package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Custom extends AppCompatActivity implements View.OnClickListener
{
    private Button customExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_custom);

        customExit = (Button) findViewById(R.id.exitCustom);
        customExit.setOnClickListener(this);
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