package com.example.mainactivity.ViewModel;

import android.app.Application;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Repositories.Home_Repository;
import com.example.mainactivity.Repositories.Shaft_Repository;

public class Shaft_ViewModel extends AndroidViewModel {

    public LiveData<Switch> shaft;
    private Home_Repository repository;
    public Shaft_ViewModel(@NonNull Application application) {
        super(application);
        repository = Shaft_Repository.getInstance(application.getApplicationContext());

    }
}
