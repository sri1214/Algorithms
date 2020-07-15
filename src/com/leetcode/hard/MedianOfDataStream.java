package com.leetcode.hard;

/**
 * 295.Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 */

import java.util.PriorityQueue;

public class MedianOfDataStream {
    PriorityQueue<Integer> fHalf;
    PriorityQueue<Integer> sHalf;

    /** initialize your data structure here. */
    public MedianOfDataStream() {
        fHalf = new PriorityQueue<>((i,j) -> j-i);
        sHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(fHalf.isEmpty()||num<=fHalf.peek()) fHalf.add(num);
        else sHalf.add(num);
        int sizeDiff = fHalf.size() - sHalf.size();
        if(Math.abs(sizeDiff)>1)
            rebalance();
    }

    public double findMedian() {
        if(fHalf.isEmpty()) return 0.0;
        if(fHalf.size()==sHalf.size()){
            return (fHalf.peek()+sHalf.peek())/2.0;
        }else if(fHalf.size()>sHalf.size()){
            return fHalf.peek();
        }else return sHalf.peek();
    }

    private void rebalance(){
        if(fHalf.size()>sHalf.size()) sHalf.add(fHalf.remove());
        else fHalf.add(sHalf.remove());
    }

    public static void main(String[] args) {
        MedianOfDataStream medianOfDataStream = new MedianOfDataStream();
        medianOfDataStream.addNum(1);
        medianOfDataStream.addNum(2);
        medianOfDataStream.addNum(3);
        System.out.println(medianOfDataStream.findMedian());

    }
}
