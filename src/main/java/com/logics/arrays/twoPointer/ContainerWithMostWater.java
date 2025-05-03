package com.logics.arrays.twoPointer;

/**
 * @author anju
 * @created on 21/04/25 and 10:18 PM
 */
public class ContainerWithMostWater {
    //https://leetcode.com/problems/container-with-most-water/

    public static int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int max = 0;
        while(left < right){
            max = Math.max(max, (Math.min(height[right], height[left])* (right-left)));
            if(height[right]>height[left]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
