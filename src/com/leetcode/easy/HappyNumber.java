package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * Input: 19
 * Output: true
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.isHappy(18);
    }

    public boolean isHappy(int n) {
        List<Integer> squaresOfDigits = new ArrayList<>();
        while(n!=1){
            System.out.printf("n - %d\n", n);
            n = findSquaresOfDigits(n);
            if(squaresOfDigits.contains(n)) return false;
            squaresOfDigits.add(n);
        }
        return true;
    }

    private int findSquaresOfDigits(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += Math.pow((n % 10) , 2);
            n /= 10;
        }
        sum += Math.pow(n, 2);
        return sum;
    }

}
