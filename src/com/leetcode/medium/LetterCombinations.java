package com.leetcode.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.isEmpty()) return new ArrayList<>();
        String[] combinations = new String[1];
        Map<Integer, String> digitMap = initializeDigitMap();
        for(char i:digits.toCharArray()){
            combinations = buildCombinations(combinations,  i, digitMap);
        }
        return Arrays.asList(combinations);
    }

    private String[] buildCombinations(String[] combinations, char i, Map<Integer, String> digitMap){
        String letters = digitMap.get(i-48);
        String[] newCombinations = new String[combinations.length*letters.length()];
        if(combinations.length==1){
            int k=0;
            for(char c:letters.toCharArray()){
                newCombinations[k++] = new String(new char[]{c});
            }
        }else {
            for(int j=0, k=0;j<combinations.length;j++){
                for(char c:letters.toCharArray()){
                    newCombinations[k++] = combinations[j].concat(new String(new char[]{c}));
                }
            }
        }
        return newCombinations;
    }

    private Map<Integer, String> initializeDigitMap(){
        Map<Integer, String> digitMap = new HashMap<>();
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");
        return digitMap;
    }
}
