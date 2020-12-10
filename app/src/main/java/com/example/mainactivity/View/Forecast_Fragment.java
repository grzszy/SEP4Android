package com.example.mainactivity.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mainactivity.R;
import com.example.mainactivity.ViewModel.Forecast_ViewModel;

public class Forecast_Fragment extends Fragment {
    Forecast_ViewModel forecastViewModel;
    CalendarView calendarView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.forecast_fragment,container,false);
        calendarView = v.findViewById(R.id.calendarView);
        forecastViewModel = new ViewModelProvider(this).get(Forecast_ViewModel.class);
    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            //System.out.println("year: " +year + " Month: " + (month+1) + " day: " + dayOfMonth);
            System.out.println(year + "-" + (month+1) + "-" + dayOfMonth);
            String date = year + "-" + (month+1) + "-" + dayOfMonth;

                forecastViewModel.updateForecast(date);
            //System.out.println("FORECAST: " + forecastViewModel.getForecast().getValue().toString());





        }
    });


        return v;
    }
}
