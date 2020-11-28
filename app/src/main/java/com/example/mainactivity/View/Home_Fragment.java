package com.example.mainactivity.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mainactivity.Model.Current;
import com.example.mainactivity.R;
import com.example.mainactivity.ViewModel.Home_ViewModel;

public class Home_Fragment extends Fragment {

    Home_ViewModel home_viewModel;

    ProgressBar progressBarTemp;
    ProgressBar progressBarHumidity;
    ProgressBar progressBarCO2;
    ProgressBar progressBarPeople;

    SeekBar seekBarShaft;
    SeekBar seekBarVentilator;

    Button buttonUpdate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);

        progressBarTemp = v.findViewById(R.id.progressBarTemp);
        progressBarHumidity = v.findViewById(R.id.progressBarHumidity);
        progressBarCO2 = v.findViewById(R.id.progressBarCO2);
        progressBarPeople = v.findViewById(R.id.progressBarPeople);

        seekBarShaft = v.findViewById(R.id.seekBarShaft);
        seekBarVentilator = v.findViewById(R.id.seekBarVentilator);
        buttonUpdate = v.findViewById(R.id.buttonUpdate);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_viewModel.updateCurrent();
            }
        });



        home_viewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
        home_viewModel.getCurrent().observe(getActivity(), new Observer<Current>() {
            @Override
            public void onChanged(Current current) {



                Home_Fragment.this.progressBarCO2.setProgress(current.getCO2_value());
                Home_Fragment.this.progressBarTemp.setProgress((int) current.getTemp_value());
                Home_Fragment.this.progressBarHumidity.setProgress((int) current.getHumidity_value());
                Home_Fragment.this.progressBarPeople.setProgress(current.getPassenger_value());

            }
        });

        
        return v;
    }
}
