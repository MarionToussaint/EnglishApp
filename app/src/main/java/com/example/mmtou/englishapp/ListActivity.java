package com.example.mmtou.englishapp;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {
    private ArrayList<HashMap<String, String>> feedList= new ArrayList<HashMap<String, String>>();
    private HashMap<String, String> map = new HashMap<String, String>();
    private ListView list;
    private Button popup;
    private TextView inf;
    private ArrayList<String> verbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView) findViewById(R.id.listview);
        //popup = (Button) findViewById(R.id.ok);
        inf = (TextView) findViewById(R.id.infinitive1);
        /*inf.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.popup_window,null);
                final PopupWindow popupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                popup = (Button) popupView.findViewById(R.id.ok);
                popup.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAsDropDown(inf,50,-30);
            }
        });*/



        addList("be","was,were","been","être");
        addList("become","became","become","devenir");
        addList("begin","began","begun","commencer");
        addList("break","broke","broken","briser");
        addList("bring","brought","brought","apporter");
        addList("build","built","built","construire");
        addList("buy","bought","bought","acheter");
        addList("choose","chose","chosen","choisir");
        addList("come","came","cut","couper");
        addList("do","did","done","faire");
        addList("draw","drew","drawn","dessiner");
        addList("drive","drove","driven","conduire");
        addList("fall","fell","fallen","tomber");
        addList("feel","felt","felt","ressentir");
        addList("find","found","found","trouver");
        addList("get","got","gotten","obtenir");
        addList("give","gave","given","donner");
        addList("go","went","gone","aller");
        addList("grow","grew","grown","grandir");
        addList("have","had","had","avoir");
        addList("hear","heard","heard","entendre");
        addList("hold","held","held","tenir");
        addList("keep","kept","kept","garder");
        addList("know","knew","known","savoir");


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, feedList, R.layout.row_verb, new String[]{"infinitive", "preterite", "pastParticiple", "translate"},
                new int[]{R.id.infinitive1, R.id.preterite1, R.id.pastParticiple1, R.id.translate1});
        list.setAdapter(simpleAdapter);
    }

    protected void addList(String infinitive,String preterite,String participle,String translate){
        map = new HashMap<String, String>();
        map.put("infinitive", infinitive);
        map.put("preterite", preterite);
        map.put("pastParticiple", participle);
        map.put("translate", translate);
        feedList.add(map);
    }


}
