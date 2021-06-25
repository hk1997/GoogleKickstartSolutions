package com.company.kickstart2020.roundB.tests;

import com.company.kickstart2020.roundB.BusRoutes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusRoutesTest {
    BusRoutes solver;
    @Before
    public void setup(){
        this.solver = new BusRoutes();
    }

    @Test
    public void test2(){
        assertEquals(6 , solver.solve(new long[]{3,7,2}, 3, 10));
    }

    @Test
    public void test3(){
        assertEquals(99 , solver.solve(new long[]{11,10,5, 50}, 4, 100));
    }

    @Test
    public void test4(){
        assertEquals(1 , solver.solve(new long[]{1}, 1, 1));
    }
}
