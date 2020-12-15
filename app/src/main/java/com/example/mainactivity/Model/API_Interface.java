package com.example.mainactivity.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_Interface {

    /**
     * Method defining GET action in the API.
     * @return DataValues for temperature, humidity, CO2, number of passengers and shaft status.
     */
    @GET("DataValues")
    Call<API_Response> getCurrent();

    /**
     * Method defining GET action in the API.
     * @return Average number of people.
     */
    @GET("GetAverageNumberOfPeople")
    Call<API_Response> getAverageNumberPeople();

    /**
     * Method defining POST action in the API.
     * @param action boolean (true - shaft on; false - shaft off)
     */
    @POST("PostAction")
    Call<API_Response> postShaft(@Body boolean action);

    /**
     * Method defining GET action in the API
     * @param date Specified date for receiving the forecast.
     * @return Forecast for specified date.
     */
    @GET("GetForecast")
    Call<API_ResponseForecast> getForecast(@Query("date") String date);

    /**
     * Method defining GET action in the API.
     * @return Log.
     */
    @GET("GetLog")
    Call<List<API_LogResponce>> getLog();
}
