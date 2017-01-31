package com.example.mmtou.englishapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HardActivity extends AppCompatActivity {
    private TextView easy;
    private Button level1;
    private Button level2;
    private Button level3;
    private Button level4;
    private Button level5;
    private Button level6;
    public static int numLevel;
    private FloatingActionButton retrn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);


        easy = (TextView) findViewById(R.id.hard);
        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        level4 = (Button) findViewById(R.id.level4);
        level5 = (Button) findViewById(R.id.level5);
        level6 = (Button) findViewById(R.id.level6);
        retrn = (FloatingActionButton) findViewById(R.id.retrn);

        retrn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(HardActivity.this,FirstScreenActivity.class));
            }
        });

        level1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =1;
                startActivity(new Intent(HardActivity.this,Level1HardActivity.class));
            }
        });

        level2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =2;
                startActivity(new Intent(HardActivity.this,Level1HardActivity.class));
            }
        });

        level3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =3;
                startActivity(new Intent(HardActivity.this,Level1HardActivity.class));
            }
        });

        level4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =4;
                startActivity(new Intent(HardActivity.this,Level1HardActivity.class));
            }
        });

        level5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =5;
                startActivity(new Intent(HardActivity.this,Level1HardActivity.class));
            }
        });

        level6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =6;
                startActivity(new Intent(HardActivity.this,Level1HardActivity.class));
            }
        });
    }
}
