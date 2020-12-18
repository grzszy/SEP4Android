package com.example.mainactivity.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class API_ResponseForecast {


    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */


    @SerializedName("co2_8")
    @Expose
    private int co2_8;
    @SerializedName("co2_12")
    @Expose
    private int co2_12;
    @SerializedName("co2_16")
    @Expose
    private int co2_16;
    @SerializedName("co2_20")
    @Expose
    private int co2_20;

    @SerializedName("humidity_8")
    @Expose
    private int humidity_8;
    @SerializedName("humidity_12")
    @Expose
    private int humidity_12;
    @SerializedName("humidity_16")
    @Expose
    private int humidity_16;
    @SerializedName("humidity_20")
    @Expose
    private int humidity_20;


    @SerializedName("temp_8")
    @Expose
    private int temp_8;
    @SerializedName("temp_12")
    @Expose
    private int temp_12;
    @SerializedName("temp_16")
    @Expose
    private int temp_16;
    @SerializedName("temp_20")
    @Expose
    private int temp_20;

    @SerializedName("numberOfPassengers_8")
    @Expose
    private int numberOfPassengers_8;
    @SerializedName("numberOfPassengers_12")
    @Expose
    private int numberOfPassengers_12;
    @SerializedName("numberOfPassengers_16")
    @Expose
    private int numberOfPassengers_16;
    @SerializedName("numberOfPassengers_20")
    @Expose
    private int numberOfPassengers_20;


    /**
     * Method defining GET action from API_Interface.
     * @return Values of CO2, temperature, humidity, number of passengers and shaft status at given hour (8, 12, 16, 20).
     */
    public Forecast getForecast(){
        return new Forecast(co2_8,co2_12,co2_16,co2_20,humidity_8,humidity_12,humidity_16,humidity_20,
                temp_8,temp_12,temp_16,temp_20,numberOfPassengers_8,numberOfPassengers_12,numberOfPassengers_16, numberOfPassengers_20);
    }
}
