package com.company.kickstart2020.roundA;

/**
 * problem link: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Allocation {

    static int t;
    static int n;
    static int b;
    static int[] a;
    static FastReader hk = new FastReader();

    public static void handleInput(){
        n = hk.nextInt();
        b = hk.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = hk.nextInt();
        }
    }

    public static void main(String[] args) {
         t = hk.nextInt();
         for(int i=1;i<=t;i++){
             handleInput();
             Arrays.sort(a);
             int count =0;
             while(b>=0 && count<n){
                 b -=a[count];
                 if(b>=0){
                     count++;
                 }
             }
             System.out.println(String.format("Case #%d: %d", i,count));
         }
    }


    // fastreader
    static  class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
