package com.logics.dp2d;

import java.util.Arrays;

/**
 * @author anju
 * @created on 09/04/25 and 5:03 PM
 */
public class PintHouse {
    /**
     * There are a row of N houses, each house can be painted with one of the three colors: red, blue or green.
     *
     * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
     *
     * The cost of painting each house with a certain color is represented by a N x 3 cost matrix A.
     *
     * For example, A[0][0] is the cost of painting house 0 with color red; A[1][2] is the cost of painting house 1 with color green, and so on.
     *
     * Find the minimum total cost to paint all houses.
     *
     * Input 1:
     *  A = [  [1, 2, 3]
     *         [10, 11, 12]
     *      ]
     *
     * Example Output
     * Output 1:
     *  12
     *
     *  Example Explanation
     * Explanation 1:
     *
     *  Paint house 1 with red and house 2 with green i.e A[0][0] + A[1][1] = 1 + 11 = 12
     *
     */

    public int solve(int[][] A) {
//        return paintHouseRec(A, 0, -1);
        int[][] dp = new int[A.length][4];
        for (int[] entry:dp) {
            Arrays.fill(entry, -1);
        }
        return paintHouseMemo(A, 0, 3, dp);
    }

    public static int paintHouseRec(int[][] A, int houseIndex, int colorIndex){
        if(houseIndex >= A.length){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(colorIndex!=i){
                int minCurrent = A[houseIndex][i] + paintHouseRec(A, houseIndex+1, i);
                min = Math.min(min, minCurrent);
            }
        }

        return min;
    }


    public static int paintHouseMemo(int[][] A, int houseIndex, int colorIndex, int[][]dp){
        if(houseIndex >= A.length){
            return 0;
        }

        if(dp[houseIndex][colorIndex] !=-1)
            return dp[houseIndex][colorIndex];


        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(colorIndex!=i){
                int minCurrent = A[houseIndex][i] + paintHouseRec(A, houseIndex+1, i);
                min = Math.min(min, minCurrent);
            }
        }
        dp[houseIndex][colorIndex] = min;
        return min;
    }

    public static void main(String[] args) {

    }
}
