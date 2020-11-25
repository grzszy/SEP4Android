package com.example.mainactivity.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Model.Forcast;
import com.example.mainactivity.Model.Log;
import com.example.mainactivity.Model.Warning;


public class Home_Repository {
    private static Home_Repository instance;

    private MutableLiveData<Current> current;

    private MutableLiveData<Forcast> forcast;

    private MutableLiveData<Log> log;

    private MutableLiveData<Warning> warning;

    public static Home_Repository getInstance() {
        return instance;
    }

    public LiveData<Current> getCurrent() {
        return current;
    }

    public LiveData<Forcast> getForcast() {
        return forcast;
    }

    public LiveData<Log> getLog() {
        return log;
    }

    public LiveData<Warning> getWarning() {
        return warning;
    }

    public void updateCurrent(Current nCurrent){
        current.setValue(nCurrent);
    }
    public void updateForcast(Forcast nForcast){
        forcast.setValue(nForcast);
    }
    public void updateLog(Log nLog){
        log.setValue(nLog);
    }
    public void updateWarning(Warning nWarning){
        warning.setValue(nWarning);
    }


}
