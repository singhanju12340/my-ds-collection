package com.logics.monotonicStack;

import java.util.Stack;

/**
 * @author anju
 * @created on 27/12/24 and 1:29 PM
 */
public class MaximumWidthRamp {

    /**
     * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
     *
     * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
     * */

    // we need to create monotonic decreasing stack.

    public static int maxWidthRamp(int[] nums) {

        // create monotonic decreasing stack
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<nums.length ;i++){
            if(st.isEmpty() || nums[st.peek()]>nums[i])
                st.push(i);
        }
        // check for ramp width for each index from the farthest index
        int maxWidth = 0;
        for(int j=nums.length-1; j>=0; j--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[j]){
                maxWidth = Math.max(maxWidth, j-st.pop());
            }
        }
        System.out.println(maxWidth);
        return maxWidth;
    }


    public static void main(String[] args) {
        maxWidthRamp(new int[]{6,0,8,2,1,5});
    }
}
