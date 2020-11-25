package com.example.mainactivity.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class API_Response {


    @SerializedName("CurrentData")
    @Expose
    private CurrentData currentdata;


    public Current getWeather(){
        return new Current(currentdata.CO2_value,currentdata.Temp_value,currentdata.Humidity_value,currentdata.Passenger_value);
    }

    private class CurrentData{
        private int CO2_value;
        private double Temp_value;
        private double Humidity_value;
        private int Passenger_value;

    }
}
