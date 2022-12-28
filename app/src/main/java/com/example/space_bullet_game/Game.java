package com.example.space_bullet_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity {

    private Button starShip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

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
                        view.animate()
                                .x(event.getRawX() + dX)
                                .setDuration(0)
                                .start();
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });
    }
}