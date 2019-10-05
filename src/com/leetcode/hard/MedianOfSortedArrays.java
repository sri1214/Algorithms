package com.leetcode.hard;


/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * Solution:
 * similar to merge sort
 * TIme Complexity and Space Complexity - O((m+n)/2)
 *
 *
 */
public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length+nums2.length;
        int[] mergedNums = new int[(totalLength/2)+1];
        int i=0, j=0, k=0;
        while(k<=totalLength/2){
            if(j==nums2.length) mergedNums[k++] = nums1[i++];
            else if(i==nums1.length) mergedNums[k++] = nums2[j++];
            else if(nums1[i]>nums2[j]) mergedNums[k++] = nums2[j++];
            else mergedNums[k++] = nums1[i++];
        }
        int mid=totalLength/2;
        if(totalLength%2==1) {
            return mergedNums[mid];
        }else {
            return (mergedNums[mid-1]+mergedNums[mid])/2.0;
        }
    }
}
