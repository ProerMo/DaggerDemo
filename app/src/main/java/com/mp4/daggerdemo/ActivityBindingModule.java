package com.mp4.daggerdemo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mopengfei on 2018-01-23.
 */
@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
