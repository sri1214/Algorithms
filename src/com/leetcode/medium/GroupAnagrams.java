package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        System.out.printf("Sol: %s", ga.groupAnagrams(new String[]{"tea","and","ate","eat","den"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null) return null;
        List<List<String>> sol = new ArrayList();
        for(String str:strs){
            List<String> matchingAnaList = getMatchingAnaList(sol, str);
            System.out.printf("Input String: %s , MatchingList: %s\n", str, matchingAnaList);
            if(matchingAnaList!=null){
                matchingAnaList.add(str);
            }
            else{
                List<String> newAnaList = new ArrayList();
                newAnaList.add(str);
                sol.add(newAnaList);
            }
        }
        return sol;
    }

    private List<String> getMatchingAnaList(List<List<String>> sol, String inputStr){
        topLoop: for(List<String> anaList:sol){
            char[] alphabets = new char[128];
            String str = anaList.get(0);
            if(str.length()!=inputStr.length()) continue;
            for(char ch:str.toCharArray()){
                alphabets[ch]++;
            }

            for(char ch:inputStr.toCharArray()){
                if(alphabets[ch]==0) continue topLoop;
                else  alphabets[ch]--;
            }
            return anaList;
        }
        return null;
    }
}
