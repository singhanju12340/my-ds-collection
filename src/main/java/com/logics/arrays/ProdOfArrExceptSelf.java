package com.logics.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 12/09/24 and 11:40 AM
 */
public class ProdOfArrExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0]=1;
        int[] suffix = new int[nums.length];
        suffix[nums.length-1]=1;

        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]* nums[i-1];
            suffix[nums.length-1-i] = suffix[nums.length-i] * nums[nums.length-i];
        }

        for(int i=0;i<nums.length;i++){
            prefix[i] = prefix[i]*suffix[i];
        }


        return prefix;
    }

    public static void main(String[] args) {
        int[] in  = new int[]{1,2,3,4};
        productExceptSelf(in);
    }
}
