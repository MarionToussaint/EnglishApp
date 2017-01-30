package com.example.mmtou.englishapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.renderscript.ScriptGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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

public class Level1EasyActivity extends AppCompatActivity {
    private TextView level;
    private TextView easy;
    private TextView verb;
    private EditText p1;
    private EditText pp1;
    private Button btn;
    private TextView correct;
    private int i ;
    public static int point = 0;
    private Button close;
    private PopupWindow pw;
    private FloatingActionButton retrn;
    public static String correction;
    private String message;

    private String[][] list = new String[][] {{"be","was","been","être"}, {"have","had","had","avoir"} ,{"do","did","done","faire"},{"go","went","gone","aller"}};
    private String[][] list1 = new String[][] {{"become","became","become","devenir"}, {"begin","began","begun","commencer"} ,{"bring","brought","brought","apporter"},{"build","built","built","construire"}};
    private String[][] list2 = new String[][] {{"buy","bought","bought","acheter"}, {"come","came","come","venir"} ,{"cut","cut","cut","couper"},{"drive","drove","driven","conduire"}};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_easy);

        i=0;
        level = (TextView) findViewById(R.id.level1);
        easy = (TextView) findViewById(R.id.hard);
        verb = (TextView) findViewById(R.id.verb);
        p1 = (EditText) findViewById(R.id.infinitive3);
        pp1 = (EditText) findViewById(R.id.preterite3);
        btn = (Button) findViewById(R.id.btnVerify);
        correct = (TextView) findViewById(R.id.correct1);
        retrn = (FloatingActionButton) findViewById(R.id.retrn);

        retrn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //startActivity(new Intent(Level1EasyActivity.this,EasyActivity.class));
                //dialog();
                final Dialog dialog = new Dialog(Level1EasyActivity.this);
                dialog.setTitle("Do you want to quit ?");
                dialog.setContentView(R.layout.alertdialog_window);
                dialog.show();
                Button byes = (Button)dialog.findViewById(R.id.yes);
                Button bno = (Button)dialog.findViewById(R.id.no);

                byes.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(Level1EasyActivity.this,FirstScreenActivity.class));
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

        switch(EasyActivity.numLevel){
            case 1:
                level.setText("LEVEL " + EasyActivity.numLevel);
                verb.setText(list[i][0]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(list,i);
                        i++;
                    }
                });
            break;
            case 2:
                level.setText("LEVEL " + EasyActivity.numLevel);
                verb.setText(list1[i][0]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(list1,i);
                        i++;
                    }
                });
            break;
            case 3:
                level.setText("LEVEL " + EasyActivity.numLevel);
                verb.setText(list2[i][0]);
                btn.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        exercise(list2,i);
                        i++;
                    }
                });
                break;
        }

        //verb.setText(list[i][0]);

        /*btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                exercise(list,i);
                i++;
            }
        });*/

    }

    protected void exercise(String[][] list, int i) {
        //correct.setText("");
        if (i < (list.length - 1)) {
            if (((list[i][1]).equals(p1.getText().toString())) && ((list[i][2]).equals(pp1.getText().toString()))) {
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                point ++;
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                correction = ((list[i][0]) + "  |  " + (list[i][1]) + "  |  " + (list[i][2]) + "  |  " + (list[i][3]));
                showPopup();

            }
            p1.getText().clear();
            pp1.getText().clear();
            verb.setText(list[i+1][0]);
        } else if (i == (list.length - 1)) {
            if (((list[i][1]).equals(p1.getText().toString())) && ((list[i][2]).equals(pp1.getText().toString()))) {
                Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                point++;
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                correction = ((list[i][0]) + "  |  " + (list[i][1]) + "  |  " + (list[i][2]) + "  |  " + (list[i][3]));
                showPopup();
            }
            if (EasyActivity.numLevel != 3) {
                startActivity(new Intent(Level1EasyActivity.this, ScoreActivity.class));
            }
            else {
                startActivity(new Intent(Level1EasyActivity.this, ScoreFinalActivity.class));
            }
        } else {
            startActivity(new Intent(Level1EasyActivity.this, EasyActivity.class));
        }
    }



    private void showPopup(){
        try {
            LayoutInflater inflater = (LayoutInflater) Level1EasyActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.pop, (ViewGroup) findViewById(R.id.pop1));
            pw = new PopupWindow(layout, 600, 350, true);
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
            ((TextView) pw.getContentView().findViewById(R.id.correct1)).setText(correction);
            close = (Button) layout.findViewById(R.id.button2);
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
        }
    };

}
