package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<List<Integer>> adj;
    private boolean[] isVisited;
    private boolean[] recStack;

    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);
        isVisited = new boolean[V];
        recStack = new boolean[V];
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public boolean isCyclic(){
        for(int v=0;v<adj.size();v++){
            if(isCyclic(v, adj)) return true;
        }

        return false;
    }

    private boolean isCyclic(int v, List<List<Integer>> adj){
        if(recStack[v])
            return true;
        //short circuit if already visited
        if(isVisited[v])
            return false;
        isVisited[v] = true;
        recStack[v] = true;
        for(int a:adj.get(v)){
            if(isCyclic(a, adj)) return true;
        }
        recStack[v] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
