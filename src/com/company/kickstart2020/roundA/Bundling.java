package com.company.kickstart2020.roundA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bundling {

    int maxScore = 0;

    class TrieNode {
        TrieNode[] arr;
        int count;

        public TrieNode() {
            this.arr = new TrieNode[26];
            this.count = 0;
        }
    }

    TrieNode build(String[] arr, int n) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            TrieNode cur = root;
            int len = arr[i].length();
            for (int j = 0; j < len; j++) {

                char c = arr[i].charAt(j);
                if (cur.arr[c - 'A'] == null)
                    cur.arr[c - 'A'] = new TrieNode();
                cur = cur.arr[c - 'A'];
            }
            // setting count at leaf node
            cur.count++;
        }
        return root;
    }


    public int solve(int n, int k, String[] arr) {

        TrieNode root = build(arr, n);
        maxScore = 0;
        dfs(root, 0, k);
        return maxScore;
    }

    private void dfs(TrieNode root, int level, int k) {


        for (int i = 0; i < 26; i++) {
            if(root.arr[i]!=null){
                dfs(root.arr[i], level+1, k );
                root.count += root.arr[i].count;
            }
            while(root.count>=k){
                maxScore+=level;
                root.count-=k;
            }
        }
    }

}

class SolutionBundling implements Runnable {

    public void run() {
        FastReader hk = new FastReader();
        int testCases = hk.nextInt();
        String[] arr = new String[100005];
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = hk.nextInt();
            int k = hk.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = hk.next();

            System.out.println(String.format("Case #%d: %d", testCase, new Bundling().solve(n, k, arr)));
        }
    }

    public static void main(String[] args) {
        new Thread(null, new SolutionBundling(), "Bundling solutiomn", 1 << 26).start();

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