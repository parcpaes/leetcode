package com.paes.backtracking;

public class p1219PathWithMaxGold {
    public final int dx[] = {1,0,-1,0};
    public final int dy[] = {0,1,0,-1};
    public int getMaximumGold(int[][] grid) {
        int visited=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    return floodFill(i,j,grid,visited);
                }
            }
        }
        return 0;
    }

    public int floodFill(int x,int y,int grid[][],int visited){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length) return 0;
        if(grid[x][y]==0) return 0;
        if(grid[x][y]==-1) return 0;
        int gold = grid[x][y];
        grid[x][y]=visited;
        int max=0;
        for(int i=0;i<4;i++){
            gold += floodFill(x+dx[i],y+dy[i],grid,visited);
        }
        return max;
    }

    public static void main(String[] args) {
        int grid[][]= {{0,6,0},{5,8,7},{0,9,0}};
    }
}
