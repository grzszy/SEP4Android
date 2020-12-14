package com.example.mainactivity.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Repositories.Forecast_Repository;
import com.example.mainactivity.Repositories.Home_Repository;

public class Forecast_ViewModel extends AndroidViewModel {

    Forecast_Repository forecast_repository;

    /**
     * 
     * @param application
     */
    public Forecast_ViewModel(Application application){
        super(application);
        forecast_repository = Forecast_Repository.getInstance();
    }

    public LiveData<Forecast> getForecast(){
        return forecast_repository.getForecast();
    }


    public void updateForecast(String date){

        forecast_repository.updateForecast(date);
    }
}
