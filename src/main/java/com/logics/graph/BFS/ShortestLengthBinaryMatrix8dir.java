package com.logics.graph.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 26/03/25 and 12:21 PM
 *
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to
 * the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 */


/****
 *
 * movement is 8-directional,
 * the BFS ensures that the first time you reach the destination,
 * you've found the shortest path in terms of number of steps.
 *
 */
public class ShortestLengthBinaryMatrix8dir {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir8 = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1, -1}, {-1, 1}, {1, -1}};
        Queue<int[]> queue = new LinkedList<>();

        int[][] visited = new int[grid.length][grid[0].length];

        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;

        for(int i=0;i<grid.length;i++)
            Arrays.fill(visited[i], -1);

        queue.add(new int[]{0, 0});
        visited[0][0] = 1;


        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0;i< dir8.length;i++){
                int newx = dir8[i][0];
                int newy = dir8[i][1];

                if(newx == grid.length-1 && newy == grid.length-1){
                    result = Math.min(result, visited[current[0]][current[1]]+1 );
                }

                if(newx>=0 && newy>=0 && newx<grid.length && newy<grid.length &&  visited[newx][newy] != -1 && grid[newx][newy] == 0){
                    visited[newx][newy] = visited[current[0]][current[1]]  + 1;

                    queue.add(new int[]{newx, newy});
                }
            }
        }

        return result== Integer.MAX_VALUE ? -1: result;
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(mat));
    }

}
