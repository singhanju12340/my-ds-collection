package com.tekion.aec.cp.imsjobs.controller.monotonicStack;

import java.util.Stack;

/**
 * @author anju
 * @created on 29/11/24 and 5:26 PM
 */
public class MaximumSubArrayMinProduct {
    /**
     * The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.
     *
     * For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
     * Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums. Since the answer may be large, return it modulo 109 + 7.
     *
     * Note that the min-product should be maximized before performing the modulo operation. Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.
     *
     * A subarray is a contiguous part of an array.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,2]
     * Output: 14
     * Explanation: The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
     * 2 * (2+3+2) = 2 * 7 = 14.
     * Example 2:
     *
     * Input: nums = [2,3,3,1,2]
     * Output: 18
     * Explanation: The maximum min-product is achieved with the subarray [3,3] (minimum value is 3).
     * 3 * (3+3) = 3 * 6 = 18.
    **/

    public static int maxSumMinProduct2(int[] nums) {


        /****
         * will not work for testcase, where number if out of Integer range
         *
         */

        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            int currSum = 0;
            for(int j = i; j<nums.length;j++){
                min = Math.min(min, nums[j]);
                currSum +=nums[j];
                max = Math.max(max, (currSum*min));
            }
            max = Math.max(max, (currSum*min));
        }
        System.out.println(max);
        return max;
    }

    //https://www.geeksforgeeks.org/print-all-possible-ways-to-convert-one-string-into-another-string-edit-distance/#
    public static int maxSumMinProductMonotonicStack(int[] nums) {
        long max = Integer.MIN_VALUE;
        long mod = 1000000000+7;
        Stack<Integer> stack = new Stack<>();
        long[] prefix = new long[nums.length];
        int n = nums.length;
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }

        long res = nums[0]*nums[0];

        for(int i=0;i<nums.length;i++){
//            long currMax = Integer.MIN_VALUE;
           while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
               int stackTopIndex = stack.pop();
               long currMax=0;
               if(stack.isEmpty()){
                   currMax = nums[stackTopIndex] * prefix[i-1];
               }else{
                   currMax = nums[stackTopIndex] * (prefix[i-1]-prefix[stack.peek()]);
               }
               res = Math.max(res, currMax);
           }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int ri = stack.pop();
            long currres=0;
            if(stack.isEmpty()){
                currres = nums[ri] * prefix[n-1];
            }else{
                currres = nums[ri] * (prefix[n-1]-prefix[stack.peek()]);
            }
            res = Math.max(res, currres);
        }


        System.out.println(res);
        return (int)(res%mod);
    }


    public static void main(String[] args) {
//        maxSumMinProductMonotonicStack(new int[]{1,2,3,2});
//        maxSumMinProduct(new int[]{3,1,5,6,4,2});
        maxSumMinProduct(new int[]{1,2,3,2});

    }

    public static int maxSumMinProduct(int[] nums) {
        Stack<Integer> st = new Stack<>();
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        long max = nums[0] * nums[0];

        for(int i=1;i<nums.length;i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        for(int i=0;i<nums.length;i++){

            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){

                long currMax = Integer.MIN_VALUE;
                int currStackTop = st.pop();

                if(st.isEmpty()){
                    currMax = nums[currStackTop] * prefixSum[i-1];
                }else
                    currMax = nums[currStackTop] * (prefixSum[i-1]-prefixSum[st.peek()]);

                max = Math.max(max, currMax);
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            long currMax = Integer.MIN_VALUE;
            int currTop = st.pop();
            if(st.isEmpty()){
                currMax = nums[currTop] * prefixSum[nums.length-1];
            }else{
                currMax = nums[currTop] * (prefixSum[nums.length-1] - prefixSum[st.peek()]);
            }
            max = Math.max(max, currMax);
        }


        System.out.println(max);
        return (int) (max % 1000000000+7);
    }


}
