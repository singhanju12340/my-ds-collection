package com.logics.dp2d;

/**
 * @author anju
 * @created on 13/02/25 and 1:22 PM
 */
public class MiniPathSum {

    /***
     *
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     */

    public int minPathSum(int[][] grid) {
//      return minPathRec(grid, 0,0);

        Integer[][] dp = new Integer[grid.length][grid[0].length];
//        return minPathRecMemorisation(grid, 0,0,dp);

        return minPathSumTabularDp(grid);
    }

    public int minPathRec(int[][] grid, int x, int y) {

        if(x == grid.length-1 && y == grid[0].length-1){ // if path reaches to destination, return destination path value
            return grid[x][y];
        }
        int rightMax = Integer.MAX_VALUE;
        int downMax = Integer.MAX_VALUE;

        if(x+1 < grid.length){
            rightMax =  minPathRec(grid, x+1, y);
        }

        if(y+1 < grid[0].length){
            downMax =  minPathRec(grid, x, y+1);
        }

        return grid[x][y] + Math.min(rightMax, downMax);
    }


    public int minPathRecMemorisation(int[][] grid, int x, int y, Integer[][]dp) {

        if(x == grid.length-1 && y == grid[0].length-1){ // if path reaches to destination, return destination path value
            return grid[x][y];
        }
        if(dp[x][y] != null)
            return dp[x][y];

        int rightMax = Integer.MAX_VALUE;
        int downMax = Integer.MAX_VALUE;

        if(x+1 < grid.length){
            rightMax =  minPathRecMemorisation(grid, x+1, y, dp);
        }

        if(y+1 < grid[0].length){
            downMax =  minPathRecMemorisation(grid, x, y+1,dp);
        }
        dp[x][y] = grid[x][y] + Math.min(rightMax, downMax);
        return grid[x][y] + Math.min(rightMax, downMax);
    }

    public int minPathSumTabularDp(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[grid.length][grid[0].length];

        // set base condition
        dp[0][0] = grid[0][0];


        // set base for down traversal, first col
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        // set base for right traversal first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        MiniPathSum solution = new MiniPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Minimum Path Sum: " + solution.minPathSum(grid));// Expected output: 7
    }
}
