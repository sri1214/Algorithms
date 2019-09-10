package com.leetcode;

/**
 * Problem:70
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Solution
 * Dynamic Programming
 * - Create an array of size n+1.
 * - to reach nth step it takes f[n-1] + f[n-2]
 * Time Complexity - O(n), Size Complexity - O(n).
 *
 * Better Solution
 * Fibonacci Number
 * In the above approach we have used dpdp array where dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2].
 * It can be easily analysed that dp[i]dp[i] is nothing but ith fibonacci number.
 *
 * Fib(n)=Fib(n-1)+Fib(n-2)
 *
 * Now we just have to find nth number of the fibonacci series having 1 and 2 their first and second term respectively,
 * i.e. Fib(1)=1Fib(1)=1 and Fib(2)=2Fib(2)=2.
 * Time Complexity - O(n), Size Complexity - O(1).
 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<1) return 0;
        if(n==1) return 1;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for(int i=3;i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public int climbStairsSol2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
