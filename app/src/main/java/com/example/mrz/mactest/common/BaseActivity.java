package com.example.mrz.mactest.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrz.mactest.R;

public class BaseActivity extends AppCompatActivity {
    public final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
