package com.example.guessthenumber.gameMode;

import android.os.CountDownTimer;

public class TimerModel {

    static int level;
    TimerModelInt timerModelIntG;
    CountDownTimer timerGeneral;


    public void CancelingTimer(){
        timerGeneral.cancel();
    }

    public void setTimerListening(TimerModelInt timerModelIntG){
        this.timerModelIntG = timerModelIntG;

    }

    public void setLevel(int pos) {
        TimerModel.level = pos ;
    }

    public int getLevel() {
        return TimerModel.level ;
    }

    public void timerGeneral() {

        long i = 0;

        if(level == 1){
            i = 20000;
        }

        else if(level == 2){
            i = 15000;
        }

        else if(level == 3){
            i = 10000;

        }

        timerGeneral = new CountDownTimer(i, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerModelIntG.onTick(millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timerModelIntG.onFinish();
            }
        };
        timerGeneral.start();

    }


}



