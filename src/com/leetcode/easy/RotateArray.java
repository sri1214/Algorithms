package com.leetcode.easy;

/**
 * 189. Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Solution:
 * Time Complexity and Space Complexity = O(n)
 *
 * Better Solution:
 * Original List                   : 1 2 3 4 5 6 7
 * After reversing all numbers     : 7 6 5 4 3 2 1
 * After reversing first k numbers : 5 6 7 4 3 2 1
 * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 * Time Complexity O(n), space complexity O(1)
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<1) return;
        if(k>nums.length) k%=nums.length;
        int[] copy = new int[nums.length];
        for(int i=0,j=0;i<nums.length;i++){
            if(i+k<nums.length) copy[i+k] = nums[i];
            else copy[j++] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = copy[i];
        }
    }
}
