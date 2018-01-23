package com.mp4.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    UmengUtils umengUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("toString", "onCreate: " + umengUtils.toString() + umengUtils.getTitle());
    }
}
