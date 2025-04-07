package com.logics.graph.BFS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 25/03/25 and 3:08 PM
 */
public class Matrix01 {
/***
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two cells sharing a common edge is 1.
 */

    public int[][] updateMatrix(int[][] mat) {
        Queue<Position> queue = new LinkedList<>();
        int[][] result = new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            Arrays.fill(result[i], -1);
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.add(new Position(i,j));

                }
            }
        }

        int[] dirx = new int[]{1,-1,0,0};
        int[] diry = new int[]{0, 0, 1, -1};


        while(!queue.isEmpty()){
            Position current = queue.poll();

            for(int i=0;i<4;i++){
                int newx = dirx[i];
                int newy = diry[i];

                if(newx<mat.length && newy<mat.length && newx>=0 && newy>=0 && result[newx][newy]==-1){
                        result[newx][newy] = result[current.x][current.y] + 1;
                        queue.add(new Position(newx, newy));
                }

            }
        }


        return result;
    }

    public static void main(String[] args) {

    }

}
