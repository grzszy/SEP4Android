package com.example.mainactivity.Model;

import junit.framework.TestCase;

public class ShaftTest extends TestCase {
    public void getStatus(){
        Shaft shaft = new Shaft(1);
        assertEquals(1,shaft.getStatus());
    }

    public void setStatus(){
        Shaft shaft = new Shaft(1);
        shaft.setStatus(0);
        assertEquals(0,shaft.getStatus());
    }
}