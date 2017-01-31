package com.example.mmtou.englishapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ArrayList<HashMap<String, String>> feedList= new ArrayList<HashMap<String, String>>();
    private HashMap<String, String> map = new HashMap<String, String>();
    private ListView list;
    private TextView inf;
    private Button close;
    private PopupWindow pw;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView) findViewById(R.id.listview);
        inf = (TextView) findViewById(R.id.infinitive1);

        addList("be", "was,were", "been", "être");
        addList("become", "became", "become", "devenir");
        addList("begin", "began", "begun", "commencer");
        addList("break", "broke", "broken", "briser");
        addList("bring", "brought", "brought", "apporter");
        addList("build", "built", "built", "construire");
        addList("buy", "bought", "bought", "acheter");
        addList("choose", "chose", "chosen", "choisir");
        addList("come", "came", "come", "venir");
        addList("cut","cut","cut","couper");
        addList("do", "did", "done", "faire");
        addList("draw", "drew", "drawn", "dessiner");
        addList("drive", "drove", "driven", "conduire");
        addList("fall", "fell", "fallen", "tomber");
        addList("feel", "felt", "felt", "ressentir");
        addList("find", "found", "found", "trouver");
        addList("get", "got", "gotten", "obtenir");
        addList("give", "gave", "given", "donner");
        addList("go", "went", "gone", "aller");
        addList("grow", "grew", "grown", "grandir");
        addList("have", "had", "had", "avoir");
        addList("hear", "heard", "heard", "entendre");
        addList("hold", "held", "held", "tenir");
        addList("keep", "kept", "kept", "garder");
        addList("know", "knew", "known", "savoir");


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, feedList, R.layout.row_verb, new String[]{"infinitive", "preterite", "pastParticiple", "translate"},
                new int[]{R.id.infinitive1, R.id.preterite1, R.id.pastParticiple1, R.id.translate1});
        list.setAdapter(simpleAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                showPopup();

            }
        });
    }

    protected void addList(String infinitive,String preterite,String participle,String translate){
        map = new HashMap<>();
        map.put("infinitive", infinitive);
        map.put("preterite", preterite);
        map.put("pastParticiple", participle);
        map.put("translate", translate);
        feedList.add(map);
    }

    private void showPopup(){
        try {
            LayoutInflater inflater = (LayoutInflater) ListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.pop_list, (ViewGroup) findViewById(R.id.pop1));
            pw = new PopupWindow(layout, 1000,  650, true);
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
            ((TextView) pw.getContentView().findViewById(R.id.verb1)).setText(feedList.get(pos).get("infinitive"));
            ((TextView) pw.getContentView().findViewById(R.id.correct1)).setText(ListVerb.definition[pos][0]);
            ((TextView) pw.getContentView().findViewById(R.id.example)).setText(ListVerb.definition[pos][1]);
            ((TextView) pw.getContentView().findViewById(R.id.example2)).setText(ListVerb.definition[pos][2]);
            ((TextView) pw.getContentView().findViewById(R.id.example3)).setText(ListVerb.definition[pos][3]);
            close = (Button) layout.findViewById(R.id.button2);
            close.setOnClickListener(cancel);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pw.dismiss();
        }
    };


}
