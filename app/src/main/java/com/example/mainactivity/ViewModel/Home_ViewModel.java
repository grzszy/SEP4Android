package com.example.mainactivity.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Repositories.Home_Repository;

public class Home_ViewModel extends ViewModel {
    Home_Repository home_repository;

    public Home_ViewModel(){
        home_repository = Home_Repository.getInstance();
    }

    public LiveData<Current> getCurrent(){
        return home_repository.getCurrent();
    }

    public void updateCurrent(){
        home_repository.updateCurrent();
    }

}
