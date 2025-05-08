package com.logics.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 03/05/25 and 9:24 PM
 */
public class CountSubIsland {
    class GNode{
        int x;
        int y;
        GNode(int x, int y){
            this.x=x;
            this.y = y;
        }
    }
    public boolean isValid=true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        int[][] visited=new int[grid1.length][grid1[0].length];
        for(int i=0;i<grid2.length;i++){

            for(int j=0;j<grid2[0].length;j++){

                if(grid2[i][j] == 1 && visited[i][j]==0){
                    dfs(grid1, grid2, i, j, visited);
                    if(isValid) // if its a subarray
                        count++;
                    isValid = true;
                }
            }
        }
        return count;

    }

    public void dfs(int[][] grid1,int[][] grid2, int x, int y, int[][] visited){

        if(x>=0 && y>=0 && x<grid2.length && y<grid2[0].length
                && grid2[x][y] == 1 && visited[x][y]==0)
        {
            if(grid1[x][y] == 0)
                isValid=false;
            visited[x][y] = 1;
            dfs(grid1, grid2, x, y+1, visited);
            dfs(grid1, grid2, x+1, y, visited);
            dfs(grid1, grid2, x, y-1, visited);
            dfs(grid1, grid2, x-1, y, visited);
        }
    }


    public static void main(String[] args) {


//        int[][] grid1 = new int[][]
//                {
//                        {1,1,1,1,0,0},
//                        {1,1,0,1,0,0},
//                        {1,0,0,1,1,1},
//                        {1,1,1,0,0,1},
//                        {1,1,1,1,1,0},
//                        {1,0,1,0,1,0},
//                        {0,1,1,1,0,1},
//                        {1,0,0,0,1,1},
//                        {1,0,0,0,1,0},
//                        {1,1,1,1,1,0}
//                };

        int[][] grid1 = new int[][]
                {
                        {1,1,1,0,0},
                        {0,0,1,1,1},
                        {0,1,0,0,0},
                        {1,0,1,1,0},
                        {0,1,0,1,0}};

        int[][] grid2 = new int[][]

                {
                        {1,1,1,0,0},
                        {0,0,1,1,1},
                        {0,1,0,0,0},
                        {1,0,1,1,0},
                        {0,1,0,1,0}
                };

//        int[][] grid2 = new int[][]
//                {
//                        {1,1,1,1,0,1},
//                        {0,0,1,0,1,0},
//                        {1,1,1,1,1,1},
//                        {0,1,1,1,1,1},
//                        {1,1,1,0,1,0},
//                        {0,1,1,1,1,1},
//                        {1,1,0,1,1,1},
//                        {1,0,0,1,0,1},
//                        {1,1,1,1,1,1},
//                        {1,0,0,1,0,0}
//                };



        System.out.println(new CountSubIsland().countSubIslands(grid1, grid2));
    }
}









