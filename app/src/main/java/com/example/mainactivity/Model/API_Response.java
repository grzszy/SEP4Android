package com.example.mainactivity.Model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class API_Response {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */

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

    @SerializedName("averageNumberOfPeople")
    @Expose
    private int averageNumberOfPeople;

    /**
     * Method defining GET action from API_Interface.
     * @return Current values of CO2, temperature, humidity, number of passengers and shaft status.
     */
    public Current getCurrent(){

        return new Current(CO2_value,temperature_value,humidity_value,numberOfPassengers_value, shaft);
    }

    /**
     * Method defining GET action from API_Interface.
     * @return Average number of passengers.
     */
    public AveragePeople getAveragePeople(){
        return new AveragePeople(averageNumberOfPeople);
    }


}
