package com.example.user.net_test;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface HelloApi {

    @GET("/api/v1/hello")
    Single<HelloMessage> getHelloMessage();

}
