package com.example.mainactivity.ViewModel;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mainactivity.Model.Shaft;
import com.example.mainactivity.Repositories.Shaft_Repository;

public class Shaft_ViewModel extends AndroidViewModel {
    Shaft_Repository shaft_repository;

    public Shaft_ViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Shaft> postShaft(){
        return shaft_repository.postShaft();
    }

    public void updateShaft(){
        shaft_repository.updateShaft();
    }
}
