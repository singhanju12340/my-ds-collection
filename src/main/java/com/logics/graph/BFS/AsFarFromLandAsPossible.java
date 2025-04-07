package com.logics.graph.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 25/03/25 and 4:15 PM
 *
 *
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 *
 *
 * The Water Cell Maximum Distance problem is an optimization problem
 * that finds the water cell farthest from any land cell (using Manhattan distance),
 * typically solved by performing multi-source BFS starting from all land cells.
 */
public class AsFarFromLandAsPossible {

    public static int maxDistance(int[][] grid) {
        int result = Integer.MIN_VALUE;
        Queue<int[]> queue = new LinkedList<>();

        int[][] resultMat = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            Arrays.fill(resultMat[i], -1);
        }

        // start finding distance from all land to all water positions
        for(int i=0;i<grid.length;i++){
            for (int j=0; j<grid[0].length;j++){
                if(grid[i][j] == 1)
                {
                    resultMat[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[] dirx = new int[]{1,-1,0,0};
        int[] diry = new int[]{0, 0, 1, -1};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0;i<4;i++){
                int newx = dirx[i] + current[0];
                int newy = diry[i] + current[1];

                if(newx<grid.length && newy<grid.length && newx>=0 && newy>=0 && resultMat[newx][newy]==-1){
                    resultMat[newx][newy] = resultMat[current[0]][current[1]] + 1;
                    result = Math.max(result, resultMat[newx][newy] );
                    queue.add(new int[]{newx,newy});
                }

            }
        }
        return result== Integer.MIN_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(mat));
    }


}
