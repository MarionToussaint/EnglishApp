package com.example.mmtou.englishapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MediumActivity extends AppCompatActivity {
    private TextView medium;
    private Button level1;
    private Button level2;
    private Button level3;
    public static int numLevel;
    private FloatingActionButton retrn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);


        medium = (TextView) findViewById(R.id.hard);
        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        retrn = (FloatingActionButton)findViewById(R.id.retrn);

        retrn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MediumActivity.this,FirstScreenActivity.class));
            }
        });

        level1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel = 1;
                startActivity(new Intent(MediumActivity.this,Level1MediumActivity.class));
            }
        });

        level2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel = 2;
                startActivity(new Intent(MediumActivity.this,Level1MediumActivity.class));
            }
        });

        level3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel = 3;
                startActivity(new Intent(MediumActivity.this,Level1MediumActivity.class));
            }
        });
    }

}
