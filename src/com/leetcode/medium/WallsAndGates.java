package com.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==Integer.MAX_VALUE) {
                    rooms[i][j] = findNearestGate(rooms, i, j);
                }
            }
        }
    }

    private int findNearestGate(int[][] rooms, int i, int j) {
        final int MAX_LEVEL = Integer.max(rooms.length, rooms[0].length);
        int upVal = 0, downVal = 0, leftVal = 0, rightVal = 0;
        for(int level=1;level<=MAX_LEVEL;level++){
            upVal = upVal==-1?upVal:findCellValue(rooms, i-level, j);
            downVal = downVal==-1?downVal:findCellValue(rooms, i+level, j);
            leftVal = leftVal==-1?leftVal:findCellValue(rooms, i, j-level);
            rightVal = rightVal==-1?rightVal:findCellValue(rooms, i, j+level);
            if(upVal==0||downVal==0||leftVal==0||rightVal==0) return level;
            else if(upVal==-1&&downVal==-1&&leftVal==-1&&rightVal==-1) break;
        }
        return Integer.MAX_VALUE;
    }

    private int findCellValue(int[][] rooms, int i, int j) {
        if(i<0||i>=rooms.length||j<0||j>=rooms[0].length) return -1;
        else return rooms[i][j];

    }

    private int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] distance = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startRow, startCol });
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == WALL
                        || distance[r][c] != 0) {
                    continue;
                }
                distance[r][c] = distance[row][col] + 1;
                if (rooms[r][c] == GATE) {
                    return distance[r][c];
                }
                q.add(new int[] { r, c });
            }
        }
        return Integer.MAX_VALUE;
    }
}
