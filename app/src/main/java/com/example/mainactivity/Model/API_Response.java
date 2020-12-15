package com.example.mainactivity.Model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class API_Response {


    @SerializedName("CO2_value")
    @Expose
    private int  CO2_value;

    @SerializedName("temperature_value")
    @Expose
    private double temperature_value;

    @SerializedName("humidity_value")
    @Expose
    private double humidity_value;

    @SerializedName("numberOfPassengers_value")
    @Expose
    private int numberOfPassengers_value;

    @SerializedName("shaft")
    @Expose
    private int shaft;

    public Current getCurrent(){

        return new Current(CO2_value,temperature_value,humidity_value,numberOfPassengers_value, shaft);
    }


    public Shaft postShaft(boolean action){
        return new Shaft(action);
    }




}
