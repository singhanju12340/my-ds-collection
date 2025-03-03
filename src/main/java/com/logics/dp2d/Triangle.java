package com.logics.dp2d;

import java.util.Arrays;
import java.util.List;

/**
 * @author anju
 * @created on 03/03/25 and 3:08 PM
 */
public class Triangle {
    /***
     * Given a triangle array, return the minimum path sum from top to bottom.
     *
     * For each step, you may move to an adjacent number of the row below.
     * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     *
     */

    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] d:dp) {
            Arrays.fill(d, -1);
        }
//        return minimumTotalRec(triangle, 0,0);
        return minimumTotalMemo(triangle, 0,0, dp);

    }

    public int minimumTotalRec(List<List<Integer>> triangle, int row, int col) {
            if(row == triangle.size()-1){
                return triangle.get(row).get(col);
            }

            return triangle.get(row).get(col) + Math.min(
                    minimumTotalRec(triangle, row+1, col), // next row same element
                    minimumTotalRec(triangle, row+1, col+1) // next row next element
            );
    }

    public int minimumTotalMemo(List<List<Integer>> triangle, int row, int col, int[][]dp) {
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != -1)
            return dp[row][col];

        int res =  triangle.get(row).get(col) + Math.min(
                minimumTotalMemo(triangle, row+1, col, dp), // next row same element
                minimumTotalMemo(triangle, row+1, col+1, dp) // next row next element
        );
        dp[row][col] = res;
        return res;
    }

    public int minimumTotalBottomUp(List<List<Integer>> triangle, int row, int col) {
        int h = triangle.size();
        int[][]dp = new int[h][h];
        if(h==0) return 0;


        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }

        for(int i=0;i<triangle.get(h-1).size();i++){ // base case last row each cell path will be value of that cell
            dp[h-1][i] = triangle.get(h-1).get(i);
        }

        for(int i=h-2;i>=0;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j+1]);
            }
        }

        return dp[0][0];
    }



}
