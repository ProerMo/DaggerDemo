package com.mp4.daggerdemo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mopengfei on 2018-01-22.
 */
@Singleton
@Component(modules = {AppModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder app(Application app);

        AppComponent build();
    }
}
