package com.logics.dpSubsets;

import java.util.Arrays;

/**
 * @author anju
 * @created on 22/07/24 and 7:49 PM
 */

/**
 *
 * You are given an array of integer `stones` where `stones[i]` is the weight of the `ith` stone.
 *
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights `x` and `y` with `x <= y`. The result of this smash is:
 *
 * - If `x == y`, both stones are destroyed, and
 * - If `x != y`, the stone of weight `x`is destroyed, and the stone of weight `y` has new weight `y - x`.
 *
 * At the end of the game, there is **at most one stone left.
 *
 * Return *the smallest possible weight of the left stone*. If there are no stones left, return `0`.
 */
public class PartitionSetWithSumDifferenceisMin {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int sum = Arrays.stream(arr).sum();
        if(sum%2!=0) return;
        int target = sum/2;

        int[][] dp = new int[arr.length][target+1];
        for(int i=0;i< dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
//        boolean res = findRecMemorisation(arr,arr.length-1, target, dp);
//        System.out.println(res);
    }
}
