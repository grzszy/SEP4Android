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

import com.example.mainactivity.R;

public class Home_Fragment extends Fragment {

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


        return v;
    }
}
