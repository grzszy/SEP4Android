package com.example.mainactivity.Model;

public class Current {


    private int CO2_value;
    private double Temp_value;
    private double Humidity_value;
    private int Passenger_value;
    private int shaftStatus;


    public Current(int CO2_value, double Temp_value, double Humidity_value, int Passenger_value, int shaftStatus){
        this.CO2_value = CO2_value;
        this.Temp_value = Temp_value;
        this.Humidity_value = Humidity_value;
        this.Passenger_value = Passenger_value;
        this.shaftStatus = shaftStatus;
    }


    public int getCO2_value() {
        return CO2_value;
    }

    public void setCO2_value(int CO2_value) {
        this.CO2_value = CO2_value;
    }

    public double getTemp_value() {
        return Temp_value;
    }

    public void setTemp_value(double temp_value) {
        Temp_value = temp_value;
    }

    public double getHumidity_value() {
        return Humidity_value;
    }

    public void setHumidity_value(double humidity_value) {
        Humidity_value = humidity_value;
    }

    public int getPassenger_value() {
        return Passenger_value;
    }

    public void setPassenger_value(int passenger_value) {
        Passenger_value = passenger_value;
    }

    public int getShaftStatus()
    {
        return shaftStatus;
    }

    public void setShaftStatus(int shaftStatus)
    {
        this.shaftStatus = shaftStatus;
    }
}
