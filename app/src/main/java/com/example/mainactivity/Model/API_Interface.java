package com.example.mainactivity.Model;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Api Interface
 * Takes care of the get/post server calls.
 */
public interface API_Interface {

    /**
     * Method calls GET action on the server.
     * @return Current values form database.
     */
    @GET("DataValues")
    Call<API_Response> getCurrent();

<<<<<<< Updated upstream
    @POST("/PostAction")
    Call<API_Response> postShaft(@Body boolean action);
=======
    /**
     * Method calls POST action on the server and sends a shaft status (on/off) to the database.
     * @param action - boolean that indicates shaft status.
     */
    @POST("PostAction")
    Call<API_Response> postShaft(@Body boolean action);

    /**
     * Method calls GET action on the server
     * @param date - date parameter indicating the date of the forecast to be called.
     * @return Forecast on given date.
     */
    @GET("GetForecast")
    Call<API_ResponseForecast> getForecast(@Query("date") String date);
>>>>>>> Stashed changes
}
