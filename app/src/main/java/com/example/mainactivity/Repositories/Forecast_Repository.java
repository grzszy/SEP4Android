package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_ResponseForecast;
import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Model.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Forecast_Repository {

    private static Forecast_Repository instance;
    private MutableLiveData<Forecast> forecast;
    private Forecast_Repository() {
        forecast = new MutableLiveData<>();
    }


    /**
     * Getter for an instance of the Forecast_Repository class.
     * @return instance
     */
    public static synchronized Forecast_Repository getInstance() {
        if(instance == null){
            instance = new Forecast_Repository();
        }
        return instance;
    }

    /**
     * Getter for forecast.
     * @return forecast
     */
    public LiveData<Forecast> getForecast() {
        return forecast;
    }


    /**
     * Method updating forecast based on the data received from the database.
     * @param date
     */
    public void updateForecast(String date) {

        API_Interface API = ServiceGenerator.getAPI();
        System.out.println("Repository forecast: " + date);
        Call<API_ResponseForecast> call = API.getForecast(date);
        call.enqueue(new Callback<API_ResponseForecast>() {
            @Override
            public void onResponse(Call<API_ResponseForecast> call, Response<API_ResponseForecast> response) {

                if (response.code() == 200) {
                    forecast.setValue(response.body().getForecast());

                    System.out.println("REPO: " + response.body().getForecast().getTemp_8());
                }
            }
            @Override
            public void onFailure(Call<API_ResponseForecast> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

}
