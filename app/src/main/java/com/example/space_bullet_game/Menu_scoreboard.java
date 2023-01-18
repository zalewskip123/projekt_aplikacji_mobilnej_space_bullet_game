package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Menu_scoreboard extends AppCompatActivity implements View.OnClickListener
{
    private Button changeScoreboardToMenu, buttonResetScoreboard;
    private List<String> scoreSummary = new ArrayList<>();

    Integer color;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_scoreboard);

        color = getIntent().getIntExtra("shipColor",0);

        changeScoreboardToMenu = (Button) findViewById(R.id.button1);
        changeScoreboardToMenu.setOnClickListener(this);

        buttonResetScoreboard = (Button) findViewById(R.id.buttonResetScore);
        buttonResetScoreboard.setOnClickListener(this);


        //get saved scores data from Game activity
        SharedPreferences prefs = this.getSharedPreferences("results", Context.MODE_PRIVATE);
        String gameScore = prefs.getString("score", null);
        if (gameScore != null) scoreSummary = new ArrayList<>(Arrays.asList(gameScore.split(";")));

        //sorting score list
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Collections.sort(scoreSummary, Collections.reverseOrder());

        switch(scoreSummary.size())
        {
            case (1):
                ((TextView) findViewById(R.id.score1)).setText(String.valueOf(scoreSummary.get(0)));
                break;
            case (2):
                ((TextView) findViewById(R.id.score1)).setText(String.valueOf(scoreSummary.get(0)));
                ((TextView) findViewById(R.id.score2)).setText(String.valueOf(scoreSummary.get(1)));
                break;
            case (3):
                ((TextView) findViewById(R.id.score1)).setText(String.valueOf(scoreSummary.get(0)));
                ((TextView) findViewById(R.id.score2)).setText(String.valueOf(scoreSummary.get(1)));
                ((TextView) findViewById(R.id.score3)).setText(String.valueOf(scoreSummary.get(2)));
                break;
            case (4):
                ((TextView) findViewById(R.id.score1)).setText(String.valueOf(scoreSummary.get(0)));
                ((TextView) findViewById(R.id.score2)).setText(String.valueOf(scoreSummary.get(1)));
                ((TextView) findViewById(R.id.score3)).setText(String.valueOf(scoreSummary.get(2)));
                ((TextView) findViewById(R.id.score4)).setText(String.valueOf(scoreSummary.get(3)));
                break;
            default:
                if (scoreSummary.size() > 0)
                {
                    ((TextView) findViewById(R.id.score1)).setText(String.valueOf(scoreSummary.get(0)));
                    ((TextView) findViewById(R.id.score2)).setText(String.valueOf(scoreSummary.get(1)));
                    ((TextView) findViewById(R.id.score3)).setText(String.valueOf(scoreSummary.get(2)));
                    ((TextView) findViewById(R.id.score4)).setText(String.valueOf(scoreSummary.get(3)));
                    ((TextView) findViewById(R.id.score5)).setText(String.valueOf(scoreSummary.get(4)));
                }
                break;
        }
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
        else if(v.getId() == buttonResetScoreboard.getId())
        {
            //reset score on exit
            ((TextView) findViewById(R.id.score1)).setText("00000");
            ((TextView) findViewById(R.id.score2)).setText("00000");
            ((TextView) findViewById(R.id.score3)).setText("00000");
            ((TextView) findViewById(R.id.score4)).setText("00000");
            ((TextView) findViewById(R.id.score5)).setText("00000");

            SharedPreferences sh;
            sh = getSharedPreferences("results", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sh.edit();
            editor.putString("score", null);
            editor.commit();
        }
    }
}