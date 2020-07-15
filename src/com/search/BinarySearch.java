package com.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums={1,3,5,7,9,11, 13};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums, 4));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int i, int j) {
        int h = i + ((j-i)/2);
        if(j-i<4) {
            if(target>=nums[j]) return j;
            else if(target>=nums[h]) return h;
            else return i;
        }
        if(target==nums[h]) return h;
        else if(target>nums[h]) return binarySearch(nums, target, h+1, nums.length-1);
        else return binarySearch(nums, target, 0, h-1);
    }
}
