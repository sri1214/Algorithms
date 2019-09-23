package com.leetcode.easy;

import java.util.Arrays;

/**
 * 443. String Compression
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 * Example:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 */
public class StringCompression {

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'b', 'c', 'c'};
        System.out.printf("Sol: %d\n", sc.compress(chars));
        System.out.println(Arrays.toString(chars));
    }
    public int compress(char[] chars) {
        char[] compressed = new char[chars.length];
        int charCount = 1, j=1;
        compressed[0] = chars[0];
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                charCount++;
            }
            else{
                if(charCount>1){
                    char[] countAsChar = getCountAsChar(charCount);
                    for(char ch:countAsChar){
                        compressed[j++] = ch;
                    }
                }
                compressed[j++] = chars[i];
                charCount=1;
            }
        }
        if(charCount>1){
            char[] countAsChar = getCountAsChar(charCount);
            for(char ch:countAsChar){
                compressed[j++] = ch;
            }
        }
        copy(chars, compressed, j);
        return j;
    }

    private void copy(char[] chars, char[] compressed, int length){
        for(int i=0;i<length;i++){
            chars[i]=compressed[i];
        }
    }

    private char[] getCountAsChar(int count){
        int length = 0;
        if(count<10) length=1;
        else if(count<100) length=2;
        else if(count<1000) length=3;
        char[] charCount = new char[length];

        int i = length-1, rem = 0;
        while(i>=0){
            charCount[i--] = (char)((count%10)+48);
            count = count/10;
        }

        return charCount;
    }

}
