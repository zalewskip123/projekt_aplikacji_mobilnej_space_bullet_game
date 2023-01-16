package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
    private boolean firstPress = false, lose = false;
    private TextView scoresSh, healthSh, gameOverSh;
    private int scoresValue = 0, healthValue = 3;
    private Thread threadShowHealthAndScores;

    Integer spaceshipColor;

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
        spaceshipColor = getIntent().getIntExtra("shipColor",0);
        starShip = (Button) findViewById(R.id.bShip);
        switch (spaceshipColor) {
            case (1):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_white));
                }
                break;
            case (2):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_gray));
                }
                break;
            case (3):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_black));
                }
                break;
            case (4):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_purple));
                }
                break;
            case (5):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_blue));
                }
                break;
            case (6):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_green));
                }
                break;
            case (7):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_red));
                }
                break;
            case (8):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_yellow));
                }
                break;
            case (9):
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.spaceship_orange));
                }
                break;
            default:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    starShip.setForeground(getDrawable(R.drawable.blank));
                }
                break;
        }
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
                        if (!lose) {
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
                        }
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

        scoresSh = (TextView) findViewById(R.id.scoresView);
        healthSh = (TextView) findViewById(R.id.healthView);

        gameOverSh = (TextView) findViewById(R.id.gameOver);
        gameOverSh.setY(layoutHeight);

        threadShowHealthAndScores = new Thread() {
            @Override
            public void run() {
                while(!isInterrupted() && !lose) {
                    try {
                        Thread.sleep(500);
                        scoresSh.setText(String.format("%05d",scoresValue));
                        if (healthValue > 0) healthSh.setText("Lives " + Integer.toString(healthValue) + "/3");
                        else {
                            healthSh.setText("Lives " + Integer.toString(healthValue) + "/3");
                            gameOverSh.setY((layoutHeight*40)/100);
                            lose = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        threadShowHealthAndScores.start();
    }

    //Generate random number of star
    private void randStar() {
        if (!lose) {
            int randNumber = (int)Math.floor(Math.random()*5);
            while(savedRandNumbers.contains(randNumber)) {
                if (savedRandNumbers.size() == 5)
                {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            savedRandNumbers.clear();
                        }
                    }, 1500);
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
    }

    //Movement of star
    private void starRun(int id) {
        if (!lose) {
            if (stars[id].getY() < layoutHeight) {
                if (stars[id].getY() + ((40 * stars[id].getHeight())/100) > starShip.getTop() && stars[id].getLeft() < starShip.getX() + ((55 * starShip.getWidth())/100) && stars[id].getRight() > starShip.getX() + ((45 * starShip.getWidth())/100) && stars[id].getY() + ((45 * stars[id].getHeight())/100) < starShip.getBottom())
                {
                    scoresValue += 10;
                    stars[id].setY((layoutHeight*14/100));
                    return;
                }
                Timer timer = new Timer();
                if (!lose) stars[id].setY(stars[id].getY() + 20);
                timer.schedule(new TimerTask() {
                    public void run() {
                        starRun(id);
                    }
                }, 60);
            } else if (savedRandNumbers.contains(id)) {
                healthValue--;
                stars[id].setY((layoutHeight*14/100));
            }
        }
    }
}