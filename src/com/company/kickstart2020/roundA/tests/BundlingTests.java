package com.company.kickstart2020.roundA.tests;

import com.company.kickstart2020.roundA.Bundling;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BundlingTests {
    Bundling bundling;

    @Before
    public void setup() {
        bundling = new Bundling();
    }

    @Test
    public void test1() {
        assertEquals(6, bundling.solve(6, 3, new String[]{"RAINBOW", "FIREBALL", "RANK", "RANDOM", "FIREWALL", "FIREFIGHTER"}));
    }


}
