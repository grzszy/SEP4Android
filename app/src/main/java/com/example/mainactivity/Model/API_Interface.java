package com.example.mainactivity.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {

    @GET("")
    Call<API_Response> getCurrent(Current nCurrent);
}
