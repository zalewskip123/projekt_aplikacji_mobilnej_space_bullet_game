package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_scoreboard extends AppCompatActivity implements View.OnClickListener
{
    private Button changeScoreboardToMenu;
    private TextView score1, score2, score3, score4, score5;
    private int top1, top2, top3, top4, top5;
    private int lastScore;

    Integer color;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_scoreboard);

        color = getIntent().getIntExtra("shipColor",0);

        changeScoreboardToMenu = (Button) findViewById(R.id.button1);
        changeScoreboardToMenu.setOnClickListener(this);

        /*
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("Last score", 0);
        top1 = preferences.getInt("score1", 0);
        top2 = preferences.getInt("score2", 0);
        top3 = preferences.getInt("score3", 0);
        top4 = preferences.getInt("score4", 0);
        top5 = preferences.getInt("score5", 0);


        if(lastScore > top5)
        {
            top5 = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("top5", 0);
            editor.apply();
        }
        if(lastScore > top4)
        {
            int temp = top4;
            top4 = lastScore;
            top5 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("top5", 0);
            editor.putInt("top4", 0);
            editor.apply();
        }
        if(lastScore > top3)
        {
            int temp = top3;
            top3 = lastScore;
            top4 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("top4", 0);
            editor.putInt("top3", 0);
            editor.apply();
        }
        if(lastScore > top2)
        {
            int temp = top2;
            top2 = lastScore;
            top3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("top3", 0);
            editor.putInt("top2", 0);
            editor.apply();
        }
        if(lastScore > top1)
        {
            int temp = top1;
            top1 = lastScore;
            top2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("top2", 0);
            editor.putInt("top1", 0);
            editor.apply();
        }




        score1.setText(top1);
        score2.setText(top2);
        score3.setText(top3);
        score4.setText(top4);
        score5.setText(top5);
        */
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == changeScoreboardToMenu.getId())
        {
            Intent intent = new Intent(this, Menu_main.class);
            intent.putExtra("customColor",color);
            startActivity(intent);
        }
    }
}