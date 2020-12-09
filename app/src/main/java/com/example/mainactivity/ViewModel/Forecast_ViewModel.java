package com.example.mainactivity.ViewModel;

import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Repositories.Forecast_Repository;
import com.example.mainactivity.Repositories.Home_Repository;

public class Forecast_ViewModel {

    Forecast_Repository forecast_repository;


    public Forecast_ViewModel(){
        forecast_repository = Forecast_Repository.getInstance();
    }

    public LiveData<Forecast> getForecast(){
        return forecast_repository.getForecast();
    }


    public void updateForecast(String date){

        forecast_repository.updateForecast(date);
    }
}
