package com.mp4.daggerdemo;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mopengfei on 2018-01-25.
 */
@Module
public abstract class ConfigModule {
    @Provides
    static OkHttpClient getNetClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(Constants.CONNECTTIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Log.d(Constants.NET_LOG_TAG, "request: " + chain.request().toString());
//                        ;
//                        Log.d(Constants.NET_LOG_TAG, "response: " + chain.proceed(chain.request()).body().string());
                        Log.d(Constants.NET_LOG_TAG, "response: " + chain.proceed(chain.request()).toString());

                        return chain.proceed(chain.request());
                    }
                })
                .build();
    }
    @Provides
    static Retrofit getNetRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
