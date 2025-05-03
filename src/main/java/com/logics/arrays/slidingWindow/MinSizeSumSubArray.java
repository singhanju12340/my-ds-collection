package com.logics.arrays.slidingWindow;

/**
 * @author anju
 * @created on 26/04/25 and 10:44 PM
 */
public class MinSizeSumSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        int currSum=0;
        while(i<nums.length){
            currSum+=nums[i++];
            if(currSum>=target){
                while(currSum>=target){
                    currSum-=nums[j++];
                }
                min = Math.min(min, i-(j-1));
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinSizeSumSubArray maxAvgSum1 = new MinSizeSumSubArray();
//        System.out.println(maxAvgSum1.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
//        System.out.println(maxAvgSum1.findMaxAverage(new int[]{5,5,5,5}, 2));
        System.out.println(maxAvgSum1.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));


    }
}
