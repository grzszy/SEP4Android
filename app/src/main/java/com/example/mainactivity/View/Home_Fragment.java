package com.example.mainactivity.View;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

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


    SeekBar seekBarVentilator;

    Button buttonUpdate;

    TextView textViewTemp;
    TextView textViewHumidity;
    TextView textViewCO2;
    TextView textViewPeople;

    Switch shaft_switch;

    Current currentTemp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);


        progressBarTemp = v.findViewById(R.id.progressBarTemp);
        progressBarHumidity = v.findViewById(R.id.progressBarHumidity);
        progressBarCO2 = v.findViewById(R.id.progressBarCO2);
        progressBarPeople = v.findViewById(R.id.progressBarPeople);

        shaft_switch = v.findViewById(R.id.shaft_switch);
        buttonUpdate = v.findViewById(R.id.buttonUpdate);

        textViewTemp = v.findViewById(R.id.textViewTemp);
        textViewHumidity = v.findViewById(R.id.textViewHumidity);
        textViewCO2 = v.findViewById(R.id.textViewCO2);
        textViewPeople = v.findViewById(R.id.textViewPeople);

        progressBarTemp.getProgressDrawable().setColorFilter(Color.RED,android.graphics.PorterDuff.Mode.SRC_IN);
        progressBarCO2.getProgressDrawable().setColorFilter(Color.GREEN,android.graphics.PorterDuff.Mode.SRC_IN);
        progressBarHumidity.getProgressDrawable().setColorFilter(Color.BLUE,android.graphics.PorterDuff.Mode.SRC_IN);
        progressBarPeople.getProgressDrawable().setColorFilter(Color.YELLOW,android.graphics.PorterDuff.Mode.SRC_IN);


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (home_viewModel.getCurrent() != null)
                {
                    home_viewModel.updateCurrent();
                }


                if (progressBarTemp != null ){

                    textViewTemp.setText(progressBarTemp.getProgress()+"°C");
                }
                if (progressBarCO2 != null ){

                    textViewCO2.setText(progressBarCO2.getProgress()+" ppm");
                }
                if (progressBarHumidity != null ){

                    textViewHumidity.setText(progressBarHumidity.getProgress()+"%");
                }
                if (progressBarPeople != null ){

                    textViewPeople.setText(progressBarPeople.getProgress()+"/h");
                }
            }
        });

        progressBarCO2.setMax(2000);
        progressBarTemp.setMax(60);
        progressBarHumidity.setMax(100);
        progressBarPeople.setMax(200);





        home_viewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
        home_viewModel.getCurrent().observe(getActivity(), new Observer<Current>() {
            @Override
            public void onChanged(Current current) {



                Home_Fragment.this.progressBarTemp.setProgress((int) current.getTemp_value());
                Home_Fragment.this.progressBarHumidity.setProgress((int) current.getHumidity_value());
                Home_Fragment.this.progressBarCO2.setProgress(current.getCO2_value());
                Home_Fragment.this.progressBarPeople.setProgress(current.getPassenger_value());
                Home_Fragment.this.shaft_switch.setChecked(current.getShaftStatus());






            }
        });


        // implementing a switch


        shaft_switch = (Switch) v.findViewById(R.id.shaft_switch);



        shaft_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b)
                {
                    home_viewModel.postShaft(b);
                    System.out.println("Home fragm.: " + b);
                }
                else
                {
                    home_viewModel.postShaft(false);
                    System.out.println("Home fragm.: " + b);
                }
               ;
            }
        });
        home_viewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
        home_viewModel.getCurrent().observe(getActivity(), new Observer<Current>() {
            @Override
            public void onChanged(Current current) {
                Home_Fragment.this.shaft_switch.setChecked(current.getShaftStatus());
                System.out.println("set checked view model");
            }
        });
        return v;
    }
}
