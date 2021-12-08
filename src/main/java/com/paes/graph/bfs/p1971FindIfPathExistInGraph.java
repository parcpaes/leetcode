package com.paes.graph.bfs;

import java.util.Deque;
import java.util.LinkedList;

public class p1971FindIfPathExistInGraph {
    public static class Graph{
        private int n;
        private LinkedList<Integer> adj[];
        public Graph(int n){
            adj = new LinkedList[n];
            this.n = n;
            for(int i=0;i<n;i++)
                adj[i]=new LinkedList<>();
        }

        public void addEdge(int v,int w){
            adj[v].add(w);
            adj[w].add(v);
        }
        public Iterable<Integer> adj(int v){
            return adj[v];
        }
        public int V(){return n;}
    }
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return false;
        if(edges.length==1) return true;
        Graph graph = new Graph(n);
        for(int edge[]: edges){
            graph.addEdge(edge[0],edge[1]);
        }
        return isPath(start,end,graph);
    }

    private static boolean isPath(int start, int end,Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.V()];
        boolean found=false;
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty() && (!found)){
            int vertex = queue.poll();
            for(int w : graph.adj(vertex)){
                if(w==end) found=true;
                if(!visited[w]){
                    visited[w]=true;
                    queue.add(w);
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int edges[][] = {{0,1},{1,2},{2,0}};
        System.out.println(validPath(3, edges,0,2));
    }
}
