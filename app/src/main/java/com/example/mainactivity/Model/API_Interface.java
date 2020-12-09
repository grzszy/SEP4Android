package com.example.mainactivity.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API_Interface {

    @GET("DataValues")
    Call<API_Response> getCurrent();

    @POST("PostAction")
    Call<API_Response> postShaft(@Body boolean action);

    @GET("Forecast")
    Call<API_ResponseForecast> getForecast(@Path("date") String Date);
}
