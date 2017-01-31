package com.example.mmtou.englishapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Level1MediumActivity extends AppCompatActivity {
    private TextView level;
    private TextView easy;
    private TextView verb;
    private EditText inf;
    private EditText p2;
    private EditText pp2;
    private Button btn;
    private TextView correct;
    private int i ;
    public static int point = 0;
    private FloatingActionButton retrn;
    public static String correction;
    private PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_medium);

        i = 0;
        level = (TextView) findViewById(R.id.level1);
        easy = (TextView) findViewById(R.id.hard);
        verb = (TextView) findViewById(R.id.verb);
        inf = (EditText) findViewById(R.id.inf2);
        p2 = (EditText) findViewById(R.id.p2);
        pp2 = (EditText) findViewById(R.id.pp2);
        btn = (Button) findViewById(R.id.btnVerify);
        correct = (TextView) findViewById(R.id.correction);
        retrn = (FloatingActionButton) findViewById(R.id.retrn);

        retrn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Dialog dialog = new Dialog(Level1MediumActivity.this);
                dialog.setTitle("Do you want to quit ?");
                dialog.setContentView(R.layout.alertdialog_window);
                dialog.show();
                Button byes = (Button)dialog.findViewById(R.id.yes);
                Button bno = (Button)dialog.findViewById(R.id.no);

                byes.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(Level1MediumActivity.this,MediumActivity.class));
                    }
                });
                bno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                Window window = dialog.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            }
        });

        switch(MediumActivity.numLevel){
            case 1:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(ListVerb.list2Level1[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(ListVerb.list2Level1,i);
                        i++;
                        System.out.println("FUCK");
                    }
                });
                break;
            case 2:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(ListVerb.list2Level2[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(ListVerb.list2Level2,i);
                        i++;
                    }
                });
                break;
            case 3:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(ListVerb.list2Level3[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(ListVerb.list2Level3,i);
                        i++;
                    }
                });
                break;
            case 4:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(ListVerb.listLevel1[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(ListVerb.listLevel1,i);
                        i++;
                        System.out.println("FUCK");
                    }
                });
                break;
            case 5:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(ListVerb.list2Level5[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(ListVerb.list2Level5,i);
                        i++;
                    }
                });
                break;
            case 6:
                level.setText("LEVEL " + MediumActivity.numLevel);
                verb.setText(ListVerb.list2Level6[i][3]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(ListVerb.list2Level6,i);
                        i++;
                    }
                });
                break;
        }
    }


    protected void exercise(String[][] list, int i) {
        if (i < (list.length - 1)) {
            if (((list[i][1]).equals(p2.getText().toString())) && ((list[i][2]).equals(pp2.getText().toString())) && ((list[i][0]).equals(inf.getText().toString()))) {
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                point ++;
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                correction = ((list[i][0]) + "  |  " + (list[i][1]) + "  |  " + (list[i][2]) + "  |  " + (list[i][3]));
                showPopup();
            }
            inf.getText().clear();
            p2.getText().clear();
            pp2.getText().clear();
            verb.setText(list[i+1][3]);
        } else if (i == (list.length - 1)) {
            if (((list[i][1]).equals(p2.getText().toString())) && ((list[i][2]).equals(pp2.getText().toString()))&& ((list[i][0]).equals(inf.getText().toString()))) {
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                point++;
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                correction = ((list[i][0]) + "  |  " + (list[i][1]) + "  |  " + (list[i][2]) + "  |  " + (list[i][3]));
                showPopup();
            }
        } else {
            startActivity(new Intent(Level1MediumActivity.this, EasyActivity.class));
        }
    }



    private void showPopup(){
        try {
            LayoutInflater inflater = (LayoutInflater) Level1MediumActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.pop, (ViewGroup) findViewById(R.id.pop1));
            pw = new PopupWindow(layout, 800, 400, true);
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
            ((TextView) pw.getContentView().findViewById(R.id.correct1)).setText(correction);
            Button close = (Button) layout.findViewById(R.id.button2);
            close.setOnClickListener(cancel);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    };

    private View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pw.dismiss();
            if (i == ListVerb.listLevel1.length) {
                if (EasyActivity.numLevel != 15) {
                    startActivity(new Intent(Level1MediumActivity.this, ScoreActivity.class));
                } else {
                    startActivity(new Intent(Level1MediumActivity.this, ScoreFinalActivity.class));
                }
            }
        }
    };
}
