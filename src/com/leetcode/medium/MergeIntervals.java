package com.leetcode.medium;

/**
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return intervals;
        }
        int[][] mergedIntervals = new int[intervals.length][2];
        sort(intervals);
        mergedIntervals[0] = intervals[0];
        int j=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=mergedIntervals[j][1]){
                mergedIntervals[j][1] = Math.max(mergedIntervals[j][1],intervals[i][1]);
            } else {
                mergedIntervals[++j] = intervals[i];
            }
        }
        int[][] temp = new int[j+1][2];
        for(int i=0;i<temp.length;i++){
            temp[i] = mergedIntervals[i];
        }

        return temp;
    }

    private void sort(int[][] intervals){
        int[][] aux = new int[intervals.length][2];
        mergeSort(intervals, aux, 0, intervals.length-1);
    }

    private void mergeSort(int[][] input, int[][] aux, int start, int end){
        if(start-end==1){
            if(input[end][0]<input[start][0]){
                swap(input, start, end);
            }else if(input[end][0]==input[start][0]) {
                if(input[end][1]<input[start][1]){
                    swap(input, start, end);
                }
            }
        }
        if(start<end){
            int mid = start + ((end-start)/2);
            mergeSort(input, aux, start, mid);
            mergeSort(input, aux, mid+1, end);
            merge(input, aux, start, mid, end);
        }
    }

    private void merge(int[][] input, int[][] aux, int start, int mid, int end){
        for(int i=start;i<=end;i++){
            aux[i] = input[i];
        }
        int k = start, i = start, j = mid+1;
        while(k<=end){
            if(i>mid) input[k++] = aux[j++];
            else if(j>end) input[k++] = aux[i++];
            else if(aux[j][0]<aux[i][0])  input[k++] = aux[j++];
            else if(aux[i][0]==aux[j][0]&&aux[j][1]<aux[i][1]) input[k++] = aux[j++];
            else input[k++] = aux[i++];
        }
    }

    private void swap(int[][] input, int i, int j){
        int[] temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
