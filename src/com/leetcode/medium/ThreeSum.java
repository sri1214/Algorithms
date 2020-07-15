package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        boolean hasZero = false;
        for (int num : nums) {
            if (num < 0) neg.add(num);
            else if (num > 0) neg.add(num);
            else hasZero = true;
        }
        Collections.sort(neg);
        Collections.sort(pos);
        compileSol(pos, neg, sol);
        compileSol(neg, pos, sol);
        if (hasZero) {
            for (int i = 0; i < neg.size(); i++) {
                int sum = 0 - neg.get(i);
                int k = Collections.binarySearch(pos, sum);
                if (k < 0) continue;
                List<Integer> list = new ArrayList<>(Arrays.asList(neg.get(i), pos.get(k), 0));
                sol.add(list);
            }
        }
        return sol;
    }

    private void compileSol(List<Integer> list1, List<Integer> list2, List<List<Integer>> sol) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                int sum = 0 - (list1.get(i) + list1.get(j));
                int k = Collections.binarySearch(list2, sum);
                if (k < 0) continue;
                List<Integer> list = new ArrayList<>(Arrays.asList(list1.get(i), list1.get(j), list2.get(k)));
                sol.add(list);
            }
        }
    }
}
