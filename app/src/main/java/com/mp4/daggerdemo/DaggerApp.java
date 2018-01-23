package com.mp4.daggerdemo;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by mopengfei on 2018-01-22.
 */

public class DaggerApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().app(this).build();
    }
}
