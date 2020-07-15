package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
       for(int[] edge:prerequisites){
           graph.addEdge(edge[0], edge[1]);
       }
       if(!graph.isCyclic()) return true;
       return false;

    }

    class Graph{
        int V;
        List<List<Integer>> adj;
        boolean[] visited;
        boolean[] recStack;

        public Graph(int V){
            this.V = V;
            adj = new ArrayList<>(V);
            visited = new boolean[V];
            recStack = new boolean[V];
            for(int i=0;i<V;i++){
                adj.add(i, new LinkedList<>());
            }
        }

        public void addEdge(int src, int dest){
            adj.get(src).add(dest);
        }

        public boolean isCyclic(){
            for(int v=0;v<V;v++){
                if(isCyclic(v))
                    return true;
            }
            return false;
        }

        private boolean isCyclic(int v){
            if(recStack[v])
                return true;
            if(visited[v])
                return false;
            visited[v] = true;
            recStack[v] = true;
            for(int con:adj.get(v)){
                if(isCyclic(con))
                    return true;
            }
            recStack[v] = false;
            return false;
        }
    }
}
