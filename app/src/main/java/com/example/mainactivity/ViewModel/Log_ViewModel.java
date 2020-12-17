package com.example.mainactivity.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.Repositories.Log_Repository;

import java.util.ArrayList;
import java.util.List;

public class Log_ViewModel extends AndroidViewModel {

    Log_Repository log_repository;


    public Log_ViewModel(Application application){
        super(application);
        log_repository = Log_Repository.getInstance();
    }

    public void updateLog(){
        log_repository.updateLog();
    }

    public LiveData<ArrayList<Forecast>> getLog(){
        return log_repository.getLog();
    }



}
