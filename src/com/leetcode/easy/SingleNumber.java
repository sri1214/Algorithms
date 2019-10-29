package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums==null) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(count.containsKey(nums[i])){
                count.remove(nums[i]);
            }
            else count.put(nums[i], 1);
        }
        for(int i:count.keySet()){
            if(count.get(i)==1) return i;
        }
        return 0;
    }
}
