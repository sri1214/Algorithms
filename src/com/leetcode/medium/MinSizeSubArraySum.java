package com.leetcode.medium;

/**
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Solution:
 *
 */
public class MinSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int sum=0, len=Integer.MAX_VALUE, left=0;
        boolean foundSum = false;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            while(sum>=s){
                foundSum = true;
                len = Math.min(len, (i-left)+1);
                sum-=nums[left];
                left++;
            }
        }
        return foundSum?len:0;
    }
}
