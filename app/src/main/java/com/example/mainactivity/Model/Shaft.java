package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

public class Shaft {

    /**
     * @author Grzegorz Szyszka
     */

    @SerializedName("shaft")
    private int status;

    /**
     * Constructor for Shaft class.
     * @param status
     */
    public Shaft(int status){
        this.status = status;

    }

    /**
     * Getter for shaft status.
     * @return status boolean (true - shaft on, false - shaft off)
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter for shaft status.
     * @param status boolean (true - shaft on, false - shaft off)
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
