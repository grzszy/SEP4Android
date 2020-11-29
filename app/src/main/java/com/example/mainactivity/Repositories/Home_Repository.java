package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_Response;
import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home_Repository {
    private static Home_Repository instance;
    private MutableLiveData<Current> current;
    private Home_Repository() {
        current = new MutableLiveData<>();
    }

    public static synchronized Home_Repository getInstance() {
        if(instance == null){
            instance = new Home_Repository();
        }
        return instance;
    }

    public LiveData<Current> getCurrent() {
        return current;
    }

    public void updateCurrent(){
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<API_Response> call = androidAPI.getCurrent();

        call.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call,Response<API_Response> response) {
                if (response.code() == 200 && response.isSuccessful()){
                    current.setValue(response.body().getCurrent());

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
