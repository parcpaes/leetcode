package com.paes.graph.dfs;

import java.util.LinkedList;

// Is Graph Bipartite?
public class p785IsGraphBipartite {
    private static boolean color[];
    private static boolean visited[];
    public static boolean isBipartite(int[][] graph) {
        color = new boolean[graph.length];
        visited = new boolean[graph.length];
        for (int s = 0; s < graph.length; s++) {
            if(!visited[s] && !bfs(graph,s)) return false;
        }
        return true;
    }

    private static boolean bfs(int[][] graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source]=true;
        color[source]=true;
        queue.add(source);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int w: graph[vertex]){
                if(!visited[w]){
                    visited[w]=true;
                    color[w]=!color[vertex];
                    queue.add(w);
                }else if(color[w]==color[vertex]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph [][] = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
