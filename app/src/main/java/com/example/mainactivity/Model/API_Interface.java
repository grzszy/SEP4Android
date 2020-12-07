package com.example.mainactivity.Model;

import androidx.lifecycle.MutableLiveData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface API_Interface {

    @GET("DataValues")
    Call<API_Response> getCurrent();

    @PUT("PostAction")
    Call<API_Response> postShaft(@Body boolean action);


}
