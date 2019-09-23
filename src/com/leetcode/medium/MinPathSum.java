package com.leetcode.medium;

/**
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Solution:
 * Dynamic Programming
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length<1||grid[0].length<1) return 0;
        int rl = grid.length;
        int cl = grid[0].length;
        int[][] dp = new int[rl][cl];
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                int prevMinValue = getMinFromPrevCells(dp, i, j);
                dp[i][j] = prevMinValue+grid[i][j];
            }
        }
        return dp[rl-1][cl-1];
    }

    private int getMinFromPrevCells(int[][] dp, int i, int j){
        boolean firstRow = i==0?true:false;
        boolean firstCol = j==0?true:false;
        if(firstRow&&firstCol) return 0;
        else if(firstRow) return dp[i][j-1];
        else if(firstCol) return dp[i-1][j];
        else return Math.min(dp[i-1][j], dp[i][j-1]);
    }
}
