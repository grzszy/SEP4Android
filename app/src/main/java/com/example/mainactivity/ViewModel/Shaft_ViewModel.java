package com.example.mainactivity.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Repositories.Home_Repository;

public class Shaft_ViewModel extends AndroidViewModel {

    public LiveData<> shaft;
    private Home_Repository repository;
    public Shaft_ViewModel(@NonNull Application application) {
        super(application);
        repository = Home_Repository.getInstance(application.getApplicationContext());

    }
}
