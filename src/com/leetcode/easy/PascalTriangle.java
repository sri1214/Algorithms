package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * Sol: Time Complexity & Space Complexity - O(n^2)
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0||j==i-1) row.add(1);
                else{
                    if(i>2){
                        row.add(prevRow.get(j-1)+prevRow.get(j));
                    }
                }
            }
            sol.add(row);
            prevRow=row;
        }
        return sol;
    }
}
