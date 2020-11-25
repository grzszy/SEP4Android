package com.example.mainactivity.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API_Interface {

    @GET("current.json")
    Call<API_Response> getWeather(String current);
}
