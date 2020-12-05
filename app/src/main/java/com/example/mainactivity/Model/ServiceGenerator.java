package com.example.mainactivity.Model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
/**
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100,TimeUnit.SECONDS).build();
**/
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()

            .baseUrl(/*"http://62.107.191.85:8080/"*/"http://178.155.241.176:8080/")
            .addConverterFactory(GsonConverterFactory.create());



    private static Retrofit retrofit = retrofitBuilder.build();

    private static API_Interface api = retrofit.create(API_Interface.class);

    public static API_Interface getAPI() {
        return api;
    }

}
