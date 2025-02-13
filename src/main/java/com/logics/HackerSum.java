package com.logics;

/**
 * @author anju
 * @created on 10/06/24 and 10:05 PM
 */
public class HackerSum {
    public static void main(String[] args) {
//        int[] num = new int[]{3,5,-2,-4,9,16};
        int[] num = new int[]{2,5,-8,-6,-7};

        int k=2;
        int res = test(num, k);
        System.out.println(res);
    }

    public static int test(int[] nums, int k){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int currentSum=0;
            int j = i;
            while(j<nums.length){
                currentSum = currentSum + nums[j];
                j = j+k;
            }
            max = Math.max(max, currentSum);
        }
        return max;
    }
}
