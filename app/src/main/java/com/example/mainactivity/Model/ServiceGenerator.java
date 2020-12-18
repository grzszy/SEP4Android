package com.example.mainactivity.Model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    /**
     * @author Jakob Hansen
     */

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()

            .baseUrl(/*Anton: *//*"http://62.107.191.85:8080/"*/
                     //"http://178.155.241.176:8080/")
                    "http://212.10.149.241:8080/")
            .addConverterFactory(GsonConverterFactory.create());





    private static Retrofit retrofit = retrofitBuilder.build();

    private static API_Interface api = retrofit.create(API_Interface.class);

    /**
     * Getter for API.
     * @return Instance of API_Interface.
     */
    public static API_Interface getAPI() {
        return api;
    }

}
