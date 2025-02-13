package com.tekion.aec.cp.imsjobs.controller.dpSubsets;

import java.util.Arrays;

/**
 * @author anju
 * @created on 22/07/24 and 7:49 PM
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
