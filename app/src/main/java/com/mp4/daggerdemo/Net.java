package com.mp4.daggerdemo;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mopengfei on 2018-01-24.
 */

public class Net {
    private static Retrofit retrofit;

    static {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Constants.CONNECTTIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Log.d(Constants.NET_LOG_TAG, "request: " + chain.request().toString());
                        Log.d(Constants.NET_LOG_TAG, "response: " + chain.proceed(chain.request()).body().string());

                        return chain.proceed(chain.request());
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static synchronized Retrofit getInstance() {
        return retrofit;
    }
    private Net(){

    }
}
