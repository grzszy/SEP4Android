package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_Response;
import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.ServiceGenerator;
import com.example.mainactivity.Model.Shaft;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home_Repository {
    private static Home_Repository instance;
    private MutableLiveData<Current> current;
    private MutableLiveData<Shaft> shaft;
    private Home_Repository() {
        current = new MutableLiveData<>();
    }


<<<<<<< Updated upstream
=======

    /**
     * Getter for an instance of the Home_Repository class.
     * @return instance
     */
>>>>>>> Stashed changes
    public static synchronized Home_Repository getInstance() {
        if(instance == null){
            instance = new Home_Repository();
        }
        return instance;
    }

    /**
     * Getter for Current.
     * @return current
     */
    public LiveData<Current> getCurrent() {
        return current;
    }

    /**
     * Method that sends shafts status to the database.
     * @param status
     */
    public void postShaft(final boolean status) {
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<API_Response> post = androidAPI.postShaft(status);
        System.out.println("Repo post shaft: " + status);
        post.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call, Response<API_Response> response) {

                if(response.code() == 200 && response.isSuccessful())
                {
                    shaft.setValue(response.body().postShaft(status));
                    System.out.println("POSTrep: Shaft posted.");
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

    /**
     * Method updating Current values based on the data received form the database.
     */
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

    public void updateShaft(){
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<API_Response> call = androidAPI.getCurrent();

        call.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call,Response<API_Response> response) {
                if (response.code() == 200 && response.isSuccessful());
                    if (response.equals(true)  && response.isSuccessful());
                {
                    current.setValue(response.body().getCurrent());
                }
                    Log.i("Retrofit2", "onResponse: Success!");

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
