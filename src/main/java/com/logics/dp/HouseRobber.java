package com.logics.dp;

import java.util.Arrays;

/**
 * @author anju
 * @created on 28/02/25 and 11:17 AM
 */
public class HouseRobber {
/***
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */



    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
        int[] nums = new int[]{1,2};

        System.out.println(new HouseRobber().rob(nums));
    }
    public int rob(int[] nums) {
        return robRecc(nums,nums.length-1);

//        int[] dp = new int[nums.length+1];
//        Arrays.fill(dp, -1);
//        return robMemo(nums,nums.length-1, dp);

    }

    public int robRecc(int[] nums, int index) {
        if(index == 0)
            return nums[0];
        if(index<0)
            return 0;

        int take = robRecc(nums, index-2) + nums[index];

        int notTake = robRecc(nums, index-1) + 0;
        return Math.max(take, notTake);
    }


    public int robMemo(int[] nums, int index, int[] dp) {
        if(index == 0)
            return nums[0];
        if(index < 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];

        int take = robMemo(nums, index-2, dp) + nums[index];
        int notTake = robMemo(nums, index-1, dp) + 0;

        dp[index] = Math.max(take, notTake);

        return dp[index];

    }

    public int robTabu(int[] nums, int length) {

        int[] dp = new int[length];
        Arrays.fill(dp, -1);

        dp[0] = nums[0]; // if only one house max profit

        for(int i=1;i<length;i++){
            int take  = nums[i];
            if(i-2>=0)
                take =  dp[i-2] + take;

            int notTake =  dp[i-1] + 0;
            dp[i] = Math.max(take, notTake);
        }
        return dp[length-1];
    }



}
