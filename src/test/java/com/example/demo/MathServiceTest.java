package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MathServiceTest {

    @Test
    public void testCalculations(){
        assertEquals("impossibru!", MathService.calculateQuery("divide", 1, 0));
        assertEquals("1.0", MathService.calculateQuery("add", 1, 0));
        assertEquals("1.0", MathService.calculateQuery("subtract", 2, 1));
        assertEquals("4.0", MathService.calculateQuery("multiply", 2, 2));
    }

    @Test
    public void testSum(){
        ArrayList testlist = new ArrayList();
        testlist.add(1);
        testlist.add(2);
        testlist.add(3);
        assertEquals("6.0", MathService.sumQuery(testlist));
    }
}
