package com.gmail.mtswetkov.countdowntimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by Mikhail on 23.03.2017.
 */
public class TimerActivity extends Activity {

    private static final int MILLIS_PER_SECOND = 1000;
    public TextView chronView;
    public TextView chStatus;
    public CountDownTimer timer;

    public int timerAll;
    public int bigRest;
    public int countEdu;
    public int educ;
    public int rest;
    //public boolean isFinish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronView = (TextView) findViewById(R.id.chronView);
        chStatus = (TextView) findViewById(R.id.chronText);

        //получаем данные из Активити Мэйн
        Intent i = getIntent();
        timerAll = i.getIntExtra(MainActivity.TIMER_ALL, 10);
        bigRest = i.getIntExtra(MainActivity.BIG_REST, 10);
        countEdu = i.getIntExtra(MainActivity.COUNT_EDU, 10);
        educ = i.getIntExtra(MainActivity.EDU, 10);
        rest = i.getIntExtra(MainActivity.REST, 10);

        try {
            System.out.println(timerAll);
            System.out.println(countEdu);
            System.out.println(educ);
            System.out.println(rest);
            System.out.println(bigRest);
            for (int z = 1; z <= timerAll; z++) {
                for (int j = 1; j <= countEdu; j++) {
                    chStatus.setText("WORKOUT");
                    Thread thread1 = new Thread(new ShowTimer((long) educ*MILLIS_PER_SECOND));
                    thread1.start();
                    try {
                        thread1.join(educ*MILLIS_PER_SECOND);
                    } catch (InterruptedException e) {

                    };
                    //showTimer(educ*MILLIS_PER_SECOND);
                    System.out.println("work");
                    chStatus.setText("REST");
                    Thread thread2 = new Thread(new ShowTimer((long) rest*MILLIS_PER_SECOND));
                    thread2.start();
                    try {
                        thread2.join(rest*MILLIS_PER_SECOND);
                    } catch (InterruptedException e) {

                    };
                    // showTimer(rest * MILLIS_PER_SECOND);
                    System.out.println("rest");
                }

                chStatus.setText("BIG REST");
                if(z== timerAll){
                    chStatus.setText("DONE");
                    //bigRest = 0;
                    //timer.cancel();
                }
                Thread thread3 = new Thread(new ShowTimer((long) bigRest*MILLIS_PER_SECOND));
                thread3.start();
                try {
                    thread3.join(bigRest*MILLIS_PER_SECOND);
                } catch (InterruptedException e) {

                };
                //showTimer(bigRest * MILLIS_PER_SECOND);
                System.out.println(bigRest);

            }
        } catch (NumberFormatException e) {
            // method ignores invalid (non-integer) input and waits
            // for something it can use
        }
    }

/*
    private void showTimer(long countdownMillis)   {

        timer = new CountDownTimer(countdownMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                System.out.println("enter");
                chronView.setText(""+ millisUntilFinished/MILLIS_PER_SECOND);
            }

            @Override
            public void onFinish() {
                System.out.println("Done");
                timer.cancel();
            }

            public void stop() {
                timer.cancel();
                timer = null;
            }
        }.start();

    }
*/

    private class ShowTimer implements Runnable {
        public ShowTimer(long countdownMillis) {
            timer = new CountDownTimer(countdownMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    System.out.println("enter");
                    chronView.setText(""+ millisUntilFinished/MILLIS_PER_SECOND);
                }

                @Override
                public void onFinish() {
                    System.out.println("Done");
                    timer.cancel();
                }

                public void stop() {
                    timer.cancel();
                    timer = null;
                }
            };
        }

        @Override
        public void run() {
            timer.start();
        }
    }
}

