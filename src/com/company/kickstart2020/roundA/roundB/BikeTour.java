package com.company.kickstart2020.roundA.roundB;

import com.company.FastReader;

public class BikeTour {

    public int solve(int n, int[] arr) {
        int peaks = 0;
        for(int i=1; i<n-1;i++){
            if(arr[i]> arr[i-1] && arr[i]>arr[i+1])
                peaks++;
        }
        return peaks;
    }
}

class SolutionBokeTour{
    public static void main(String[] args) {
        FastReader hk = new FastReader();
        int tests = hk.nextInt();
        int[] arr = new int[100];
        for(int test = 1 ; test<=tests;test++){
            int n = hk.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = hk.nextInt();
            System.out.println(String.format("Case #%d: %d", test, new BikeTour().solve(n,arr)));
        }

    }
}