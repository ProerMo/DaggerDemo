package com.mp4.daggerdemo;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by mopengfei on 2018-01-22.
 */
@Module
public abstract class AppModule {
    @Binds
    abstract Context bindContext(Application app);
}
