package com.gmail.mtswetkov.countdowntimer;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity  {

    public static final String TIMER_ALL = "TIMER_ALL" ;
    public static final String BIG_REST = "BIG_REST" ;
    public static final String COUNT_EDU = "COUNT_EDU" ;
    public static final String EDU = "EDU" ;
    public static final String REST = "REST" ;
    public Button startButton;
    public Button pButton;
    public Button fButton;
    public int timerAll;
    public int bigRest;
    public int countEdu;
    public int educ;
    public int rest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fButton = (Button)findViewById(R.id.finishButton);

        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, TimerActivity.class);

                TextView tTimerAll; //количество подходов
                tTimerAll = (EditText)findViewById(R.id.timerAll);
                timerAll = Integer.parseInt(tTimerAll.getText().toString());
                i.putExtra(TIMER_ALL, timerAll);


                TextView tcountEdu; //количество упражнений
                tcountEdu = (EditText)findViewById(R.id.countEdu);
                countEdu = Integer.parseInt((tcountEdu.getText().toString()));
                i.putExtra(COUNT_EDU, countEdu);

                TextView teduc; //время на упражнение
                teduc = (EditText)findViewById(R.id.chrEduc);
                educ = Integer.parseInt((teduc.getText().toString()));
                i.putExtra(EDU, educ);

                TextView trest; //отдых между упражнениями
                trest = (EditText)findViewById(R.id.chrRest);
                rest = Integer.parseInt((trest.getText().toString()));
                i.putExtra(REST, rest);

                TextView tbigRest; //отдых между подходами
                tbigRest = (EditText)findViewById(R.id.chrBigRest);
                bigRest = Integer.parseInt((tbigRest.getText().toString()));
                i.putExtra(BIG_REST, bigRest);

                startActivity(i);
            }
        });
    }
}

