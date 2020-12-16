package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class API_LogResponce {

    ArrayList<API_ResponseForecast> Array;



public ArrayList<Forecast> getList(){
    ArrayList<Forecast> temp = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
        temp.add(Array.get(i).getForecast());
    }


    return temp;
}
}
