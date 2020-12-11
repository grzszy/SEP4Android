package com.example.mainactivity.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_Interface {

    @GET("DataValues")
    Call<API_Response> getCurrent();

    @POST("PostAction")
    Call<API_Response> postShaft(@Body boolean action);

    @GET("GetForecast")
    Call<API_ResponseForecast> getForecast(@Query("date") String date);
}
