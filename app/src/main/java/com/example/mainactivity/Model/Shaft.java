package com.example.mainactivity.Model;

import com.google.gson.annotations.SerializedName;

public class Shaft {
    @SerializedName("shaft")
    private boolean status;

    public Shaft(boolean status){
        this.status = status;

    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
