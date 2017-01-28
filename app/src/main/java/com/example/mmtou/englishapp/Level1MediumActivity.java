package com.example.mmtou.englishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Level1MediumActivity extends AppCompatActivity {
    private TextView level;
    private TextView easy;
    private TextView verb;
    private EditText inf;
    private EditText p1;
    private EditText pp1;
    private Button btn;
    private TextView correct;
    private int i ;
    public static int point = 0;

    private String[][] list = new String[][] {{"be","was","been","être"}, {"have","had","had","avoir"} ,{"do","did","done","faire"},{"go","went","gone","aller"}};
    private String[][] list1 = new String[][] {{"become","became","become","devenir"}, {"begin","began","begun","commencer"} ,{"bring","brought","brought","apporter"},{"build","built","built","construire"}};
    private String[][] list2 = new String[][] {{"buy","bought","bought","acheter"}, {"come","came","come","venir"} ,{"cut","cut","cut","couper"},{"drive","drove","driven","conduire"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_medium);

        i = 0;
        level = (TextView) findViewById(R.id.level1);
        easy = (TextView) findViewById(R.id.hard);
        verb = (TextView) findViewById(R.id.verb);
        inf = (EditText) findViewById(R.id.infinitive3);
        p1 = (EditText) findViewById(R.id.preterite3);
        pp1 = (EditText) findViewById(R.id.participle2);
        btn = (Button) findViewById(R.id.btnVerify);
        correct = (TextView) findViewById(R.id.correction);

        switch(EasyActivity.numLevel){
            case 1:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(list[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(list,i);
                        i++;
                    }
                });
                break;
            case 2:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(list1[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(list1,i);
                        i++;
                    }
                });
                break;
            case 3:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(list2[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(list2,i);
                        i++;
                    }
                });
                break;
        }
    }


    protected void exercise(String[][] list, int i) {
        String next;
        correct.setText("");
        if (i < (list.length - 1)) {
            if (((list[i][1]).equals(p1.getText().toString())) && ((list[i][2]).equals(pp1.getText().toString())) && ((list[i][0]).equals(inf.getText().toString()))) {
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                point ++;
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                correct.setText("Correction : " + (list[i][0]) + " | " + (list[i][1]) + " | " + (list[i][2]) + " | " + (list[i][3]));
            }
            p1.getText().clear();
            pp1.getText().clear();
            verb.setText(list[i+1][3]);
        } else if (i == (list.length - 1)) {
            if (((list[i][1]).equals(p1.getText().toString())) && ((list[i][2]).equals(pp1.getText().toString()))) {
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                point++;
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                correct.setText("Correction : " + (list[i][0]) + " | " + (list[i][1]) + " | " + (list[i][2]) + " | " + (list[i][3]));
            }
            if (EasyActivity.numLevel != 3) {
                startActivity(new Intent(Level1MediumActivity.this, ScoreActivity.class));
            }
            else {
                startActivity(new Intent(Level1MediumActivity.this, ScoreFinalActivity.class));
            }
        } else {
            startActivity(new Intent(Level1MediumActivity.this, EasyActivity.class));
        }
    }
}
