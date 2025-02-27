package com.logics.arrays.twoPointer;

import java.util.Stack;

/**
 * @author anju
 * @created on 31/12/24 and 11:58 AM
 */
public class WaterTrap2Pointer {
/***
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */


    /**
     * Algorithm:
     * Initialize two pointers:
     * left = 0 and right = n - 1.
     * Initialize two variables:
     * maxLeft = 0 and maxRight = 0.
     * Traverse the array while left <= right:
     * If height[left] <= height[right]:
     * If height[left] >= maxLeft, update maxLeft.
     * Otherwise, add maxLeft - height[left] to the water.
     * Move left pointer.
     * Else:
     * If height[right] >= maxRight, update maxRight.
     * Otherwise, add maxRight - height[right] to the water.
     * Move right pointer.
     * Return the total water trapped.
     * **/

    public static int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        // find left max
        // find right max
        // find  water by store at i =  max(0, 1 * (min(lMax[i], Rmax[i]) - heigth[i])). ignore -ve vol calculation by taking max from calculation and 0.
        // cal to find width = min(lMax[i], Rmax[i]) - heigth[i]
        //

        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length-1;

        while(left<=right){
            if(height[left] <= height[right]){
                if(leftMax <= height[left]){
                    leftMax = height[left];
                }else{
                    totalWater = totalWater + (leftMax - height[left]);
                }
                left++;

            }else{
                //height[left] >= height[right]
                if(rightMax <= height[right]){
                    rightMax = height[right];
                }else{
                    totalWater = totalWater + (rightMax - height[right]);
                }
                right--;
            }

        }
        System.out.println(totalWater);
        return totalWater;
    }

    public static void main(String[] args) {
        trap(new int[]{4,2,0,3,2,5});
    }
}
