package com.gmail.mtswetkov.countdowntimer;

import java.util.UUID;

/**
 * Created by Mikhail on 22.03.2017.
 */
public class Tren {

    private UUID mId;
    private String mName;
    private int timerAll;
    private int countEdu;
    private int educ;
    int rest;
    int bigRest;

    public int getTimerAll() {
        return timerAll;
    }

    public void setTimerAll(int timerAll) {
        this.timerAll = timerAll;
    }

    public int getCountEdu() {
        return countEdu;
    }

    public void setCountEdu(int countEdu) {
        this.countEdu = countEdu;
    }

    public int getEduc() {
        return educ;
    }

    public void setEduc(int educ) {
        this.educ = educ;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public int getBigRest() {
        return bigRest;
    }

    public void setBigRest(int bigRest) {
        this.bigRest = bigRest;
    }


    public Tren() {
        mId = UUID.randomUUID();
    }

    public UUID getId(){
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName( String name){
        mName = name;
    }
}
