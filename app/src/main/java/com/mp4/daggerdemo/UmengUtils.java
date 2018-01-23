package com.mp4.daggerdemo;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mopengfei on 2018-01-23.
 */
public class UmengUtils {
    private String title;
    private String content;
    private String img;

    @Inject
    public UmengUtils(String title, String content, String img) {
        this.title = title;
        this.content = content;
        this.img = img;
    }

    @Override
    public String toString() {
        Log.d("toString", "toString: " + super.toString());
        return super.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImg() {
        return img;
    }
}
