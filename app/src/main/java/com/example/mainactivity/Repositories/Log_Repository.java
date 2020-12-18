package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_ResponseForecast;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Model.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_Repository {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */

    private static Log_Repository instance;

    private MutableLiveData<ArrayList<Forecast>> allForecast;

    private Log_Repository() {
        allForecast = new MutableLiveData<>();
    }


    /**
     * Method for getting the log based on data received from the API.
     */


        public void updateLog () {

            API_Interface API = ServiceGenerator.getAPI();
            Call<ArrayList<API_ResponseForecast>> call = API.getLog();
            call.enqueue(new Callback<ArrayList<API_ResponseForecast>>(){
                @Override
                public void onResponse(Call<ArrayList<API_ResponseForecast>> call, Response<ArrayList<API_ResponseForecast>> response) {
                    ArrayList<Forecast> temp = new ArrayList<>();
                    if (response.code() == 200) {
                        for (int i = 0; i <6 ; i++) {
                            temp.add(response.body().get(i).getForecast());
                            System.out.println(response.body().get(i).getForecast());
                        }
                        allForecast.setValue(temp);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<API_ResponseForecast>> call, Throwable t) {
                    Log.i("LOGREPOSITORY", "Something went wrong");
                }

            });
        }

        public LiveData<ArrayList<Forecast>> getLog () {
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
