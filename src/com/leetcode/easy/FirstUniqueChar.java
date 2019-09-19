package com.leetcode.easy;


/**
 * 387. First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Solution:
 * - Intialize an array of size 128 and get each char count from the string
 * - Go thru the string again and return first occurance of count 1. If not, return -1;
 */
public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        if(s==null||s.isEmpty()) return -1;
        if(s.length()==1) return 0;
        int[] dec = getCountOfEachChar(s);

        for(int i=0;i<s.length();i++){
            if(dec[s.charAt(i)] == 1) return i;
        }
        return -1;
    }

    private int[] getCountOfEachChar(String s){
        int[] dec = new int[128];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            dec[c]++;
        }
        return dec;
    }
}
