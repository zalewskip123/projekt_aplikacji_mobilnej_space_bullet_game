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
    private boolean firstPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        //Stars
        stars[0] = (Button) findViewById(R.id.star1);
        stars[1] = (Button) findViewById(R.id.star2);
        stars[2] = (Button) findViewById(R.id.star3);
        stars[3] = (Button) findViewById(R.id.star4);
        stars[4] = (Button) findViewById(R.id.star5);

        //Starship player control
        starShip = (Button) findViewById(R.id.bShip);
        starShip.setOnTouchListener(new View.OnTouchListener() {
            float dX;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        if (!firstPress)
                        {
                            randStar();
                            firstPress = true;
                        }
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
    }

    //Generate random number of star
    private void randStar() {
        int randNumber = (int)Math.floor(Math.random()*5);
        while(savedRandNumbers.contains(randNumber)) {
            if (savedRandNumbers.size() == 5)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        savedRandNumbers.clear();
                    }
                }, 800);
            }
            randNumber = (int)Math.floor(Math.random()*5);
        }
        savedRandNumbers.add(randNumber);
        starRun(randNumber);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                randStar();
            }
        }, 2500);
    }

    //Movement of star
    private void starRun(int id) {
        if (stars[id].getY() < layoutHeight) {
            Timer timer = new Timer();
            stars[id].setY(stars[id].getY() + 20);
            timer.schedule(new TimerTask() {
                public void run() {
                    starRun(id);
                }
            }, 50);
        } else if (savedRandNumbers.contains(id)) {
            stars[id].setY((layoutHeight*14/100));
        }
    }
}