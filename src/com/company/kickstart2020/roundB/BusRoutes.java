package com.company.kickstart2020.roundB;

import com.company.FastReader;

public class BusRoutes {
    public long solve(long[] arr, int n, long d) {
        long lastDay = d;
        for (int i = n - 1; i >= 0; i--)
            lastDay = Math.min(lastDay, lastDay - (lastDay % arr[i]));
        return lastDay;
    }
}

class SolutionBusRoutes {
    public static void main(String[] args) {
        FastReader hk = new FastReader();
        long[] arr = new long[1000];
        int tests = hk.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = hk.nextInt();
            long d = hk.nextLong();
            for (int i = 0; i < n; i++) {
                arr[i] = hk.nextLong();
            }
            System.out.println(String.format("Case #%d: %d", test, new BusRoutes().solve(arr, n, d)));
        }
    }
}

