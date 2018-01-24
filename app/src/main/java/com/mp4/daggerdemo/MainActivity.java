package com.mp4.daggerdemo;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@ActivityScoped
public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    UmengUtils umengUtils;

    @Inject
    UmengUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("toString", "onCreate: " + umengUtils.toString() + umengUtils.getTitle());
        Log.d("toString", "onCreate: " + utils.toString() + utils.getTitle());
        Net.getInstance().create(ExpressService.class)
                .getExpressData("yuantong", "888193610542153875")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Express>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Express express) {
                        Log.d(Constants.BEAN_LOG_TAG, "onNext: " + express.getNu() + express.getData().toString());
                    }
                });
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Log.d(Constants.THREAD_LOG_TAG, "run: "+Net.getInstance());
                }
            }).run();

        }

    }
}
