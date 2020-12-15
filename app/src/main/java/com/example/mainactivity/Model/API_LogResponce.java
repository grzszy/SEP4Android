package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class API_LogResponce {


    @SerializedName("forecasts")
    private List<Forecast> forecasts;

    /**
     * Getter for forecast log.
     * @return forecasts
     */
    public List<Forecast> getLogs() {
        return forecasts;
    }

}
