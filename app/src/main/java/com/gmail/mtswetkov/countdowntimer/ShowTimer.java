package com.gmail.mtswetkov.countdowntimer;

import android.media.MediaPlayer;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Mikhail on 23.08.2017.
 */
/*public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }*/

    public class ShowTimer extends MyCountDownTimer {

        TextView chStatus;
        TextView chView;
        TextView inSetView;
        TextView allSetView;
        String status;
        ArrayList<ShowTimer> ar;
        int i;
        int mills;
        MediaPlayer mp;
        int inset;


        public ShowTimer(int sec, TextView chViev, TextView chStatus, String status, ArrayList<ShowTimer> ar, int i, MediaPlayer mp, TextView inSetView, TextView allSetView) {
            super(sec * 1000, 1000);
            this.mills = sec * 1000;
            this.chStatus = chStatus;
            this.chView = chViev;
            this.inSetView = inSetView;
            this.allSetView = allSetView;
            this.status = status;
            this.ar = ar;
            this.i = i;
            this.mp = mp;
        }

        @Override
        public void onTick(int mills) {
            chStatus.setText(status);
            int allset = TimerActivity.getALLSET();
            allSetView.setText(String.format("%02d", allset));

            if (chStatus.getText().equals(TimerActivity.WORK)) {
                TimerActivity.getMBGLL().setBackgroundColor(TimerActivity.WORKCOLOR);
                chView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,200);
                if ((mills/1000) >99) chView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,120);
                inset = TimerActivity.getINSET();
                if (inset <= allset) {
                    inSetView.setText(String.format("%02d", inset));
                }

            }
            if (chStatus.getText().equals(TimerActivity.REST)) {
                TimerActivity.getMBGLL().setBackgroundColor(TimerActivity.RESTCOLOR);
                chView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,200);
                if ((mills/1000) >99) chView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,120);
            }
            if (chStatus.getText().equals(TimerActivity.BIGREST)) {
                TimerActivity.getMBGLL().setBackgroundColor(TimerActivity.BIGRESTCOLOR);
                chView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,200);
                if ((mills/1000) >99) chView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,120);
            }
            TimerActivity.setINTICK(Integer.parseInt(String.format("%02d", (mills - 1) / 1000)));

            chView.setText(String.format("%02d", (mills - 1) / 1000));  // mills-1 для убирания проблемы, что long некорректно делится на int
            System.out.println(String.format("%02d", (mills - 1) / 1000));
        }

        @Override
        public void onFinish() {
            mp.start();
            i++;
            TimerActivity.setINUSE(i);
            if (chStatus.getText().equals(TimerActivity.WORK)) {
                inset = TimerActivity.getINSET();
                inset++;
                TimerActivity.setINSET(inset);
            }
            int arlenght = TimerActivity.ARLENGHT;
            if (arlenght - 1 > i) {
                ar.get(i).start();
                this.cancel();
            } else {
                chStatus.setText(TimerActivity.DONE);
                this.cancel();
            }

        }
    }
