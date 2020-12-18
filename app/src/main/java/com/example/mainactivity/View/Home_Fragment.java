package com.example.mainactivity.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mainactivity.Model.AveragePeople;
import com.example.mainactivity.Model.Current;
import com.example.mainactivity.R;
import com.example.mainactivity.ViewModel.Home_ViewModel;

import java.io.IOException;

public class Home_Fragment extends Fragment {

    /**
     * @author Jakob Hansen
     */


    Home_ViewModel home_viewModel;

    ProgressBar progressBarTemp;
    ProgressBar progressBarHumidity;
    ProgressBar progressBarCO2;
    ProgressBar progressBarPeople;



    Button buttonUpdate;
    TextView textViewAveragePeople;
    TextView textViewTemp;
    TextView textViewHumidity;
    TextView textViewCO2;
    TextView textViewPeople;

    Switch shaft_switch;

    /**
     * onCreateView inflate the fragment xml file
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return return the view
     */

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
        textViewAveragePeople = v.findViewById(R.id.textViewAveragePeople);


        progressBarTemp.getProgressDrawable().setColorFilter(Color.RED,android.graphics.PorterDuff.Mode.SRC_IN);
        progressBarCO2.getProgressDrawable().setColorFilter(Color.GREEN,android.graphics.PorterDuff.Mode.SRC_IN);
        progressBarHumidity.getProgressDrawable().setColorFilter(Color.BLUE,android.graphics.PorterDuff.Mode.SRC_IN);
        progressBarPeople.getProgressDrawable().setColorFilter(Color.YELLOW,android.graphics.PorterDuff.Mode.SRC_IN);


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
                if (progressBarTemp != null ){

                    textViewTemp.setText(progressBarTemp.getProgress() +"°C");
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

                if (progressBarTemp.getProgress() == 0 && progressBarCO2.getProgress() == 0 && progressBarHumidity.getProgress() == 0){
                    String stringFromTextView = "                 Warning!                   Updated parameter values is unavailable. Try again later.";
                    showAlertDialog(stringFromTextView);
                }


                SharedPreferences preferences1 = getActivity().getSharedPreferences("temp", Context.MODE_PRIVATE);
                int temp = preferences1.getInt("temp",0);

                if (temp >= progressBarTemp.getProgress()){
                    String stringFromTextView = "                 Warning!                   Tempreture level is too high ! ";
                    showAlertDialog(stringFromTextView);
                }

                SharedPreferences preferences2 = getActivity().getSharedPreferences("co2", Context.MODE_PRIVATE);
                int co2 = preferences2.getInt("co2",0);

                if (co2 >= progressBarCO2.getProgress()){
                    String stringFromTextView = "                 Warning!                   Co2 level is too high ! ";
                    showAlertDialog(stringFromTextView);
                }

                SharedPreferences preferences3 = getActivity().getSharedPreferences("hum", Context.MODE_PRIVATE);
                int hum = preferences3.getInt("hum",0);

                if (hum >= progressBarHumidity.getProgress()){
                    String stringFromTextView = "                 Warning!                   Humidity level is too high ! ";
                    showAlertDialog(stringFromTextView);
                }

                SharedPreferences preferences4 = getActivity().getSharedPreferences("people", Context.MODE_PRIVATE);
                int people = preferences4.getInt("people",0);

                if (people >= progressBarTemp.getProgress()){
                    String stringFromTextView = "                 Warning!                   Too many people currently at the station ";
                    showAlertDialog(stringFromTextView);
                }

            }
        });


        home_viewModel.getAveragePeople().observe(getActivity(), new Observer<AveragePeople>() {
                    @Override
                    public void onChanged(AveragePeople averagePeople) {

                            Home_Fragment.this.textViewAveragePeople.setText(averagePeople.getAverageNumberOfPeople()+"");
                    }
                });

        SharedPreferences sharedPrefs1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        final String storedValue = sharedPrefs1.getString("key", "defaultValue");

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (home_viewModel.getCurrent() != null )
                {
                    home_viewModel.updateCurrent();
                    home_viewModel.updateAveragePeople();

                    if (storedValue == "true"){
                        Home_Fragment.this.shaft_switch.setChecked(true);
                    }

                    if (storedValue == "false"){
                        Home_Fragment.this.shaft_switch.setChecked(false);
                    }


                }

            }
        });


        shaft_switch = v.findViewById(R.id.shaft_switch);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        final SharedPreferences.Editor editor = sharedPrefs.edit();

        shaft_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

              home_viewModel.postShaft(b);

              if (b = true){
                  editor.putString("key", "true");
                  editor.apply();
              }
              if (b = false){
                  editor.putString("key", "false");
                  editor.apply();
              }



            }
        });

        return v;
    }

    public void showAlertDialog(String stringToShow){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(),R.style.AlertDialogStyle);
        builder1.setMessage(stringToShow);
        builder1.setCancelable(true);


        AlertDialog alert11 = builder1.create();

        alert11.show();

    }
}
