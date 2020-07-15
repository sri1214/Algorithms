package com.leetcode.easy;

/**
 * 724. Find Pivot Index
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        findPivotIndex.pivotIndex(new int[]{1,7,3,6,5,6});
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sfl = new int[len]; //sum from left
        int[] sfr = new int[len]; //sum from right
        int tl=0, tr=0;
        for(int i=0, j=len-1;i<len;i++,j--){
            sfl[i] = tl+nums[i];
            sfr[j] = tr+nums[j];
            tl=sfl[i];
            tr=sfr[j];
        }
        System.out.println(sfr[0]);
        System.out.println(sfl[len-1]);
        if(sfr[0]==sfl[len-1]){
            for(int i=0;i<len;i++){
                if(sfl[i]==sfr[i]) return i;
            }
        }
        return -1;
    }
}
