package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.printf("Solution: %s", sm.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] comRow = new int[rowCount];
        int[] comCol = new int[colCount];
        List<Integer> sol = new ArrayList<>();

        boolean rowFromLeft = true, rowFromRight = false, colFromTop = false, colFromDown = false;
        int i=0, j=0;

        while(true){
            if(rowFromLeft){
                System.out.println("\n***Row from left**\n");
                comRow[i] = 1;
                rowFromLeft=false;
                boolean readFromMatrix=false;
                while(true){

                    System.out.printf("Row: %d, col: %d\n", i, j);
                    readFromMatrix=true;
                    sol.add(matrix[i][j]);
                    if(j<colCount-1&&comCol[j]==0) j++;
                    else break;
                }

                if(readFromMatrix){
                    colFromTop=true;
                }
            }else if(rowFromRight){
                System.out.println("\n***Row from right**\n");
                comRow[i] = 1;
                rowFromRight=false;
                boolean readFromMatrix=false;
                while(true){
                    System.out.printf("Row: %d, col: %d\n", i, j);
                    readFromMatrix=true;
                    sol.add(matrix[i][j]);
                    if(j>0&&comCol[j]==0) j--;
                    else break;
                }

                if(readFromMatrix){
                    colFromDown=true;
                }

            }else if(colFromTop){
                System.out.println("\n***Col from top**\n");
                comCol[j] = 1;
                colFromTop=false;
                boolean readFromMatrix=false;
                while(true){
                    System.out.printf("Row: %d, col: %d\n", i, j);
                    readFromMatrix=true;
                    sol.add(matrix[i][j]);
                    if(i<rowCount-1&&comRow[i]==0) i++;
                    else break;
                }

                if(readFromMatrix){
                    rowFromRight=true;
                }

            }else if(colFromDown){
                System.out.println("\n***Col from down**\n");
                comCol[j] = 1;
                colFromDown=false;
                boolean readFromMatrix=false;
                while(true){
                    System.out.printf("Row: %d, col: %d\n", i, j);
                    readFromMatrix=true;
                    sol.add(matrix[i][j]);
                    if(i>0&&comRow[i]==0) i--;
                    else break;
                }

                if(readFromMatrix){
                    rowFromLeft=true;
                }

            }else
                break;
        }

        return sol;

    }
}
