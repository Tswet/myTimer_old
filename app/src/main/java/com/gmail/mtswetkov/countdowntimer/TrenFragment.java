/*
package com.gmail.mtswetkov.countdowntimer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

*/
/**
 * Created by Mikhail on 22.03.2017.
 *//*

public class TrenFragment extends Fragment {

    private Tren mTren;
    private EditText mTimerAll;
    private EditText mCountEdu;
    private EditText mEduc;
    private EditText mRest;
    private EditText mBigRest;

    @Override
    public void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mTren = new Tren();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState ){
        View v = inflater.inflate(R.layout.activity_main, parent, false);

        mTimerAll = (EditText)v.findViewById(R.id.timerAll);
        mTimerAll.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mTren.setTimerAll(Integer.parseInt(c.toString()));
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mCountEdu = (EditText)v.findViewById(R.id.countEdu);
        mCountEdu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mTren.setCountEdu(Integer.parseInt(c.toString()));
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });


        mEduc = (EditText)v.findViewById(R.id.chrEduc);
        mEduc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mTren.setEduc(Integer.parseInt(c.toString()));
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mRest = (EditText)v.findViewById(R.id.chrRest);
        mRest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mTren.setRest(Integer.parseInt(c.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBigRest = (EditText)v.findViewById(R.id.chrBigRest);
        mBigRest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mTren.setBigRest(Integer.parseInt(c.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }
}
*/
