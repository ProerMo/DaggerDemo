package com.mp4.daggerdemo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.Toolbar;

import com.mp4.daggerdemo.databinding.LayoutToolbarBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.plugins.RxJavaErrorHandler;
import rx.schedulers.Schedulers;

@ActivityScoped
public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    UmengUtils umengUtils;

    @Inject
    UmengUtils utils;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
//        View toolbarView = LayoutToolbarBinding.inflate(getLayoutInflater()).getRoot();
//        toolbarView.setLayoutParams(params);
//        Toolbar toolbar = new Toolbar(MainActivity.this);
//        toolbar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50));
//        toolbar.addView(toolbarView);
//        setNeedToolbar(false);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        addContentView(toolbar,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50));
//        setSupportActionBar(toolbar);
        Log.d("toString", "onCreate: " + umengUtils.toString() + umengUtils.getTitle());
        Log.d("toString", "onCreate: " + utils.toString() + utils.getTitle());
//        Net.getInstance().create(ExpressService.class)
//                .getExpressData("yuantong", "888193610542153875")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Express>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Express express) {
//                        Log.d(Constants.BEAN_LOG_TAG, "onNext: " + express.getNu() + express.getData().toString());
//                    }
//                });
        retrofit.create(ExpressService.class)
                .getExpressData("yuantong", "888193610542153875")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<Express>() {
                    @Override
                    void onErrorCreate(Throwable e) {
                        Log.d(Constants.NET_LOG_TAG, "onErrorCreate: " + e.getMessage().toString());
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onNext(Express express) {

                    }

                });

//        new Subscriber<Express>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Express express) {
//                Log.d(Constants.BEAN_LOG_TAG, "onNext: " + express.getNu() + express.getData().toString());
//            }
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Log.d(Constants.THREAD_LOG_TAG, "run: " + Net.getInstance());
                }
            }).run();

        }

    }
}
