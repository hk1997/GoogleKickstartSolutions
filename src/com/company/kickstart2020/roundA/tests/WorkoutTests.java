package com.company.kickstart2020.roundA.tests;

import com.company.kickstart2020.roundA.Workout;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkoutTests {
    Workout workout;

    @Before
    public void setup() {
        workout = new Workout();
    }

    @Test
    public void test1() {
        assertEquals(2, workout.solve(new int[]{10, 13, 15, 16, 17}, 5, 2));
    }

    @Test
    public void test2() {
        assertEquals(3, workout.solve(new int[]{9, 10, 20, 26, 30}, 5, 6));
    }

    @Test
    public void test3() {
        assertEquals(1, workout.solve(new int[]{1, 2, 3, 4, 5, 6, 7, 10}, 8, 3));
    }

    @Test
    public void test4() {
        assertEquals(40, workout.solve(new int[]{1,121}, 2, 2));
    }

    @Test
    public void test5() {
        assertEquals(30, workout.solve(new int[]{1,121}, 2, 3));
    }
}
