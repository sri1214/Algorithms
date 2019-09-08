package com.sort;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("Merge Sort!");
    }

    public void sort(int[] input){
        int[] aux = new int[input.length];
        mergeSort(input, aux, 0, input.length-1);
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
