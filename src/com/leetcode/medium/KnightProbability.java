package com.leetcode.medium;

public class KnightProbability {

    public static void main(String[] args) {
        KnightProbability kp = new KnightProbability();
        System.out.println(kp.knightProbability(3, 3, 0, 0));
    }

    public double knightProbability(int N, int K, int r, int c) {
        if(N<3||K<1) return 0;
        double[][] board = new double[N][N];
        int[][] possibleSteps = new int[][]{
                {-1, -2},
                {-1, 2},
                {1, -2},
                {1, 2},
                {-2, -1},
                {-2, 1},
                {2, -1},
                {2, 1}
        };
        board[r][c] = 1;
        double prob = 0;
        for(int steps = 1;steps<=K;steps++){
            double prevProb = 1 / Math.pow(8, steps-1);
            double currProb = 1 / Math.pow(8, steps);
            double totalProbInCurrStep = 0;
            System.out.println("prev prob and curr prob - "+prevProb+" ,"+currProb);
            boolean onboard = false;
            for(int i=0;i<N;i++){ //iterating each row
                for(int j=0;j<N;j++){ //iterating each column
                    if(board[i][j] ==prevProb) continue; //consider only the blocks other than prev steps
                    board[i][j] = 0; //intialize those blocks to 0;
                    //System.out.println("i, j and value "+i+", "+j+" and "+board[i][j]);
                    for(int k=0;k<8;k++){ // //iterating each possible steps
                        int a = i+possibleSteps[k][0];
                        int b = j+possibleSteps[k][1];
                        if(a<0||b<0||a>N-1||b>N-1) continue; // check if its a valid step
                        if(board[a][b]==prevProb) { //check if its a valid prev step
                            System.out.println("\ti, j and value "+i+", "+j+" and "+board[i][j]);
                            System.out.println("\ta, b and value "+a+", "+b+" and "+board[a][b]);
                            board[i][j] =  currProb;
                            totalProbInCurrStep = totalProbInCurrStep + currProb;
                            onboard = true;
                        }
                    }
                }
            }
            if(onboard) {
                System.out.println("Total prob in current step - "+totalProbInCurrStep);
                prob = totalProbInCurrStep;
            }
            else break;
        }
        return prob;
    }

    public double knightProbability2(int N, int K, int sr, int sc) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[sr][sc] = 1;
        for (; K > 0; K--) {//for each step
            double[][] dp2 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) { //iterate thru each block
                    for (int k = 0; k < 8; k++) {
                        int cr = r + dr[k];
                        int cc = c + dc[k];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                            dp2[cr][cc] += dp[r][c] / 8.0; // existingValue in DP2 + prevValue from DP(prev iteration) / 8
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) ans += x;
        }
        return ans;
    }
}
