package com.example.mainactivity.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Repositories.Log_Repository;

import java.util.ArrayList;
import java.util.List;

public class Log_ViewModel extends AndroidViewModel {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */

    Log_Repository log_repository;

    /**
     *  Constructor for Log_ViewModel
     * @param application
     */

    public Log_ViewModel(Application application){
        super(application);
        log_repository = Log_Repository.getInstance();
    }

    /**
     * Method for calling updatelog in repository
     */

    public void updateLog(){
        log_repository.updateLog();
    }

    /**
     * Method for getting log in form of LiveData
     * @return returns a ArrayList of forecasts
     */
    public LiveData<ArrayList<Forecast>> getLog(){
        return log_repository.getLog();
    }



}
