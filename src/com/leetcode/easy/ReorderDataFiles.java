package com.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;


/**
 * 937. Reorder Data in Log Files
 * You have an array of logs.  Each log is a space delimited string of words.
 *For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *Return the final order of the logs.
 *
 * Example
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderDataFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};


        System.out.println(Pattern.compile("\\d").matcher("8 1 5 1").find());
        System.out.println(Pattern.compile("\\d").matcher("log").find());
        ReorderDataFiles reorderDataFiles = new ReorderDataFiles();
        System.out.println(Arrays.toString(reorderDataFiles.reorderLogFiles((logs))));
    }

    public String[] reorderLogFiles(String[] logs) {
        if(logs==null) return null;
        Arrays.sort(logs, new LogOrder());
        return logs;
    }

    private class LogOrder implements Comparator<String> {

        public int compare(String log1, String log2) {
            String[] logDelim1=log1.split(" ", 2);
            String[] logDelim2=log2.split(" ", 2);
            boolean log1IsaDigLog = isDigitLog(logDelim1[1]);
            boolean log2IsaDigLog = isDigitLog(logDelim2[1]);

            if(!log1IsaDigLog && log2IsaDigLog)
                return -1;
            else if(log1IsaDigLog && !log2IsaDigLog)
                return 1;
            else if(!log1IsaDigLog && !log2IsaDigLog) {
                int i= logDelim1[1].compareTo(logDelim2[1]);
                if(i!=0) return i;
                else return logDelim1[0].compareTo(logDelim2[0]);
            }

            else
                return 0;
        }


        private boolean isDigitLog(String log) {
            int first = log.charAt(0);
            if(first>47&&first<58) return true;
            return false;
        }
    }
}
