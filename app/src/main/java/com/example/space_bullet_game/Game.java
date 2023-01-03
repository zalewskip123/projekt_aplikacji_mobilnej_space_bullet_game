package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends AppCompatActivity {

    private Button starShip;
    private int layoutWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int layoutHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private Button[] stars = new Button[5];
    private List<Integer> savedRandNumbers = new ArrayList<>();
    private float savedHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        //Starship player control
        starShip = (Button) findViewById(R.id.bShip);
        starShip.setOnTouchListener(new View.OnTouchListener() {
            float dX;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int leftSide = (layoutWidth * 12)/100;
                        int rightSide = layoutWidth - leftSide;
                        if (event.getRawX() >= leftSide && event.getRawX() <= rightSide) {
                            view.animate()
                                    .x(event.getRawX() + dX)
                                    .setDuration(0)
                                    .start();
                        } else if (event.getRawX() < leftSide) {
                            view.setX(1);
                        } else if (event.getRawX() > rightSide) {
                            view.setX(rightSide - view.getWidth() + leftSide + 1);
                        }
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

        //Stars
        stars[0] = (Button) findViewById(R.id.star1);
        stars[1] = (Button) findViewById(R.id.star2);
        stars[2] = (Button) findViewById(R.id.star3);
        stars[3] = (Button) findViewById(R.id.star4);
        stars[4] = (Button) findViewById(R.id.star5);
        savedHeight = stars[0].getY();
        randStar();
    }

    private void randStar() {
        int randNumber = (int)Math.floor(Math.random()*5);
        while(savedRandNumbers.contains(randNumber)) {
            randNumber = (int)Math.floor(Math.random()*5);
        }
        savedRandNumbers.add(randNumber);
        System.out.println(randNumber);
        //stars[randNumber].setVisibility(View.VISIBLE);
        starRun(randNumber);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                randStar();
            }
        }, 2500);
    }

    private void starRun(int id) {
        if (stars[id].getY() < layoutHeight) {
            Timer timer = new Timer();
            stars[id].setY(stars[id].getY() + 6);
            timer.schedule(new TimerTask() {
                public void run() {
                    starRun(id);
                }
            }, 10);
        } else if (savedRandNumbers.contains(id)) {
          //  stars[id].setVisibility(View.INVISIBLE);
          //  savedRandNumbers.remove(id);
            stars[id].setY(savedHeight);
        }
    }
}