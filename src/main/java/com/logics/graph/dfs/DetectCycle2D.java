package com.logics.graph.dfs;

import java.util.Arrays;

/**
 * @author anju
 * @created on 03/05/25 and 1:18 PM
 */
public class DetectCycle2D {
    //https://leetcode.com/problems/detect-cycles-in-2d-grid/

    public boolean containsCycle(char[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        for(int[] v:visited)
        {
            Arrays.fill(v, -1);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==-1)
                    if(check(grid, visited, i, j, -1, -1, 0) == true)
                        return true;
            }
        }
        return false;
    }

    public boolean check(char[][] grid, int[][] visited, int x, int y, int px, int py, int count) {
        if(x >= grid.length || x < 0 || y >= grid[0].length || y<0){
            return false;
        }

        if(px>=0 && py>=0 && (grid[x][y] != grid[px][py])){
            return false;
        }

        if(visited[x][y] == 1 && count>=4){
            return true;
        }

        if(visited[x][y] == 1 && count < 4){
            return false;
        }


        int[] dirx = new int[]{1,-1,0,0};
        int[] diry = new int[]{0,0,1,-1};

        visited[x][y] = 1;

        for(int i=0;i<4;i++){
            int newx = x+dirx[i];
            int newy = y+diry[i];

            if(newx==px && newy==py){
                continue;
            }
            if(true == check(grid, visited, newx, newy, x, y, count+1))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
//        char[][] input = new char[][]{{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
//        char[][] input = new char[][]{{'b'},{'b'}};
//        char[][] input = new char[][]{{'b','a','c'},{'c','a','c'},{'d','d','c'},{'b','c','c'}};
        char[][] input = new char[][]{{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};

        System.out.println(new DetectCycle2D().containsCycle(input));
    }
}
