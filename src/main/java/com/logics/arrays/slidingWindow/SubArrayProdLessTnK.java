package com.logics.arrays.slidingWindow;

public class SubArrayProdLessTnK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int target = 1;
        int count=0;
        int windowStart =0;
        int i=0;
        while(i<nums.length && windowStart<=i){
            target = target * nums[i] ;
            if(target<k){
                count+=2;
            }else {
                target = target/nums[windowStart];
                if(target<k){
                    count+=2;
                }
                windowStart++;
            }
            i++;
        }

        System.out.print(windowStart);
        return count + Math.max(0,(i-windowStart-2));
    }

    public static void main(String[] args) {
        System.out.println(new SubArrayProdLessTnK().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
