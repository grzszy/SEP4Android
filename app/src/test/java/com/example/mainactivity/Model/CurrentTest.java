package com.example.mainactivity.Model;

import junit.framework.TestCase;

public class CurrentTest extends TestCase {
    Current current = new Current(1,1,1,1,1);
    public void testGetCO2_value() {
        assertEquals(1,current.getCO2_value());
    }

    public void testSetCO2_value() {
        current.setCO2_value(2);
        assertEquals(2,current.getCO2_value());
    }

    public void testGetTemp_value() {
        assertEquals(1,current.getTemp_value());
    }

    public void testSetTemp_value() {
        current.setTemp_value(2);
        assertEquals(2,current.getTemp_value());
    }

    public void testGetHumidity_value() {
        assertEquals(2,current.getHumidity_value());
    }

    public void testSetHumidity_value() {
        current.setCO2_value(2);
        assertEquals(2,current.getHumidity_value());
    }

    public void testGetPassenger_value() {
        assertEquals(1,current.getPassenger_value());
    }

    public void testSetPassenger_value() {
        current.setCO2_value(2);
        assertEquals(2,current.getPassenger_value());
    }

    public void testGetShaftStatus() {
        assertEquals(1,current.getShaftStatus());
    }

    public void testSetShaftStatus() {
        current.setShaftStatus(2);
        assertEquals(2,current.getShaftStatus());
    }
}