package com.company.kickstart2020.roundA.roundB.tests;

import com.company.kickstart2020.roundA.roundB.BikeTour;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BikeTourTests {
    BikeTour solver;
    @Before
    public void setup(){
        solver = new BikeTour();
    }

    @Test
    public void test1(){
        assertEquals(1, solver.solve(3, new int[]{10,20, 14}));
    }

    @Test
    public void test2(){
        assertEquals(0, solver.solve(4, new int[]{7,7, 7, 7}));
    }

    @Test
    public void test3(){
        assertEquals(2, solver.solve(5, new int[]{10,90,20,90,10}));
    }

    @Test
    public void test4(){
        assertEquals(0, solver.solve(3, new int[]{10,3,10}));
    }
}
