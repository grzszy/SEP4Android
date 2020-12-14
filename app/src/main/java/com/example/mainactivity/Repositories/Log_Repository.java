package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_LogResponce;
import com.example.mainactivity.Model.API_ResponseForecast;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Model.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_Repository {

    private static Log_Repository instance;
    private ArrayList<LiveData<Forecast>> list = new ArrayList<>();


public void getList(){
    API_Interface API = ServiceGenerator.getAPI();
    Call<API_LogResponce> call = API.getList();
    call.enqueue(new Callback<API_LogResponce>() {
        @Override
        public void onResponse(Call<API_LogResponce> call, Response<API_LogResponce> response) {

            if (response.code() == 200) {
                //list.setValue(response.body().getForecast());

                //System.out.println("REPO: " + response.body().getForecast().getTemp_8());
            }
        }
        @Override
        public void onFailure(Call<API_LogResponce> call, Throwable t) {
            Log.i("Retrofit", "Something went wrong :(");
        }
    });
}




   public static synchronized Log_Repository getInstance(){
       if(instance==null){
           instance = new Log_Repository();
       }
       return instance;
   }

}
