package com.tekion.aec.cp.imsjobs.controller.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author anju
 * @created on 24/12/24 and 11:26 PM
 */
public class NextGreaterEle2 {
    /****
     * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
     *
     * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
     * @param nums
     * @return
     */


    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize result with -1
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Traverse the array twice to simulate circularity
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            // While the stack is not empty and the current element is greater than the element at stack's top index
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int topIndex = stack.pop();
                result[topIndex] = nums[currentIndex];
            }
            // Only push the index of the first pass to avoid duplicates
            if (i < n) {
                stack.push(currentIndex);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,8,4,1,2};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [2, -1, 2]

    }
}
