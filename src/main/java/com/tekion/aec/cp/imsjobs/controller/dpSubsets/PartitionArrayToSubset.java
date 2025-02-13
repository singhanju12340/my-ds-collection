package com.tekion.aec.cp.imsjobs.controller.dpSubsets;

import java.util.Arrays;

/**
 * @author anju
 * @created on 19/07/24 and 5:45 PM
 */
public class PartitionArrayToSubset {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int sum = Arrays.stream(arr).sum();
        if(sum%2!=0) return;
        int target = sum/2;

        int[][] dp = new int[arr.length][target+1];
        for(int i=0;i< dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        boolean res = findRecMemorisation(arr,arr.length-1, target, dp);
        System.out.println(res);
    }

    static boolean findRecMemorisation(int[] arr, int index, int target, int[][] dp){
        if(target==0){
            return true;
        }
        if(index == 0)
        {
            return (target == arr[0]);
        }
        if(dp[index][target] != -1)
            return dp[index][target] == 0 ? false : true;

        boolean include = false;
        if(target-arr[index] >= 0)
         include = findRecMemorisation(arr, index-1, target-arr[index], dp);

        boolean nInclude = findRecMemorisation(arr, index-1, target, dp);
        dp[index][target] = (nInclude || include) ? 1 : 0;
        return include|| nInclude;
    }

    static boolean findTabulation(int[] arr, int index, int target, boolean[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= target)
            dp[0][arr[0]] = true;


        boolean include = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (target - arr[index] >= 0)
                    include = dp[index - 1][target - arr[index]]; //findRecMemorisation(arr, index-1, target-arr[index], dp);

                boolean nInclude = dp[index - 1][target];//findRecMemorisation(arr, index-1, target, dp);
                dp[index][target] = (nInclude || include);
                return include || nInclude;
            }
        }
        return dp[arr.length-1][target];
    }
}
