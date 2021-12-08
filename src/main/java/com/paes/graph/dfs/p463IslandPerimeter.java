package com.paes.graph.dfs;

import java.util.Arrays;

public class p463IslandPerimeter {
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1, 0,-1};
    public static int islandPerimeter(int[][] grid) {
        if(grid.length==1 && grid[0].length==1)return 4;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return floodFill(i,j,grid,1,2);
                }
            }
        }
        return 0;
    }
    public static int floodFill(int x,int y,int[][] grid,int land,int visited){
        if(isBounded(x,y,grid))return 0;
        if(grid[x][y]!=land) return 0;
        if(grid[x][y]==visited) return 0;
        grid[x][y] = visited;
        int ans=4;
        for(int i=0;i<4;i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            ans += floodFill(x+dx[i],y+dy[i],grid,land,visited);
            if(!isBounded(nextX,nextY,grid) && grid[nextX][nextY]!=0){
                ans--;
            }
        }
        return ans;
    }

    public static boolean isBounded(int x,int y,int[][] grid){
        return (x<0 || y<0 || x>=grid.length || y>= grid[0].length);
    }
    public static void main(String[] args) {
        int[][] grid ={
                {0,0,0,0,0},
                {0,0,1,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0}
        };
        int ans = islandPerimeter(grid);
        System.out.println(ans);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

