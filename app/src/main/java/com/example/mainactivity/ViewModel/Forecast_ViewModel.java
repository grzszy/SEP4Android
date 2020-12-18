package com.example.mainactivity.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Repositories.Forecast_Repository;
import com.example.mainactivity.Repositories.Home_Repository;

public class Forecast_ViewModel extends AndroidViewModel {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */

    Forecast_Repository forecast_repository;


    /**
     * Constructor for Forecast_ViewModel.
     * @param application
     */
    public Forecast_ViewModel(Application application){
        super(application);
        forecast_repository = Forecast_Repository.getInstance();
    }

    /**
     * Getter for LiveData<Forecast>.
     * @return Forecast based on data received from the Forecast_Repository.
     */
    public LiveData<Forecast> getForecast(){
        return forecast_repository.getForecast();
    }

    /**
     * Method calling updateForecast() method in the Forecast_Repository.
     * @param date String - specific date.
     */
    public void updateForecast(String date){

        forecast_repository.updateForecast(date);
    }
}
