package com.example.mainactivity.Model;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API_Interface {

    @GET("DataValues")
    Call<API_Response> getCurrent();

    @POST("/Post action")
    Call<API_Response> postShaft(@Body boolean status);
}
