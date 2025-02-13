package com.logics.dp2d;

import java.util.Arrays;

/**
 * @author anju
 * @created on 18/07/24 and 1:57 PM
 */
public class GridAllPath {

    public static int fun(int row, int col, int[][]dp){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(dp[row][col] !=-1){
            return dp[row][col];
        }

        int up = fun(row-1, col, dp);
        int left = fun(row, col-1, dp);


        printDp(dp);
        return dp[row][col] = up + left;
    }

    public static void printDp(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[][] dp = new int[3][3];
        for(int i =0;i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
         fun(2, 2, dp );
        System.out.println(dp[2][2]);
    }
}
