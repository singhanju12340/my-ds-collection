package com.tekion.aec.cp.imsjobs.controller.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author anju
 * @created on 26/12/24 and 1:57 PM
 */
public class SumOfSubArrayMin {

    /**
     * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
     * Since the answer may be large, return the answer modulo 109 + 7.
     * [3,1,2,4]
     * */

    public static int sumSubarrayMins(int[] arr) {
        int result=0;
        for(int i=0;i<arr.length;i++){
            for(int j= i; j< arr.length;j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k<=j;k++){
                    min = Math.min(min, arr[k]);
                }
                result = result + min;
            }
        }
        System.out.println(result);
        return result;
    }

    // HARD
    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        // Arrays to store the previous smaller and next smaller element indices
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];




        // Monotonic stack for previous smaller
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for next smaller
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of contributions
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - prevSmaller[i];
            long rightCount = nextSmaller[i] - i;
            sum = (sum + arr[i] * leftCount * rightCount) % MOD;
        }

        return (int) sum;
    }


    public static void main(String[] args) {
        sumSubarrayMins(new int[]{3,1,2,4});

        /**
         * next min element
         * previous min
         *
         * */
    }


    /// O(n)  solution

    // find previous min element for each index else -1
    // find next min element for each index  else size of array
    // fins leftCount and rightCount
    // result = for each index get sum of, (nums[index] * leftCount * rightCount)


    public int sumSubarrayMinsMine(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        // Arrays to store the previous smaller and next smaller element indices
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, arr.length);

        // previous minim ele
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        // next mini ele

        for(int i= arr.length-1 ; i>0 ; i--){
            while(st.isEmpty() && st.peek() > arr[i]){
                st.pop();
            }
            nextSmaller[i] = st.isEmpty()? arr.length : st.peek();
            st.push(arr[i]);
        }





        // Calculate the sum of contributions
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - prevSmaller[i];
            long rightCount = nextSmaller[i] - i;
            sum = (sum + arr[i] * leftCount * rightCount) % MOD;
        }

        return (int) sum;
    }

}
