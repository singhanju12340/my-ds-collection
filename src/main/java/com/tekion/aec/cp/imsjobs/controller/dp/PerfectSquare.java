package com.tekion.aec.cp.imsjobs.controller.dp;

import java.util.Arrays;



/**
 * @author anju
 * @created on 05/02/25 and 3:42 PM
 */
public class PerfectSquare {
    /***
     * Given an integer n, return min of  count of perfect squares numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words,
     * it is the product of some integer with itself.
     * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *Example 1:
     *
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     * Example 2:
     *
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     */






    public int numSquaresReq(int n) {
        if(n==0) return 0;

        int res = n; // result will always be less than n
        for(int i=1;i*i<=n;i++){
            int takecurrentsquare = i*i;
            res = Math.min(res,numSquaresReq(n-takecurrentsquare)+1 );
        }
        return res;
    }

    public int numSquaresDpMemo(int n, int[] dp) {
        if(n==0) return 0;

        if(dp[n] !=-1)
            return dp[n];
        int res = n; // result will always be less than n
        for(int i=1;i*i<=n;i++){
            res = Math.min(res,numSquaresDpMemo(n-i*i, dp)+1 );
        }
        dp[n] = res;
        return res;
    }


    public int numSquaresDpTabu(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=n;i++){
            for(int j=1; j*j<=i;j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        int result = 0;
        PerfectSquare perfectSquare = new PerfectSquare();
//        perfectSquare.numSquares(12);

//        perfectSquare.numSquaresReq(5);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
//        result = perfectSquare.numSquaresDpMemo(n, dp);
        result = perfectSquare.numSquaresDpTabu(n);

        System.out.println(result);
    }



}
