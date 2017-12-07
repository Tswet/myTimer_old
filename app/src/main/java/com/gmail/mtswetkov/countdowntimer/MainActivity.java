package com.gmail.mtswetkov.countdowntimer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String TIMER_ALL = "TIMER_ALL" ;
    public static final String BIG_REST = "BIG_REST" ;
    public static final String COUNT_EDU = "COUNT_EDU" ;
    public static final String EDU = "EDU" ;
    public static final String REST = "REST" ;
    public Button startButton;
    public int timerAll;
    public int bigRest;
    public int countEdu;
    public int educ;
    public int rest;

    TextView tTimerAll; //количество подходов
    TextView tcountEdu; //количество упражнений
    TextView teduc; //время на упражнение
    TextView trest; //отдых между упражнениями
    TextView tbigRest; //отдых между подходами

    //переменные для сохранения последней тренеровки
    public static final String MY_SET = "mySet";
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // загружаем последнюю тренеровку
        sPref = getSharedPreferences(MY_SET, Context.MODE_PRIVATE);

        int setEd = sPref.getInt("SET_ED", 0);
        int setRe = sPref.getInt("SET_RE", 0);
        int setCed = sPref.getInt("SET_CED", 0);
        int setBr = sPref.getInt("SET_BR", 0);
        int setCic = sPref.getInt("SET_CIC", 0);
        System.out.println("ed=" + setEd);

        tTimerAll = (EditText)findViewById(R.id.timerAll);
        if(setCic !=0){
            tTimerAll.setText(String.format("%02d", setCic));
        }
        tcountEdu = (EditText)findViewById(R.id.countEdu);
        if(setCed !=0){
            tcountEdu.setText(String.format("%02d", setCed));
        }
        teduc = (EditText)findViewById(R.id.chrEduc);
        if(setEd !=0){
            teduc.setText(String.format("%02d", setEd));
        }
        trest = (EditText)findViewById(R.id.chrRest);
        if(setRe !=0){
            trest.setText(String.format("%02d", setRe));
        }
        tbigRest = (EditText)findViewById(R.id.chrBigRest);
        if(setBr !=0){
            tbigRest.setText(String.format("%02d", setBr));
        }

        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, TimerActivity.class);

                timerAll = Integer.parseInt(tTimerAll.getText().toString());
                i.putExtra(TIMER_ALL, timerAll);

                countEdu = Integer.parseInt((tcountEdu.getText().toString()));
                i.putExtra(COUNT_EDU, countEdu);

                educ = Integer.parseInt((teduc.getText().toString()));
                i.putExtra(EDU, educ);

                rest = Integer.parseInt((trest.getText().toString()));
                i.putExtra(REST, rest);

                bigRest = Integer.parseInt((tbigRest.getText().toString()));
                i.putExtra(BIG_REST, bigRest);

                SharedPreferences.Editor ed = sPref.edit();
                ed.putInt("SET_ED", educ);
                ed.putInt("SET_RE", rest);
                ed.putInt("SET_CED", countEdu);
                ed.putInt("SET_BR", bigRest);
                ed.putInt("SET_CIC", timerAll);
                ed.commit();

                startActivity(i);
            }
        });
    }
}

