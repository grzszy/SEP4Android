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

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */


    private static Forecast_Repository instance;
    private MutableLiveData<Forecast> forecast;
    private Forecast_Repository() {
        forecast = new MutableLiveData<>();
    }


    /**
     * Method returning and instance of Forecast_Repository.
     * @return instance of Forecast_Repository.
     */
    public static synchronized Forecast_Repository getInstance() {
        if(instance == null){
            instance = new Forecast_Repository();
        }
        return instance;
    }

    /**
     * Getter for LiveData<Forecast>.
     * @return forecast
     */
    public LiveData<Forecast> getForecast() {
        return forecast;
    }


    /**
     * Method updating the forecast based on the data received form the API, for given date.
     * @param date String
     */
    public void updateForecast(String date) {

        API_Interface API = ServiceGenerator.getAPI();
        System.out.println("UpdateForecast method " + date);
        Call<API_ResponseForecast> call = API.getForecast(date);
        call.enqueue(new Callback<API_ResponseForecast>() {
            @Override
            public void onResponse(Call<API_ResponseForecast> call, Response<API_ResponseForecast> response) {

                if (response.code() == 200) {
                    forecast.setValue(response.body().getForecast());

                    System.out.println("Forecast REPO: " + response.body().getForecast().getTemp_8());
                }
            }
            @Override
            public void onFailure(Call<API_ResponseForecast> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

}
