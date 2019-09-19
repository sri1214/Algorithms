package com.leetcode.easy;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Solution:
 * step1 : copy an array, and sort it using merge sort, O(nlogn)
 *
 * step2 : using start and end points to find a, b which satifys a+b==target, O(n)
 *
 * step3 : find the index of a, b from origin array, O(n)
 *
 */
public class TwoSum {

    public static void main(String[] args) {

        System.out.println("Two Sum!");

    }

    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return null;

        int[] copy = makeACopy(nums);
        sort(nums);

        for(int i=0; i<nums.length; i++){
            int rem = target - nums[i];
            int pos = binarySearch(nums, rem);
            if(rem == nums[pos]){
                int[] twoSum = getPosFromCopy(nums, copy, i, pos);
                return twoSum;
            }

        }
        return null;
    }

    private int[] makeACopy(int[] nums){
        int[] copy = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            copy[i] = nums[i];
        }
        return copy;
    }

    private int[] getPosFromCopy(int[] sort, int[] org, int i, int j){
        int[] twoSum = new int[2];
        for(int k=0, c=0; k<org.length||c<2; k++){
            if(sort[i] == org[k]){
                twoSum[c++] = k;
            }

            else if(sort[j] == org[k]){
                twoSum[c++] = k;
            }
        }
        return twoSum;
    }

    private int binarySearch(int[] nums, int n){
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + ((end - start)/2);
            if(nums[mid] == n) return mid;
            else if(nums[mid] > n) end = mid-1;
            else start = mid+1;
        }
        return start;
    }

    private void sort(int[] nums){
        int[] aux = new int[nums.length];
        mergeSort(nums, aux, 0, nums.length-1);
    }

    private void mergeSort(int[] nums, int[] aux, int start, int end){
        if(start==end) return;
        int mid = start + ((end - start + 1)/2);
        mergeSort(nums, aux, start, mid-1);
        mergeSort(nums, aux, mid, end);
        merge(nums, aux, start, mid, end);
    }

    private void merge(int[] nums, int[] aux, int start, int mid, int end){
        for(int i=start;i<=end;i++){
            aux[i] = nums[i];
        }
        int i = start, k = start, j = mid;
        while(k<=end){
            if(i>mid-1) nums[k++] = aux[j++];
            else if(j>end) nums[k++] = aux[i++];
            else if(aux[j] < aux[i]) nums[k++] = aux[j++];
            else nums[k++] = aux[i++];
        }
    }
}
