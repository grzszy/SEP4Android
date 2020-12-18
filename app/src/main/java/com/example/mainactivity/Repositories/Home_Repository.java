package com.example.mainactivity.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.API_Interface;
import com.example.mainactivity.Model.API_Response;
import com.example.mainactivity.Model.AveragePeople;
import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.ServiceGenerator;
import com.example.mainactivity.Model.Shaft;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home_Repository {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     * @author Mohammed Marwan
     */


    private static Home_Repository instance;
    private MutableLiveData<AveragePeople> averagePeople;
    private MutableLiveData<Current> current;

    /**
     * Constructor
     */

    private Home_Repository() {
        current = new MutableLiveData<>();
        averagePeople = new MutableLiveData<>();
    }


    /**
     * Method returning and instance of Home_Repository.
     *
     * @return instance of Home_Repository.
     */
    public static synchronized Home_Repository getInstance() {
        if (instance == null) {
            instance = new Home_Repository();
        }
        return instance;
    }

    /**
     * Getter for LiveData<Current>.
     *
     * @return current
     */
    public LiveData<Current> getCurrent() {
        return current;
    }


    /**
     * Getter for LiveData<AveragePeople>.
     *
     * @return averagePeople
     */
    public LiveData<AveragePeople> getAveragePeople() {
        return averagePeople;
    }

    /**
     * Method posting shaft status to the API_Interface.
     *
     * @param status boolean (true - shaft on; false - shaft off)
     */
    public void postShaft(final boolean status) {
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<Void> post = androidAPI.postShaft(status);
        System.out.println("Repo post shaft: " + status);
        post.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("SUCCESS!" + status);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i("Retrofit2", "Something went wrong in the API!");
                t.getMessage();
                t.printStackTrace();
                t.getCause();

            }

        });

    }

    /**
     * Method updating current values from class Current based on data received from API.
     */
    public void updateCurrent() {
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<API_Response> call = androidAPI.getCurrent();

        call.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call, Response<API_Response> response) {
                if (response.code() == 200 && response.isSuccessful()) {
                    current.setValue(response.body().getCurrent());
                    System.out.println("SHAFT STATUS BACK FROM DATA "+response.body().getCurrent().getShaftStatus());

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
     * Method updating average number of people based on the data received from API.
     */
    public void updateAveragePeople() {
        API_Interface androidAPI = ServiceGenerator.getAPI();
        Call<API_Response> call = androidAPI.getAverageNumberPeople();

        call.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call, Response<API_Response> response) {
                if (response.code() == 200 && response.isSuccessful()) {
                    averagePeople.setValue(response.body().getAveragePeople());


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
