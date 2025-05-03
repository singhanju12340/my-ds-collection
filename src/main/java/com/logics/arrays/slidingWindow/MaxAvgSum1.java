package com.logics.arrays.slidingWindow;

/**
 * @author anju
 * @created on 26/04/25 and 10:44 PM
 */
public class MaxAvgSum1 {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length<k)
            return 0.0;

        double currentSum=0.0;

        for(int j=0;j<k;j++){
            currentSum+=nums[j];
        }
        double max = currentSum/k;

        for(int i=k;i<nums.length;i++){
            currentSum -= nums[i-k];
            currentSum = currentSum+nums[i];
            max = Math.max(max, currentSum/k);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxAvgSum1 maxAvgSum1 = new MaxAvgSum1();
//        System.out.println(maxAvgSum1.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
//        System.out.println(maxAvgSum1.findMaxAverage(new int[]{5,5,5,5}, 2));
        System.out.println(maxAvgSum1.findMaxAverage(new int[]{0,1,1,3,3}, 2));


    }
}
