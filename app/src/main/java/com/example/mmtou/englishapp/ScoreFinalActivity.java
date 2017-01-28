package com.example.mmtou.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreFinalActivity extends AppCompatActivity {
    private TextView score;
    private TextView point;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_final);

        score = (TextView) findViewById(R.id.score);
        point = (TextView) findViewById(R.id.point);
        menu = (Button) findViewById(R.id.menu);
        point.setText(Integer.toString(Level1EasyActivity.point) + " / " + Integer.toString(4));

        menu.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ScoreFinalActivity.this, FirstScreenActivity.class));
            }
        });
    }
}
