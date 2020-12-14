package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;


public class Shaft {
    @SerializedName("shaft")
    private boolean status;

<<<<<<< Updated upstream
    public Shaft(boolean status){
=======
    /**
     * Constructor for Shaft class.
     * @param status - boolean value (true - shaft on, false - shaft off).
     */
    public Shaft(int status){
>>>>>>> Stashed changes
        this.status = status;

    }

<<<<<<< Updated upstream
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
=======
    /**
     * Getter for shaft status.
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter for shaft status.
     * @param status
     */
    public void setStatus(int status) {
>>>>>>> Stashed changes
        this.status = status;
    }
}
