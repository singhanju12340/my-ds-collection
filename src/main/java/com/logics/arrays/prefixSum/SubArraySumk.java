package com.logics.arrays.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 29/04/25 and 11:40 AM
 */
public class SubArraySumk {
    public int subarraySum2(int[] nums, int k) {
        // it will contain difference sum as key and its frequency as value
        // as we are calculating prefix sum, so we know all the existence of sum till current index.
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum=0;
        int result =0;
        map.put(0,1); // if current num=k. it should be taken as a single subarray

        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
           if(map.containsKey(currentSum-k)){
               result += map.get(currentSum-k);
           }
           map.put(currentSum, map.getOrDefault(currentSum,0)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySumk().subarraySum2(new int[]{1,1,1}, 2));
    }
}
