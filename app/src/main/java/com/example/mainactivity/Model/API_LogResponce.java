package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class API_LogResponce {


    @SerializedName("forecasts")
    private ArrayList<Forecast> forecasts;


    /**
     * Getter for forecast log.
     * @return forecasts
     */
    public List<Forecast> getLogs() {

    public ArrayList<Forecast> getLogs() {

        return forecasts;
    }

    public API_LogResponce(ArrayList<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}
