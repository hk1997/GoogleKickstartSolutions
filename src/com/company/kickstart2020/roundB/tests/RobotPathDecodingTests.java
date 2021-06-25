package com.company.kickstart2020.roundB.tests;

import com.company.kickstart2020.roundB.RobotPathDecoding;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RobotPathDecodingTests {

    RobotPathDecoding solver;

    @Before
    public void setup(){
        this.solver = new RobotPathDecoding();
    }

    @Test
    public void test1(){
        long[] res = this.solver.solve("SSSEEE", 0 , 6);
        assertEquals(3, res[0]);
        assertEquals(3, res[1]);
//        assertArrayEquals(new long[]{3,3} , this.solver.solve("SSSEEE", 0 , 6));
    }

    @Test
    public void test2(){
        long[] res = this.solver.solve("N2(3(S))", 0 , 8);
        assertEquals(0, res[0]);
        assertEquals(5, res[1]);
    }

    @Test
    public void test3(){
        long[] res = this.solver.solve("N", 0 , 1);
        assertEquals(0, res[0]);
        assertEquals(1000000000-1, res[1]);
    }

    @Test
    public void test4(){
        String s = "N3(S)N2(E)N";
        long[] res = this.solver.solve(s, 0 , s.length());
        assertEquals(2, res[0]);
        assertEquals(0, res[1]);
    }

    @Test
    public void test5(){
        String s = "2(3(NW)2(W2(EE)W))";
        long[] res = this.solver.solve(s, 0 , s.length());
        assertEquals(2, res[0]);
        assertEquals(999999994, res[1]);
    }
}
