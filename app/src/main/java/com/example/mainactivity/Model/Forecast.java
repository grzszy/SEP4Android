package com.example.mainactivity.Model;

public class Forecast {


    private int co2_8;
    private int co2_12;
    private int co2_16;
    private int co2_20;

    private int humidity_8;
    private int humidity_12;
    private int humidity_16;
    private int humidity_20;

    private int temp_8;
    private int temp_12;
    private int temp_16;
    private int temp_20;

    private int numberOfPassengers_8;
    private int numberOfPassengers_12;
    private int numberOfPassengers_16;
    private int numberOfPassengers_20;


    public Forecast(int co2_8, int co2_12, int co2_16, int co2_20,
                    int humidity_8, int humidity_12, int humidity_16, int humidity_20,
                    int temp_8, int temp_12, int temp_16, int temp_20,
                    int numberOfPassengers_8, int numberOfPassengers_12, int numberOfPassengers_16, int numberOfPassengers_20)
    {
        this.co2_8 = co2_8;
        this.co2_12 = co2_12;
        this.co2_16 = co2_16;
        this.co2_20 = co2_20;

        this.humidity_8 = humidity_8;
        this.humidity_12 = humidity_12;
        this.humidity_16 = humidity_16;
        this.humidity_20 = humidity_20;

        this.temp_8 = temp_8;
        this.temp_12 = temp_12;
        this.temp_16 = temp_16;
        this.temp_20 = temp_20;

        this.numberOfPassengers_8 = numberOfPassengers_8;
        this.numberOfPassengers_12 = numberOfPassengers_12;
        this.numberOfPassengers_16 = numberOfPassengers_16;
        this.numberOfPassengers_20 = numberOfPassengers_20;

    }

    public int getCo2_8() {
        return co2_8;
    }

    public void setCo2_8(int co2_8) {
        this.co2_8 = co2_8;
    }

    public int getCo2_12() {
        return co2_12;
    }

    public void setCo2_12(int co2_12) {
        this.co2_12 = co2_12;
    }

    public int getCo2_16() {
        return co2_16;
    }

    public void setCo2_16(int co2_16) {
        this.co2_16 = co2_16;
    }

    public int getCo2_20() {
        return co2_20;
    }

    public void setCo2_20(int co2_20) {
        this.co2_20 = co2_20;
    }

    public int getHumidity_8() {
        return humidity_8;
    }

    public void setHumidity_8(int humidity_8) {
        this.humidity_8 = humidity_8;
    }

    public int getHumidity_12() {
        return humidity_12;
    }

    public void setHumidity_12(int humidity_12) {
        this.humidity_12 = humidity_12;
    }

    public int getHumidity_16() {
        return humidity_16;
    }

    public void setHumidity_16(int humidity_16) {
        this.humidity_16 = humidity_16;
    }

    public int getHumidity_20() {
        return humidity_20;
    }

    public void setHumidity_20(int humidity_20) {
        this.humidity_20 = humidity_20;
    }

    public int getTemp_8() {
        return temp_8;
    }

    public void setTemp_8(int temp_8) {
        this.temp_8 = temp_8;
    }

    public int getTemp_12() {
        return temp_12;
    }

    public void setTemp_12(int temp_12) {
        this.temp_12 = temp_12;
    }

    public int getTemp_16() {
        return temp_16;
    }

    public void setTemp_16(int temp_16) {
        this.temp_16 = temp_16;
    }

    public int getTemp_20() {
        return temp_20;
    }

    public void setTemp_20(int temp_20) {
        this.temp_20 = temp_20;
    }

    public int getNumberOfPassengers_8() {
        return numberOfPassengers_8;
    }

    public void setNumberOfPassengers_8(int numberOfPassengers_8) {
        this.numberOfPassengers_8 = numberOfPassengers_8;
    }

    public int getNumberOfPassengers_12() {
        return numberOfPassengers_12;
    }

    public void setNumberOfPassengers_12(int numberOfPassengers_12) {
        this.numberOfPassengers_12 = numberOfPassengers_12;
    }

    public int getNumberOfPassengers_16() {
        return numberOfPassengers_16;
    }

    public void setNumberOfPassengers_16(int numberOfPassengers_16) {
        this.numberOfPassengers_16 = numberOfPassengers_16;
    }

    public int getNumberOfPassengers_20() {
        return numberOfPassengers_20;
    }

    public void setNumberOfPassengers_20(int numberOfPassengers_20) {
        this.numberOfPassengers_20 = numberOfPassengers_20;
    }
}
