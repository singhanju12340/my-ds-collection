package com.logics.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 03/03/25 and 3:59 PM
 */
public class NumberOfIsland {
/***
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

class GNode {
    int row;
    int col;

    GNode(int i, int j) {
        this.row = i;
        this.col = j;
    }
}

public int numIslands(char[][] grid) {
    int count = 0;

    for(int i=0;i<grid.length;i++){
        for (int j=0;j<grid[0].length;j++){
            if(grid[i][j] == '1'){
                dfs(grid, i, j);
                count++;
            }
        }
    }

    System.out.println(count);
    return count;

}


    public void dfs(char[][] grid, int row, int col) {
        if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]=='1'){
            grid[row][col] = '$';
            dfs(grid, row+1, col);
            dfs(grid, row, col+1);
            dfs(grid, row, col-1);
            dfs(grid, row-1, col);
        }
    }

    public static void main(String[] args) {
    char[][] input = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
    };
//        new NumberOfIsland().numIslands(input);
        new NumberOfIsland().numIslandsBfs(input);

    }


    public int numIslandsBfs(char[][] grid) {
        int count = 0;
        Queue<GNode> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    queue.add(new GNode(i, j));
                    bfs(grid,queue);
                    count++;
                }
            }
        }

        System.out.println(count);
        return count;
    }

    public void bfs(char[][] grid, Queue<GNode> queue) {
        while(!queue.isEmpty()){
            GNode code = queue.poll();
            int[] dirx = new int[]{-1,0,0,1};
            int[] diry = new int[]{0,-1,1,0};

            for(int i=0; i<4;i++){
                int newRow = code.row + dirx[i];
                int newCol = code.col + diry[i];
                if (newRow >= 0 && newCol >= 0
                        && newRow < grid.length && newCol < grid[0].length
                        && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';
                    queue.add(new GNode(newRow, newCol));
                }
            }
        }
    }
}
