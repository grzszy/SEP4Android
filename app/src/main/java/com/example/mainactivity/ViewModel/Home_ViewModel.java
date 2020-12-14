package com.example.mainactivity.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Repositories.Home_Repository;

public class Home_ViewModel extends ViewModel {
    Home_Repository home_repository;

    /**
     * Constructor for Home_ViewModel.
     */
    public Home_ViewModel(){
        home_repository = Home_Repository.getInstance();
    }

    public LiveData<Current> getCurrent(){
        return home_repository.getCurrent();
    }

    /**
     * Method calling postShaft() method in the repository.
     * @param status
     */
    public void postShaft(boolean status)
    {
        home_repository.postShaft(status);
        System.out.println("Viewmodel status: " + status);
    }

    /**
     * Method calling updateCurrent() method in the repository.
     */
    public void updateCurrent(){
        home_repository.updateCurrent();

    }



}
