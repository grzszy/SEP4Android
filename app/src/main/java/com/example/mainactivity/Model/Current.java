package com.example.mainactivity.Model;

public class Current {


    /**
     * @author Jakob Hansen
     */

    private int CO2_value;
    private double Temp_value;
    private double Humidity_value;
    private int Passenger_value;
    private int shaftStatus;

    /**
     * Constructor for Current class.
     * @param CO2_value
     * @param Temp_value
     * @param Humidity_value
     * @param Passenger_value
     * @param shaftStatus
     */
    public Current(int CO2_value, double Temp_value, double Humidity_value, int Passenger_value, int shaftStatus){
        this.CO2_value = CO2_value;
        this.Temp_value = Temp_value;
        this.Humidity_value = Humidity_value;
        this.Passenger_value = Passenger_value;
        this.shaftStatus = shaftStatus;
    }

    /**
     * Getter for CO2 value.
     * @return CO value.
     */
    public int getCO2_value() {
        return CO2_value;
    }

    /**
     * Setter for CO2 value.
     * @param CO2_value
     */
    public void setCO2_value(int CO2_value) {
        this.CO2_value = CO2_value;
    }

    /**
     * Getter for temperature value.
     * @return Temperature value.
     */
    public double getTemp_value() {
        return Temp_value;
    }

    /**
     * Setter for temperature value.
     * @param temp_value
     */
    public void setTemp_value(double temp_value) {
        Temp_value = temp_value;
    }

    /**
     * Getter for humidity value.
     * @return Humidity value.
     */
    public double getHumidity_value() {
        return Humidity_value;
    }

    /**
     * Setter for humidity value.
     * @param humidity_value
     */
    public void setHumidity_value(double humidity_value) {
        Humidity_value = humidity_value;
    }

    /**
     * Getter for passenger value.
     * @return Passenger value.
     */
    public int getPassenger_value() {
        return Passenger_value;
    }

    /**
     * Setter for passenger value.
     * @param passenger_value
     */
    public void setPassenger_value(int passenger_value) {
        Passenger_value = passenger_value;
    }

    /**
     * Getter for shaft status.
     * @return Shaft status.
     */
    public int getShaftStatus()
    {
        return shaftStatus;
    }

    /**
     * Setter for shaft status.
     * @param shaftStatus
     */
    public void setShaftStatus(int shaftStatus)
    {
        this.shaftStatus = shaftStatus;
    }
}
