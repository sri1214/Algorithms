package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
public class TopKFreqWords {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        TopKFreqWords topKFreqWords = new TopKFreqWords();
        System.out.println(topKFreqWords.topKFrequent(words, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        String[] sol = new String[k];
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word:words){
            if (wordMap.containsKey(word)) {
                wordMap.replace(word, wordMap.get(word)+1);
            }else {
                wordMap.put(word, 1);
            }
        }

        PriorityQueue<WordCount> pq = new PriorityQueue<WordCount>(11, new OrderByCount());
        for(String key: wordMap.keySet()){
            pq.add(new WordCount(key, wordMap.get(key)));
            if(pq.size()>k){
                pq.poll();
            }
        }

        for(int i=k-1;i>=0;i--){
            sol[i] =  pq.poll().word;
        }
        return Arrays.asList(sol);
    }

    private class WordCount {
         private String word;
         private Integer count;

        public WordCount(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }

    private class OrderByCount implements Comparator<WordCount> {

        @Override
        public int compare(WordCount o1, WordCount o2) {
          if(o1.count.intValue()==o2.count.intValue()) return 1;
          else return o1.count.compareTo(o2.count);
        }
    }
}
