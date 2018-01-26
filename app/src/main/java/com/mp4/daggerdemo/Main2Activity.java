package com.mp4.daggerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.mp4.daggerdemo.databinding.LayoutBaseActivityBinding;

import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class Main2Activity extends DaggerAppCompatActivity {
    //是否需要标志位标识
    private boolean needToolbar = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setActionBar(toolbar);
    }

    @Override
    public void setContentView(View childView, ViewGroup.LayoutParams childParams) {
        if (needToolbar) {
            LinearLayout parentView = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_base_activity, null);
            parentView.addView(childView, childParams);
            ViewGroup.LayoutParams parentParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            super.setContentView(parentView, parentParams);
        } else {
            super.setContentView(childView, childParams);
        }
    }

    @Override
    public void setContentView(View childView) {
        if (needToolbar) {
            LinearLayout parentView = (LinearLayout) LayoutBaseActivityBinding.inflate(getLayoutInflater()).getRoot();
            parentView.addView(childView);
            super.setContentView(parentView);
        } else {
            super.setContentView(childView);
        }
    }

    @Override
    public void setContentView(int childLayoutResID) {
        if (needToolbar) {
            LinearLayout parentView = (LinearLayout) LayoutBaseActivityBinding.inflate(getLayoutInflater()).getRoot();
            parentView.addView(getLayoutInflater().inflate(childLayoutResID, null));
            super.setContentView(parentView);
        } else {
            super.setContentView(childLayoutResID);
        }
    }

    /**
     * 设置是否需要toolbar，需要在setContentView之前调用。
     *
     * @param needToolbar
     */
    public void setNeedToolbar(boolean needToolbar) {
        this.needToolbar = needToolbar;
    }
}
