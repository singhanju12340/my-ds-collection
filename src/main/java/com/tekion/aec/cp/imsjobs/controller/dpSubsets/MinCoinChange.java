package com.tekion.aec.cp.imsjobs.controller.dpSubsets;

import java.util.Arrays;

/**
 * @author anju
 * @created on 04/06/24 and 10:28 PM
 */
public class MinCoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] minCoinForEachAmount = new int[amount+1];
        minCoinForEachAmount[0] = 0;
        for(int i=1;i<= amount ;i++){
            int currentSum = i;
            int minForCurrentSum = Integer.MAX_VALUE;
            for(int j = 0; j<coins.length ; j++){
                int diff = currentSum-coins[j];
                if(diff > 0){
//                    System.out.println(diff);

                    minForCurrentSum = Math.min(minForCurrentSum, 1+ minCoinForEachAmount[diff]);
                }else if(diff == 0){
//                    System.out.println(diff);
                    minForCurrentSum = Math.min(minForCurrentSum,1);
                }
            }
            // System.out.println(minForCurrentSum);

//             if(minForCurrentSum == (Integer.MAX_VALUE+1)){
//             minCoinForEachAmount[i] = -1;
//             }else{
//                  minCoinForEachAmount[i] = minForCurrentSum;
//             }
            minCoinForEachAmount[i] = minForCurrentSum;


        }

        // for(int i=0;i<minCoinForEachAmount.length;i++){
        //     System.out.println(minCoinForEachAmount[i]);
        // }
        if(minCoinForEachAmount[amount] == (Integer.MAX_VALUE+1) ||  minCoinForEachAmount[amount] == (Integer.MAX_VALUE))
            return -1;

        return minCoinForEachAmount[amount];


    }

    public static int findMinRec(int index, int[] coins, int amount){
        if(index==0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }else{
                return (int) 1e9;
            }
        }

        int notTake = 0 + findMinRec(index-1, coins, amount);
        int take = (int) 1e9;
        if(amount >= coins[index]){
            take = 1 + findMinRec(index, coins, amount-coins[index]);
        }
        return Math.min(notTake, take);
    }

    public static void main(String[] args) {
//        coinChange(new int[]{186,419,83,408}, 6249);

        int[] coins = new int[]{2,5,10,1};
        int amount = 27;

//        int res = findMinRec(coins.length-1, coins, amount);
        int res = runByDb(coins.length-1, coins, amount);
        System.out.println( ( res >= (int) 1e9 )? -1 :  res);
    }

    public static int runByDb(int index, int[] coins, int amount){
        int[][] dp = new int[coins.length][amount+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int res = findMinRecDp(index, coins, amount, dp);
         return (res >= (int) 1e9 )? -1 :  res;
    }


    public static int findMinRecDp(int index, int[] coins, int amount, int[][] dp){
                if(index==0) {
                    if (amount % coins[0] == 0) {
                        return amount / coins[0];
                    } else {
                        return (int) 1e9;
                    }
                }

        if(dp[index][amount] !=-1)
            return dp[index][amount];

        int notTake = 0 + findMinRecDp(index-1,coins, amount, dp);
        int take = (int) 1e9;
        if(amount >= coins[index]){
            take = 1 + findMinRecDp(index,coins, amount-coins[index], dp);
        }
        dp[index][amount] = Math.min(notTake, take);
        return dp[index][amount];
    }
}
