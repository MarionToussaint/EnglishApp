package com.example.mmtou.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstScreenActivity extends AppCompatActivity {
    private TextView app;
    private Button easy;
    private Button medium;
    private Button hard;
    private Button list;
    public static int difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        app = (TextView) findViewById(R.id.english);
        easy = (Button) findViewById(R.id.bEasy);
        medium = (Button) findViewById(R.id.bMedium);
        hard = (Button) findViewById(R.id.bHard);
        list = (Button) findViewById(R.id.list);

        medium.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                difficulty = 2;
                startActivity(new Intent(FirstScreenActivity.this,MediumActivity.class));
            }
        });

        easy.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                difficulty = 1;
                startActivity(new Intent(FirstScreenActivity.this,EasyActivity.class));
            }
        });

        hard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                difficulty = 3;
                startActivity(new Intent(FirstScreenActivity.this,HardActivity.class));
            }
        });

        list.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FirstScreenActivity.this,ListActivity.class));
            }
        });
    }
}
