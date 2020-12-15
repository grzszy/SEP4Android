package com.example.mainactivity.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_Interface {

    @GET("DataValues")
    Call<API_Response> getCurrent();

    @GET("GetAverageNumberOfPeople")
    Call<API_Response> getAverageNumberPeople();

    @POST("PostAction")
    Call<API_Response> postShaft(@Body boolean action);

    @GET("GetForecast")
    Call<API_ResponseForecast> getForecast(@Query("date") String date);


    @GET("GetLogList")
    Call<ArrayList<API_LogResponce>> getLog();

/*
    @GET("GetLogList")
    Call<List<API_ResponseForecast>> getLog();


 */

}
