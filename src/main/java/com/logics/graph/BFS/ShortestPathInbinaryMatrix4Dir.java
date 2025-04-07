package com.logics.graph.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 26/03/25 and 2:07 PM
 */
public class ShortestPathInbinaryMatrix4Dir {

    //Dijkstra without priority queue, because each path is of fix lenght, if it is va=riable priority queue will be used
    // ques: ShortestPathInValueMatrix4Dir


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
