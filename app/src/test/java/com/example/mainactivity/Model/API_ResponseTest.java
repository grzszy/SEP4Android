package com.example.mainactivity.Model;

import junit.framework.TestCase;

public class API_ResponseTest extends TestCase {
    Current current = new Current(1,1,1,1,1);
    public void testGetCurrent() {
        assertEquals(current,current.getClass());
    }

    public void testPostShaft() {
    }
}