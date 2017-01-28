package com.example.mmtou.englishapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EasyActivity extends AppCompatActivity {
    private TextView easy;
    private Button level1;
    private Button level2;
    private Button level3;
    public static int numLevel;
    private FloatingActionButton retrn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        easy = (TextView) findViewById(R.id.hard);
        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        retrn = (FloatingActionButton) findViewById(R.id.retrn);

        retrn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(EasyActivity.this,FirstScreenActivity.class));
                //createDialog();
            }
        });

        level1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =1;
                startActivity(new Intent(EasyActivity.this,Level1EasyActivity.class));
            }
        });

        level2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =2;
                startActivity(new Intent(EasyActivity.this,Level1EasyActivity.class));
            }
        });

        level3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                numLevel =3;
                startActivity(new Intent(EasyActivity.this,Level1EasyActivity.class));
            }
        });
    }

    /*public void createDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you sure ?");
        alert.setCancelable(false);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(EasyActivity.this,FirstScreenActivity.class));
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }*/
}
