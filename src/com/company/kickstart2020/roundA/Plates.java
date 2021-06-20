package com.company.kickstart2020.roundA;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
Question link: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d40bb#problem
 */


public class Plates {

    static int MAX_N = 35;
    static int MAX_K = 55;
    static int MAX_P = MAX_N*MAX_K;
    static  int[][] dp = new int[MAX_N][MAX_P+1];
    static int[][] a = new int[MAX_N][MAX_K];
    static int[][] sum = new int[MAX_N][MAX_K];

    private static int solve(int n, int k, int p, int[][] a){
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= k;j++) {
                for(int q = j;q <= p;q++) {
                    dp[i][q] = Math.max(dp[i][q],Math.max(dp[i - 1][q],dp[i - 1][q - j] + a[i][j]));
                }
            }
        }

        return dp[n][p];
    }

    public static void main(String[] args) {
        FastReader hk = new FastReader();
        int tests= hk.nextInt();
        for(int test=1;test<=tests; test++){
            int n = hk.nextInt();
            int k = hk.nextInt();
            int p = hk.nextInt();

            for(int i=1;i<=n;i++){
                for(int j=1;j<=k;j++){
                    a[i][j] = hk.nextInt();
                    sum[i][j] = sum[i][j - 1] + a[i][j];
                }
            }

            System.out.println(String.format("Case #%d: %d", test, solve(n,k,p,sum)));

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
