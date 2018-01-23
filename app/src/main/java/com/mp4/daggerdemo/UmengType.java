package com.mp4.daggerdemo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by mopengfei on 2018-01-23.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface UmengType {
    String title() default "aaa";
}
