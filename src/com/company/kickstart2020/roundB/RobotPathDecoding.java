package com.company.kickstart2020.roundB;

import com.company.FastReader;


public class RobotPathDecoding {

    static final long modValue = (int) Math.pow(10, 9);

    private long mod(long n) {
        return (n + modValue) % modValue;
    }

    private void handleMove(char c, long[] pos) {
        switch (c) {
            case 'N': {
                pos[1]--;
                pos[1] = mod(pos[1]);
                break;
            }
            case 'S': {
                pos[1]++;
                pos[1] = mod(pos[1]);
                break;
            }
            case 'W': {
                pos[0]--;
                pos[0] = mod(pos[0]);
                break;
            }
            case 'E': {
                pos[0]++;
                pos[0] = mod(pos[0]);
                break;
            }
        }
    }

    private void multiply(int coef, long[] pos) {
        pos[0] = mod(coef * pos[0]);
        pos[1] = mod(coef * pos[1]);
    }

    private void add(long[] pos, long[] pos1) {
        pos[0] = mod(pos[0] + pos1[0]);
        pos[1] = mod(pos[1] + pos1[1]);
    }

    public long[] solve(String s, int start, int n) {
        long[] programOutput = new long[3];

        if (start >= n)
            return programOutput;

        char c;
        for (int i = start; i < n; i++) {
            c = s.charAt(i);
            if (c >= '2' && c <= '9') {
                long[] subProgramOutput = solve(s, i + 2, n);
                multiply(c - '0', subProgramOutput);
                add(programOutput, subProgramOutput);
                i = (int)subProgramOutput[2] ;
            } else if (c == ')'){
                programOutput[2] = i;
                return programOutput;
            }
            else {
                handleMove(c, programOutput);
            }
            programOutput[2] = i;
        }

        return programOutput;
    }
}

class SolutionRobotPathDecoding implements Runnable {

    public void run() {
        FastReader hk = new FastReader();
        int tests = hk.nextInt();
        RobotPathDecoding solver = new RobotPathDecoding();
        for (int test = 1; test <= tests; test++) {
            String s = hk.next();
            long[] pos = solver.solve(s, 0, s.length());
            System.out.println(String.format("Case #%d: %d %d", test, pos[0]+1, pos[1]+1));
        }
    }

    public static void main(String[] args) {

        new Thread(null, new SolutionRobotPathDecoding(), "Robot path decoding main", 1 << 26);

    }
}
