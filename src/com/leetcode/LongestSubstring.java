package com.leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Solution
 * Step1: Initialize an array of 128 size to index of each char from the string. (decimal values of A - Z = 65 - 90, a - z = 97 - 122)
 * Step2: Iterate thru each char in the string,
 *          - If index of the char exists in the array, set the string index to the index from array, calc length from temp length and reset array.
 *          - If not, then store the index in the array and increment temp length.
 */

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty()) return 0;
        if(s.length() ==1) return 1;
        int l = 0, j = 0;
        int[] dec = new int[128];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(dec[c]>0){
                i = dec[c]-1;
                l = l>j?l:j;
                j = 0;
                dec = new int[128];
                continue;
            }
            dec[c] = i+1;
            j++;
        }
        l = l>j?l:j;
        return l;
    }
}
