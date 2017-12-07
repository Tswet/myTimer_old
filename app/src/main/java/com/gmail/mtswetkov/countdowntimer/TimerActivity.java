package com.gmail.mtswetkov.countdowntimer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Mikhail on 23.03.2017.
 */
public class TimerActivity extends Activity {


    public TextView chronView;
    public TextView chStatus;
    public TextView inSetView;
    public TextView allSetView;

    public int timerAll;
    public int bigRest;
    public int countEdu;
    public int educ;
    public int rest;

    public static Button getfButton() {
        return fButton;
    }

    public static Button getpButton() {
        return pButton;
    }

    public static Button fButton;
    public static Button pButton;
    public String pStatus;
    final ArrayList<ShowTimer> ar = new ArrayList<>();




    public static void setMBGLL(LinearLayout MBGLL) {
        TimerActivity.MBGLL = MBGLL;
    }

    public static LinearLayout getMBGLL() {
        return MBGLL;
    }

    public static void setINUSE(int INUSE) {
        TimerActivity.INUSE = INUSE;
    }

    public static void setINTICK(int INTICK) {
        TimerActivity.INTICK = INTICK;
    }

    public static LinearLayout MBGLL; // определение цвета бэкграунда
    //набор статических переменных для работы кнопок
    public static int INUSE = 0; //индекс активного элемента массива
    public static int INTICK = 0;   //использкется для работы паузы. Запоминается тик в сете
    public static int ARLENGHT = 0; //общая длина массива упражнений. используется для закрытия приложения

    public static int getINSET() {
        return INSET;
    }

    public static void setINSET(int INSET) {
        TimerActivity.INSET = INSET;
    }

    public static int getALLSET() {
        return ALLSET;
    }

    //набор статических переменных для отображения общего счетчика
    public static int INSET = 1;
    public static int ALLSET = 0;
    //набор статических  переменных для цветов
    public static int WORKCOLOR;
    public static int RESTCOLOR;
    public static int BIGRESTCOLOR;
    //набор статических  переменных для статусов
    public static String WORK;
    public static String REST;
    public static String BIGREST;
    public static String DONE;
    //набор статических  переменных для названия кнопок
    public static String PAUSE;
    public static String RESUME;
    //набор статических  переменных для стилей кнопок





    @Override
    protected void onStop() {
        ar.get(0).cancel();
        ar.get(INUSE).cancel();
        super.onStop();
    }

    @Override
    public void finish() {
        ar.get(0).cancel();
        ar.get(INUSE).cancel();
        super.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //не  выключать экрвн
        chronView = (TextView) findViewById(R.id.chronView);
        chStatus = (TextView) findViewById(R.id.chronText);
        inSetView = (TextView) findViewById(R.id.partEdu);
        allSetView = (TextView) findViewById(R.id.fromEdu);
        pButton = (Button)findViewById(R.id.pauseButton);
        fButton = (Button)findViewById(R.id.finishButton);
        MBGLL = (LinearLayout) findViewById(R.id.timerLayout);
        //получаем данные из Активити Мэйн
        Intent i = getIntent();
        timerAll = i.getIntExtra(MainActivity.TIMER_ALL, 10);
        bigRest = i.getIntExtra(MainActivity.BIG_REST, 10);
        countEdu = i.getIntExtra(MainActivity.COUNT_EDU, 10);
        educ = i.getIntExtra(MainActivity.EDU, 10);
        rest = i.getIntExtra(MainActivity.REST, 10);

        WORKCOLOR = this.getResources().getColor(R.color.bgBed);
        RESTCOLOR = this.getResources().getColor(R.color.bgRest);
        BIGRESTCOLOR = this.getResources().getColor(R.color.bgBrest);
        WORK = String.valueOf(this.getResources().getString(R.string.workout));
        REST = String.valueOf(this.getResources().getString(R.string.rest));
        BIGREST = String.valueOf(this.getResources().getString(R.string.big_rest));
        DONE = String.valueOf(this.getResources().getString(R.string.done));
        PAUSE = String.valueOf(this.getResources().getString(R.string.pause_button));
        RESUME = String.valueOf(this.getResources().getString(R.string.pause_button_resume));

        int count =0;
        final MediaPlayer alarm = MediaPlayer.create(this, R.raw.alarm);
        final MediaPlayer reload = MediaPlayer.create(this, R.raw.ring1s);

        fButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tick = INTICK;
                int inuse = INUSE;
                pStatus = (String) chStatus.getText();
                if(pButton.getText().equals(TimerActivity.PAUSE)){
                    pButton.setText(TimerActivity.RESUME);
                    ar.get(INUSE).cancel();

                }else {
                    pButton.setText(TimerActivity.PAUSE);
                    ar.remove(inuse);
                    ar.add(inuse, new ShowTimer(tick , chronView, chStatus, pStatus, ar, inuse, alarm, inSetView, allSetView ));
                    ar.get(inuse).start();
                }
            }
        });

        ar.add(new ShowTimer(5,chronView, chStatus, "Ready", ar, count, alarm, inSetView, allSetView));
        for(int j = 0; j<timerAll; j++){
            for(int h = 0; h < countEdu;h++){
                count = ar.size()-1;
                count++;
                ar.add(new ShowTimer(educ , chronView, chStatus, WORK, ar, count, reload, inSetView, allSetView ));
                count++;
                ar.add(new ShowTimer(rest, chronView, chStatus, REST, ar, count, alarm, inSetView, allSetView));
            }
            count = ar.size()-1;
            count++;
            ar.add(new ShowTimer( bigRest, chronView, chStatus,  BIGREST, ar , count, alarm,  inSetView, allSetView));
        }
        ARLENGHT = ar.size();
        ALLSET = countEdu*timerAll ;

        ar.get(0).start();

    }
}
