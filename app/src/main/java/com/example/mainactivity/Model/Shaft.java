package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

public class Shaft {
    @SerializedName("shaft")
    private int status;

    public Shaft(int status){
        this.status = status;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
