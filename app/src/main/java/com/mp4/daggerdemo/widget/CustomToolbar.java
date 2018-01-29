package com.mp4.daggerdemo.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mp4.daggerdemo.R;
import com.mp4.daggerdemo.databinding.LayoutToolbarBinding;

/**
 * Created by mopengfei on 2018-01-26.
 */

public class CustomToolbar extends LinearLayout {

    private Drawable leftDrawable;
    private String title;
    private Drawable rightDrawable;
    private boolean leftBackable;
    private boolean leftShowable = true;
    private boolean rightShowable;
    private boolean titleShowable;

    public CustomToolbar(Context context) {
        super(context);
        initAttrs(null, 0, 0);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs, 0, 0);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(attrs, defStyleAttr, defStyleRes);

    }

    private void initAttrs(AttributeSet attributeSet, int defStyleAttr, int defStyleRes) {
        if (null != attributeSet) {
            TypedArray array = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomToolbar, defStyleAttr, defStyleRes);
            if (array.hasValue(R.styleable.CustomToolbar_left_img_src)) {
                leftDrawable = array.getDrawable(R.styleable.CustomToolbar_left_img_src);
            }
            if (array.hasValue(R.styleable.CustomToolbar_text_str)) {
                title = array.getString(R.styleable.CustomToolbar_text_str);
            }
            if (array.hasValue(R.styleable.CustomToolbar_right_img_src)) {
                rightDrawable = array.getDrawable(R.styleable.CustomToolbar_right_img_src);
            }
            if (array.hasValue(R.styleable.CustomToolbar_left_backable)) {
                leftBackable = array.getBoolean(R.styleable.CustomToolbar_left_backable, false);
            }
            if (array.hasValue(R.styleable.CustomToolbar_left_showable)) {
                leftShowable = array.getBoolean(R.styleable.CustomToolbar_left_showable, true);
            }
            if (array.hasValue(R.styleable.CustomToolbar_right_showable)) {
                rightShowable = array.getBoolean(R.styleable.CustomToolbar_right_showable, false);
            }
            if (array.hasValue(R.styleable.CustomToolbar_title_showable)) {
                titleShowable = array.getBoolean(R.styleable.CustomToolbar_title_showable, false);
            }
            array.recycle();
        }
        initView();
    }

    private void initView() {
        LayoutToolbarBinding binding = LayoutToolbarBinding.inflate(LayoutInflater.from(getContext()), this, true);
        if (titleShowable) {
            if (null != title) {
                binding.setTitle(title);
            }
            binding.titleView.setVisibility(VISIBLE);
        } else {
            binding.titleView.setVisibility(INVISIBLE);
        }
        if (null != leftDrawable) {
            binding.leftIcon.setImageDrawable(leftDrawable);
        }
        if (null != rightDrawable) {
            binding.rightIcon.setImageDrawable(rightDrawable);
        }
        if (leftShowable) {
            binding.leftIcon.setVisibility(VISIBLE);
            binding.leftIcon.setOnClickListener(leftOnclickListener);
        } else {
            binding.leftIcon.setVisibility(INVISIBLE);
        }
        if (rightShowable) {
            binding.rightIcon.setVisibility(VISIBLE);
            binding.rightIcon.setOnClickListener(rightOnClickListener);
        } else {
            binding.rightIcon.setVisibility(INVISIBLE);
        }

    }

    private OnClickListener leftOnclickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (leftBackable) {
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).finish();
                }
            }
        }
    };
    private OnClickListener rightOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public void setLeftOnclickListener(OnClickListener leftOnclickListener) {
        this.leftOnclickListener = leftOnclickListener;
    }

    public void setRightOnClickListener(OnClickListener rightOnClickListener) {
        this.rightOnClickListener = rightOnClickListener;
    }
}
