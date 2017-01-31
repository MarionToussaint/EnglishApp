package com.example.mmtou.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private TextView score;
    private TextView point;
    private Button menu;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = (TextView) findViewById(R.id.score);
        point = (TextView) findViewById(R.id.point);
        menu = (Button) findViewById(R.id.menu);
        next = (Button) findViewById(R.id.nextLevel);
        if (FirstScreenActivity.difficulty == 1){
            point.setText(Integer.toString(Level1EasyActivity.point) + " / " + Integer.toString(10));
        }
        else {
            point.setText(Integer.toString(Level1EasyActivity.point) + " / " + Integer.toString(15));
        }


        menu.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ScoreActivity.this, EasyActivity.class));
            }
        });

        next.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                EasyActivity.numLevel = EasyActivity.numLevel +1;
                startActivity(new Intent(ScoreActivity.this, Level1EasyActivity.class));
            }
        });
    }
}
