package com.leetcode.medium;


/**
 * 289. Game of Life
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * Example:
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length<1||board[0].length<1) return;
        int[][] copy = makeACopy(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=copy[i][j]==1?calcStateForALiveCell(copy, i, j):calcStateForADeadCell(copy, i, j);
            }
        }
    }

    private int[][] makeACopy(int[][] board){
        int[][] copy = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                copy[i][j]=board[i][j];
            }
        }
        return copy;
    }

    private int calcStateForALiveCell(int[][] boardCopy, int i, int j){
        int liveNeighbors = getLiveNeighbors(boardCopy, i, j);
        if(liveNeighbors<2) return 0;
        if(liveNeighbors>3) return 0;
        return 1;
    }

    private int calcStateForADeadCell(int[][] boardCopy, int i, int j){
        int liveNeighbors = getLiveNeighbors(boardCopy, i, j);
        if(liveNeighbors==3) return 1;
        return 0;
    }

    private int getLiveNeighbors(int[][] boardCopy, int i, int j){
        int liveNeighbors =0;
        boolean fr=false, fc=false, lr=false, lc = false;
        if(i==0) fr=true;
        if(j==0) fc=true;
        if(i==boardCopy.length-1) lr=true;
        if(j==boardCopy[0].length-1) lc=true;
        if(!fr&&!fc) liveNeighbors = liveNeighbors + boardCopy[i-1][j-1];
        if(!fr)      liveNeighbors = liveNeighbors + boardCopy[i-1][j];
        if(!fr&&!lc) liveNeighbors = liveNeighbors + boardCopy[i-1][j+1];
        if(!fc)      liveNeighbors = liveNeighbors + boardCopy[i][j-1];
        if(!lc)      liveNeighbors = liveNeighbors + boardCopy[i][j+1];
        if(!lr&&!fc) liveNeighbors = liveNeighbors + boardCopy[i+1][j-1];
        if(!lr)      liveNeighbors = liveNeighbors + boardCopy[i+1][j];
        if(!lr&&!lc) liveNeighbors = liveNeighbors + boardCopy[i+1][j+1];
        return liveNeighbors;
    }
}
