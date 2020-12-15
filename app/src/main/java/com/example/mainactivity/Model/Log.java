package com.example.mainactivity.Model;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class Log {

    private ArrayList<LiveData<Forecast>> logList;

    /**
     * Constructor for Log class.
     * @param logList
     */
    public Log(ArrayList<LiveData<Forecast>> logList) {
        this.logList = logList;
    }

    /**
     * Getter for logList.
     * @return logList
     */
    public ArrayList<LiveData<Forecast>> getLogList() {
        return logList;
    }


}
