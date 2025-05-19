package com.logics.arrays.slidingWindow;

import java.util.Arrays;

public class FreqOfMostFreElem {
    public int maxFrequency(int[] nums, int k1) {
        Arrays.sort(nums);

        int max = 0;

        for(int right = nums.length-1;right>=0;right--){
            int left = right-1;
            int current = 1;
            int k = k1;
            while(k>0 && left>=0 && (nums[right]-nums[left]) <= k){
                k=k-(nums[right]-nums[left]);
                current=current+1;
                System.out.println("current : "+ current);
                left--;
            }
            System.out.println("current out: " + current);
            max = Math.max(max, current);
        }

        return max;
    }

    public int maxFrequency2(int[] nums, int k) {
        int maxFrequency = 0; // Initialize the maximum frequency
        long currentSum = 0; // Initialize the current sum of the subarray elements

        Arrays.sort(nums); // Sort the array in ascending order

        for (int left = 0, right = 0; right < nums.length; ++right) {
            currentSum += nums[right]; // Include the current element in the subarray sum

            // Check if the current subarray violates the condition (sum + k < nums[right] * length)
            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left]; // Adjust the subarray sum by removing the leftmost element
                left++; // Move the left pointer to the right
            }

            // Update the maximum frequency based on the current subarray length
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }

    public int maxFrequency3(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int left=0;
        long currentsum=0;
        for(int right = 0; right<nums.length; right++){

            currentsum +=nums[right];

            while((long) nums[right] * (right-left+1) > currentsum+k){
                currentsum -=nums[left];
                left++;
            }
            max = Math.max(max, (right-left+1));
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new FreqOfMostFreElem().maxFrequency(new int[]{1,2,4}, 5));


//        System.out.println(new FreqOfMostFreElem().maxFrequency(new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966},
//                3056));
        System.out.println(new FreqOfMostFreElem().maxFrequency3(new int[]{3,9,6}, 2));
//        System.out.println(new FreqOfMostFreElem().maxFrequency(new int[]{1,2,3}, 3));
    }
}
