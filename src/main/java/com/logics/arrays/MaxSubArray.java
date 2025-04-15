package com.logics.arrays;

/**
 * @author anju
 * @created on 09/04/25 and 6:09 PM
 */
public class MaxSubArray {

    /**
     *
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     * @param nums
     * @return
     */

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length ;i++){
            sum = sum + nums[i];
            max = Math.max(sum, max);
            if(sum<0) sum=0;
        }
        return max;

    }

    public static void main(String[] args) {
        maxSubArray(new int[]{5,4,-1,7,8});
    }


}
