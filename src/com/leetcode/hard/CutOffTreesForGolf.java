package com.leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolf {
    List<int[]> neighbors = Arrays.asList(new int[][]{{0,1},{0,-1},{1,0},{-1,0}});
    public int cutOffTree(List<List<Integer>> forest) {
        int treeCount = 0, treeCutCount = 0;
        int rowCount = forest.size();
        int columnCount = forest.get(0).size();
        for(int r=0;r<rowCount;r++){
            for(int c=0;c<columnCount;c++){
                if(r==0&&c==0) {
                    forest.get(r).set(c, 1);
                    continue;
                }
                int cell=forest.get(r).get(c);
                if(cell>1) treeCount++;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int[] n:neighbors){
                int r = p[0] + n[0];
                int c = p[1] + n[1];
                if(r<0||c<0||r>=rowCount||c>=columnCount) continue;
                int cell = forest.get(r).get(c);
                if(cell==0) continue;
                if(cell>1) treeCutCount++;
                forest.get(r).set(c, 1);
                q.add(new int[]{r,c});
            }
        }

        return treeCount==treeCutCount?treeCount:-1;
    }
}
