package com.logics.monotonicStack;

import java.util.Stack;

/**
 * @author anju
 * @created on 25/11/24 and 3:51 PM
 */
public class NextGreaterEle {

    /**
     * Given a  integer array nums  return the next greater number for every element in nums.
     *
     * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
     *
     * ex: [4,1,2]
     *
     * */

    public static void main(String[] args) {
        int[] input = new int[]{4,1,2};
        int[] result = nextGreatEle(input);
        System.out.println(result);
    }

    public static int[] nextGreatEle(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        for(int i = nums.length-1; i>=0; i--){
            while (!st.isEmpty() && st.peek()< nums[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return result;
    }
}
