package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_Response;
import com.example.mainactivity.Model.ServiceGenerator;
import com.example.mainactivity.Model.Shaft;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Shaft_Repository {
    private static Shaft_Repository instance;
    private MutableLiveData<Shaft> shaft;
    private Shaft_Repository() {
        shaft = new MutableLiveData<>();
    }

    public static synchronized Shaft_Repository getInstance() {
        if(instance == null){
            instance = new Shaft_Repository();
        }
        return instance;
    }
    public MutableLiveData<Shaft> postShaft(){
        return shaft;
    }

    public void updateShaft(){
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<API_Response> call = androidAPI.postShaft(shaft);

        call.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call, Response<API_Response> response) {
                if (response.code() == 200 && response.isSuccessful()){
                    Log.i("Retrofit2", "onResponse: Success!");

                }
            }
            @Override
            public void onFailure(Call<API_Response> call, Throwable t) {
                Log.i("Retrofit2", "Something went wrong in the API!");
                t.getMessage();
                t.printStackTrace();
                t.getCause();

            }
        });
    }
}
