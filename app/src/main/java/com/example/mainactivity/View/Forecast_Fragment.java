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

public class Forecast_Fragment extends Fragment {
    Forecast_ViewModel forecastViewModel;
    CalendarView calendarView;
    private LiveData<Forecast> fc;
    TextView t1; TextView t2; TextView t3; TextView t4;
    TextView t5; TextView t6; TextView t7; TextView t8;
    TextView t9; TextView t10; TextView t11; TextView t12;
    TextView t13; TextView t14; TextView t15; TextView t16;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.forecast_fragment, container, false);
        calendarView = v.findViewById(R.id.calendarView);
        t1 = v.findViewById(R.id.t8); t2 = v.findViewById(R.id.t12); t3 = v.findViewById(R.id.t16); t4 = v.findViewById(R.id.t20);
        t5 = v.findViewById(R.id.c8); t6 = v.findViewById(R.id.c12); t7 = v.findViewById(R.id.c16); t8 = v.findViewById(R.id.c20);
        t9 = v.findViewById(R.id.h8); t10 = v.findViewById(R.id.h12); t11 = v.findViewById(R.id.h16); t12 = v.findViewById(R.id.h20);
        t13 = v.findViewById(R.id.p8); t14 = v.findViewById(R.id.p12); t15 = v.findViewById(R.id.p16); t16 = v.findViewById(R.id.p20);

        forecastViewModel = new ViewModelProvider(this).get(Forecast_ViewModel.class);
        forecastViewModel.getForecast().observe(getActivity(), new Observer<Forecast>() {
            @Override
            public void onChanged(Forecast forecast) {
                if (forecastViewModel.getForecast() != null) {
                    fc = forecastViewModel.getForecast();
                    Forecast_Fragment.this.t1.setText(fc.getValue().getTemp_8() + "°C");
                    Forecast_Fragment.this.t2.setText(fc.getValue().getTemp_12() + "°C");
                    Forecast_Fragment.this.t3.setText(fc.getValue().getTemp_16() + "°C");
                    Forecast_Fragment.this.t4.setText(fc.getValue().getTemp_20() + "°C");

                    Forecast_Fragment.this.t5.setText(fc.getValue().getCo2_8() + " ppm");
                    Forecast_Fragment.this.t6.setText(fc.getValue().getCo2_12() + " ppm");
                    Forecast_Fragment.this.t7.setText(fc.getValue().getCo2_16() + " ppm");
                    Forecast_Fragment.this.t8.setText(fc.getValue().getCo2_20() + " ppm");

                    Forecast_Fragment.this.t9.setText(fc.getValue().getHumidity_8() + "%");
                    Forecast_Fragment.this.t10.setText(fc.getValue().getHumidity_12() + "%");
                    Forecast_Fragment.this.t11.setText(fc.getValue().getHumidity_16() + "%");
                    Forecast_Fragment.this.t12.setText(fc.getValue().getHumidity_20() + "%");

                    Forecast_Fragment.this.t13.setText(fc.getValue().getNumberOfPassengers_8() + "/h");
                    Forecast_Fragment.this.t14.setText(fc.getValue().getNumberOfPassengers_12() + "/h");
                    Forecast_Fragment.this.t15.setText(fc.getValue().getNumberOfPassengers_16() + "/h");
                    Forecast_Fragment.this.t16.setText(fc.getValue().getNumberOfPassengers_20() + "/h");

                }
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "-" + (month + 1) + "-" + dayOfMonth;
                forecastViewModel.updateForecast(date);

            }
        });


        return v;
    }
}
