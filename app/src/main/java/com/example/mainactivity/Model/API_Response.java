package com.example.mainactivity.Model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class that implements methods from the API_Interface.
 */
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

    /**
     * Implementation of the GET action from API_Interface.
     * @return Current values from the database.
     */
    public Current getCurrent(){

        return new Current(CO2_value,temperature_value,humidity_value,numberOfPassengers_value, shaft);
    }


<<<<<<< Updated upstream
    public Shaft postShaft(boolean action){
        return new Shaft(action);
=======
    /**
     * Implementation of the POST action from API_Interface.
     * @param status - shaft status (true - on, false - off).
     * @return New shaft object (on/off)
     */
    public Shaft postShaft(boolean status){
        return new Shaft(shaft);
>>>>>>> Stashed changes
    }




}
