package com.mp4.daggerdemo;


import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mopengfei on 2018-01-24.
 */

public interface ExpressService {
    @POST("query")
    Observable<Express> getExpressData(@Query("type") String type, @Query("postid") String postId);
}
