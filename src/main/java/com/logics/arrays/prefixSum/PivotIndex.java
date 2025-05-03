package com.logics.arrays.prefixSum;

import java.util.Arrays;

/**
 * @author anju
 * @created on 21/04/25 and 12:29 PM
 */
public class PivotIndex {
    /*
    https://leetcode.com/problems/find-pivot-index/submissions/1613248723/
     */

    public static int pivotIndex(int[] nums) {
        int j=nums.length;
        if(nums.length ==0)
            return -1;

        int leftSum=0;
        int rightSum = Arrays.stream(nums).sum();

        for(int i=0;i<j;i++){
            rightSum -= nums[i];
            if(leftSum == rightSum)
                return i;
            leftSum +=nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }
}
