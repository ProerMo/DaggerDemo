package com.mp4.daggerdemo;

import android.content.Intent;
import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;
import rx.Observer;

/**
 * Created by mopengfei on 2018-01-25.
 */

public abstract class ErrorHandleSubscriber<T> implements Observer<T> {
    abstract void onErrorCreate(Throwable e);

    @Override
    public void onError(Throwable t) {
//        Timber.tag("Catch-Error").w(t.getMessage());
        String msg = "未知错误";
        if (t instanceof UnknownHostException) {
            msg = "网络不可用";
        } else if (t instanceof SocketTimeoutException) {
            msg = "请求网络超时";
        } else if (t instanceof HttpException) {
            HttpException httpException = (HttpException) t;
//            if (httpException.code() == 401) {
//                AppUtils.startActivity(new Intent(context, LoginActivity.class));
//                return;
//            }
            msg = convertStatusCode(httpException);
        } else if (t instanceof JsonParseException || t instanceof ParseException || t instanceof JSONException || t instanceof JsonIOException) {
            msg = "数据解析错误";
        }
        Log.d(Constants.NET_LOG_TAG, "onError: " + msg);
        onErrorCreate(t);
    }

    private String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() == 500) {
            msg = "服务器发生错误，请检查你的版本是否有更新并更新到最新版本";
        } else if (httpException.code() == 404) {
            msg = "请求地址不存在，请检查你的版本是否有更新并更新到最新版本";
        } else if (httpException.code() == 403) {
            msg = "请求被服务器拒绝";
        } else if (httpException.code() == 307) {
            msg = "请求被重定向到其他页面";
        } else {
            msg = httpException.message();
        }
        return msg;
    }
}
