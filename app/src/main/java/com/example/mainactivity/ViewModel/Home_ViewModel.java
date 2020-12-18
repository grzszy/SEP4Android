package com.example.mainactivity.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mainactivity.Model.AveragePeople;
import com.example.mainactivity.Model.Current;
import com.example.mainactivity.Repositories.Home_Repository;

public class Home_ViewModel extends ViewModel {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */

    Home_Repository home_repository;


    /**
     * Constructor for Home_ViewModel.
     */
    public Home_ViewModel(){
        home_repository = Home_Repository.getInstance();
    }

    /**
     * Method calling getCurrent() method in Home_Repository.
     * @return Current values based on data received from Home_Repository.
     */
    public LiveData<Current> getCurrent(){
        return home_repository.getCurrent();
    }

    /**
     * Method calling getAveragePeople() method in the Home_Repository.
     * @return Average number of people based on data received form Home_Repository.
     */
    public LiveData<AveragePeople> getAveragePeople(){
        return home_repository.getAveragePeople();
    }

    /**
     * Method calling postShaft() method in the Home_Repository.
     * @param status Based on the status received from the Home_Fragment.
     */
    public void postShaft(boolean status)
    {
        home_repository.postShaft(status);
    }

    /**
     * Method calling updateCurrent() method in the Home_Repository based on action in Home_Fragment.
     */
    public void updateCurrent(){

        home_repository.updateCurrent();
    }

    /**
     * Method calling updateAveragePeople() method in the Home_Repository based on action in Home_Fragment.
     */
    public void updateAveragePeople(){

        home_repository.updateAveragePeople();
    }

}
