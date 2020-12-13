package com.example.mainactivity.Model;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class Log {

    private ArrayList<LiveData<Forecast>> logList;

    public Log(ArrayList<LiveData<Forecast>> logList) {
        this.logList = logList;
    }

    public ArrayList<LiveData<Forecast>> getLogList() {
        return logList;
    }


}
