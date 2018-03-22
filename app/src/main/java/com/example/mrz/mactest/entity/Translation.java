package com.example.mrz.mactest.entity;

import android.util.Log;

import java.util.List;
import java.util.Observable;

/**
 * Created by mrz on 2018/3/22.
 */

public class Translation{

    private static final String TAG = "Translation";

        private int status;
    private content content;

    private static class content {
        private String[] word_mean;
//        private String out;

    }
//
    //输出返回数据
    public void show() {
        Log.i(TAG, "show: " + content.word_mean[0]);
    }

}
