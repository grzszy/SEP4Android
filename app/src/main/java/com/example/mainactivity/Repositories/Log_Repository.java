package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_LogResponce;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Model.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_Repository {

    private static Log_Repository instance;

    private LiveData<List<Forecast>> allForecast = new MutableLiveData<>();

    /**
     * Method for getting the log based on data received from the API.
     */
    public void getLog(){
    API_Interface API = ServiceGenerator.getAPI();
    Call<List<API_LogResponce>> call = API.getLog();
    call.enqueue(new Callback<List<API_LogResponce>>() {
        @Override
        public void onResponse(Call<List<API_LogResponce>> call, Response<List<API_LogResponce>> response) {

            if (response.code() == 200) {
              allForecast = (LiveData<List<Forecast>>) response.body();
            }
        }

        @Override
        public void onFailure(Call<List<API_LogResponce>> call, Throwable t) {

        }

    });
}

    public LiveData<List<Forecast>> getAllWeathers(){
        return allForecast;
    }

    /**
     * Method returning and instance of Log_Repository.
     * @return instance of Log_Repository.
     */
   public static synchronized Log_Repository getInstance(){
       if(instance==null){
           instance = new Log_Repository();
       }
       return instance;
   }

}
