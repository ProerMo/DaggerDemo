package com.mp4.daggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mopengfei on 2018-01-22.
 */
@Module
public abstract class MainModule {
    @Provides
    @ActivityScoped
    static UmengUtils getUmengUtils() {
        return new UmengUtils("我的日志", "hahaa", "picccccccc");
    }
}
