package com.example.mainactivity.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.R;
import com.example.mainactivity.ViewModel.Forecast_ViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Forecast_Fragment extends Fragment {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */



    Forecast_ViewModel forecastViewModel;
    CalendarView calendarView;
    private LiveData<Forecast> fc;
    TextView Temp_8; TextView Temp_12; TextView Temp_16; TextView Temp_20;
    TextView Co2_8; TextView Co2_12; TextView Co2_16; TextView Co2_20;
    TextView Humidity_8; TextView Humidity_12; TextView Humidity_16; TextView Humidity_20;
    TextView NumberOfPassengers_8; TextView NumberOfPassengers_12; TextView NumberOfPassengers_16; TextView NumberOfPassengers_20;


    int day;

    Calendar cal = Calendar.getInstance();
    int current_day = cal.get(Calendar.DAY_OF_MONTH);

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
        View v = inflater.inflate(R.layout.forecast_fragment, container, false);
        calendarView = v.findViewById(R.id.calendarView);
        Temp_8 = v.findViewById(R.id.t8); Temp_12 = v.findViewById(R.id.t12); Temp_16 = v.findViewById(R.id.t16); Temp_20 = v.findViewById(R.id.t20);
        Co2_8 = v.findViewById(R.id.c8); Co2_12 = v.findViewById(R.id.c12); Co2_16 = v.findViewById(R.id.c16); Co2_20 = v.findViewById(R.id.c20);
        Humidity_8 = v.findViewById(R.id.h8); Humidity_12 = v.findViewById(R.id.h12); Humidity_16 = v.findViewById(R.id.h16); Humidity_20 = v.findViewById(R.id.h20);
        NumberOfPassengers_8 = v.findViewById(R.id.p8); NumberOfPassengers_12 = v.findViewById(R.id.p12); NumberOfPassengers_16 = v.findViewById(R.id.p16); NumberOfPassengers_20 = v.findViewById(R.id.p20);

        forecastViewModel = new ViewModelProvider(this).get(Forecast_ViewModel.class);
        forecastViewModel.getForecast().observe(getActivity(), new Observer<Forecast>() {
            @Override
            public void onChanged(Forecast forecast) {
                if (forecastViewModel.getForecast() != null) {
                    fc = forecastViewModel.getForecast();

                    if (current_day == day +1){

                        Forecast_Fragment.this.Temp_8.setText(fc.getValue().getTemp_8() + "°C");
                        Forecast_Fragment.this.Temp_12.setText(fc.getValue().getTemp_12() + "°C");
                        Forecast_Fragment.this.Temp_16.setText(fc.getValue().getTemp_16() + "°C");
                        Forecast_Fragment.this.Temp_20.setText(fc.getValue().getTemp_20() + "°C");

                        Forecast_Fragment.this.Co2_8.setText(fc.getValue().getCo2_8() + " ppm");
                        Forecast_Fragment.this.Co2_12.setText(fc.getValue().getCo2_12() + " ppm");
                        Forecast_Fragment.this.Co2_16.setText(fc.getValue().getCo2_16() + " ppm");
                        Forecast_Fragment.this.Co2_20.setText(fc.getValue().getCo2_20() + " ppm");

                        Forecast_Fragment.this.Humidity_8.setText(fc.getValue().getHumidity_8() + "%");
                        Forecast_Fragment.this.Humidity_12.setText(fc.getValue().getHumidity_12() + "%");
                        Forecast_Fragment.this.Humidity_16.setText(fc.getValue().getHumidity_16() + "%");
                        Forecast_Fragment.this.Humidity_20.setText(fc.getValue().getHumidity_20() + "%");

                        Forecast_Fragment.this.NumberOfPassengers_8.setText(fc.getValue().getNumberOfPassengers_8() + "/h");
                        Forecast_Fragment.this.NumberOfPassengers_12.setText(fc.getValue().getNumberOfPassengers_12() + "/h");
                        Forecast_Fragment.this.NumberOfPassengers_16.setText(fc.getValue().getNumberOfPassengers_16() + "/h");
                        Forecast_Fragment.this.NumberOfPassengers_20.setText(fc.getValue().getNumberOfPassengers_20() + "/h");

                    }



                    Forecast_Fragment.this.Temp_8.setText(fc.getValue().getTemp_8() + "°C");
                    Forecast_Fragment.this.Temp_12.setText(fc.getValue().getTemp_12() + "°C");
                    Forecast_Fragment.this.Temp_16.setText(fc.getValue().getTemp_16() + "°C");
                    Forecast_Fragment.this.Temp_20.setText(fc.getValue().getTemp_20() + "°C");

                    Forecast_Fragment.this.Co2_8.setText(fc.getValue().getCo2_8() + " ppm");
                    Forecast_Fragment.this.Co2_12.setText(fc.getValue().getCo2_12() + " ppm");
                    Forecast_Fragment.this.Co2_16.setText(fc.getValue().getCo2_16() + " ppm");
                    Forecast_Fragment.this.Co2_20.setText(fc.getValue().getCo2_20() + " ppm");

                    Forecast_Fragment.this.Humidity_8.setText(fc.getValue().getHumidity_8() + "%");
                    Forecast_Fragment.this.Humidity_12.setText(fc.getValue().getHumidity_12() + "%");
                    Forecast_Fragment.this.Humidity_16.setText(fc.getValue().getHumidity_16() + "%");
                    Forecast_Fragment.this.Humidity_20.setText(fc.getValue().getHumidity_20() + "%");

                    Forecast_Fragment.this.NumberOfPassengers_8.setText(fc.getValue().getNumberOfPassengers_8() + "/h");
                    Forecast_Fragment.this.NumberOfPassengers_12.setText(fc.getValue().getNumberOfPassengers_12() + "/h");
                    Forecast_Fragment.this.NumberOfPassengers_16.setText(fc.getValue().getNumberOfPassengers_16() + "/h");
                    Forecast_Fragment.this.NumberOfPassengers_20.setText(fc.getValue().getNumberOfPassengers_20() + "/h");

                }
            }
        });



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "-" + (month + 1) + "-" + dayOfMonth;
                day = dayOfMonth;

                forecastViewModel.updateForecast(date);

            }
        });


        return v;
    }
}
