package com.company.kickstart2020.roundA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f5b
 */


class Solution {
    public static void main(String[] args) {
        FastReader hk = new FastReader();
        int tests = hk.nextInt();
        int[] arr = new int[100005];
        for (int test = 1; test <= tests; test++) {
            int n = hk.nextInt();
            int k = hk.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = hk.nextInt();
            int sol = new Workout().solve(arr, n, k);
            System.out.println(String.format("Case #%d: %d", test, sol));
        }


    }
}

public class Workout {

    private int bs(int low, int high, int[] arr, int k, int n){
        if(low>=high)
            return low;
        int mid = (low+high)/2;
        if(check(mid,arr, k, n))
            high = mid;
        else
            low = mid+1;
        return bs(low, high, arr, k, n);
    }

    private boolean check(int d, int[] arr, int k, int n) {
        int count =0;
        for(int i=1;i<n;i++)
            count += (arr[i]-arr[i-1]-1)/d ;
        return count<=k;
    }

    public int solve(int[] arr, int n, int k) {
       return  bs(1, arr[n-1]-arr[0], arr, k,n);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
