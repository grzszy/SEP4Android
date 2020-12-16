package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_LogResponce;
import com.example.mainactivity.Model.API_ResponseForecast;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Model.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_Repository {

    private static Log_Repository instance;

    private MutableLiveData<List<Forecast>> allForecast;

    private Log_Repository() {
        allForecast = new MutableLiveData<>();
    }


    /**
     * Method for getting the log based on data received from the API.
     */


        public void updateLog () {

            API_Interface API = ServiceGenerator.getAPI();
            Call<API_LogResponce> call = API.getLog();
            call.enqueue(new Callback<API_LogResponce>() {
                @Override
                public void onResponse(Call<API_LogResponce> call, Response<API_LogResponce> response) {

                    if (response.code() == 200) {
                        allForecast.setValue(response.body().getList());
                        System.out.println("Log-REPO: " + response.body().getList().get(0).toString());
                    }
                }

                @Override
                public void onFailure(Call<API_LogResponce> call, Throwable t) {
                    Log.i("LOGREPOSITORY", "Something went wrong");
                }

            });
        }

        public LiveData<List<Forecast>> getLog () {
            return allForecast;
        }

        /**
         * Method returning and instance of Log_Repository.
         * @return instance of Log_Repository.
         */
        public static synchronized Log_Repository getInstance () {
            if (instance == null) {
                instance = new Log_Repository();
            }
            return instance;
        }


}
