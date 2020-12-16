package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class API_LogResponce {

/*
    API_ResponseForecast forecast1;
    API_ResponseForecast forecast2;
    API_ResponseForecast forecast3;
    API_ResponseForecast forecast4;
    API_ResponseForecast forecast5;
    API_ResponseForecast forecast6;
    API_ResponseForecast forecast7;

 */
    ArrayList<API_ResponseForecast> LogList = new ArrayList<>();


    /**
     * Getter for forecast log.
     * @return forecasts
     */


    /*
    public ArrayList<Forecast> getLogs() {

        list.add(forecast1.getForecast());
        list.add(forecast2.getForecast());
        list.add(forecast3.getForecast());
        list.add(forecast4.getForecast());
        list.add(forecast5.getForecast());
        list.add(forecast6.getForecast());
        list.add(forecast7.getForecast());
        return list;
    }

 */
public ArrayList<Forecast> getList(){
    ArrayList<Forecast> temp = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
        temp.add(LogList.get(i).getForecast());
    }


    return temp;
}
}
