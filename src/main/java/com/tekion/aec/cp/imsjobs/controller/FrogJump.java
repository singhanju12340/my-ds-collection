package com.tekion.aec.cp.imsjobs.controller;

/**
 * @author anju
 * @created on 28/06/24 and 10:53 PM
 */
public class FrogJump {
    public static int cal(int curr, int[] arr, int[] dp) {
        if(curr == 0)
            return 0;
        if(dp[curr] !=-1)
            return dp[curr];

        int r = Integer.MAX_VALUE;
        int l = Math.abs(arr[curr] - arr[curr-1])  +  cal( curr-1, arr, dp);
       if(curr >1) r = Math.abs(arr[curr] - arr[curr-2])  +  cal( curr-2, arr, dp);

        dp[curr] = Math.min(l, r);
         return dp[curr];
    }

    public static void main(String[] args) {
        int[] ar = new int[]{10, 20, 30, 10};
        int[] ar2 = new int[]{30, 10, 60, 10, 60, 50};
        int [] dp = new int[]{-1,-1,-1,-1,-1,-1};
        int res = cal( ar2.length-1, ar2, dp);
        System.out.println(res);

    }
}
