package com.tekion.aec.cp.imsjobs.controller.dp2d;

import java.util.Arrays;

/**
 * @author anju
 * @created on 18/07/24 and 9:33 PM
 */
public class TriangleMinTraversal {

    /**
     * Problem statement
     * You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.
     *
     * The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.
     *
     * You can move only to the adjacent number of row below each step.
     * For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.
     *
     * For Example :
     * If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7], [8,9,6,1]] the triangle array will look like:
     *
     * 1
     * 2,3
     * 3,6,7
     * 8,9,6,10
     *
     * For the given triangle array the minimum sum path would be 1->2->3->8. Hence the answer would be 14.
     *
     * */


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};;
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        int result = findTabMain(0,0, dp, arr);
        System.out.println(result);
    }

    // bottom row any cell can be an end, only fixed point is {0,0}
    public static int findRec(int row, int col, int[][]dp, int[][] arr){

        if(row == arr.length-1){
            return arr[row][col];
        }

        int down = arr[row][col] + findRec(row+1, col, dp, arr);
        int dig = arr[row][col] + findRec(row+1, col+1, dp, arr);
        return Math.min(down, dig);
    }

    // bottom row any cell can be an end, only fixed point is {0,0}
    public static int findRecMem(int row, int col, int[][]dp, int[][] arr){

        if(dp[row][col] !=-1)
            return dp[row][col];

        if(row == arr.length-1){
            return arr[row][col];
        }

        int down = arr[row][col] + findRecMem(row+1, col, dp, arr);
        int dig = arr[row][col] + findRecMem(row+1, col+1, dp, arr);
        return dp[row][col] = Math.min(down, dig);
    }


    // tabulation is opposite of recursion, will start from last row
    public static int findTab(int row, int col, int[][]dp, int[][] arr){
        for(int i=row; i>=0 ; i--){
            for(int j=i; j>=0 ; j--){
                dp[i][j] = Math.min(arr[i][j]+dp[i+1][j], arr[i][j]+dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    public static int findTabMain(int row, int col, int[][]dp, int[][] arr){
        for(int i=0;i<arr.length;i++){
            dp[arr.length-1][i] = arr[arr.length-1][i];
        }
        findTab(arr.length-2, arr.length-2, dp, arr);
        System.out.println(dp[row][col]);
        return dp[row][col];
    }
}
