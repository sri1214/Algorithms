package com.leetcode.medium;


/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Solution: Binary Search
 *
 */
public class MinInRotSortArray {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        int left = 0, right = nums.length-1;
        while(right-left >1){
            int mid = left + (right-left)/2;
            if(nums[left] > nums[mid]) right = mid;
            else if(nums[right] < nums[mid]) left = mid;
            else return nums[left];
        }
        return Math.min(nums[left], nums[right]);
    }
}
