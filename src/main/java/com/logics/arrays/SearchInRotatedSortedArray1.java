package com.logics.arrays;

/**
 * @author anju
 * @created on 24/02/25 and 2:49 PM
 */
public class SearchInRotatedSortedArray1 {

    /***
     *
     * There is an integer array nums sorted in non-decreasing order
     *
     * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
     *
     * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
     *
     * You must decrease the overall operation steps as much as possible.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     */

    public boolean searchForNonDuplicate(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] == target)
                return true;

            else if( nums[mid] >= nums[start]){ // sorted on the left
                if(nums[start] <= target && nums[mid] >= target){ // target exist in this sorted part
                    end = mid-1;
                }else{ // target does not exist in sorted part, ignore sorted part
                    start = mid+1;
                }
            }else{
                if(nums[mid] <= target  && nums[end]>=target){ // target exist in right sorted part
                    start = mid+1;
                }else{ // target does not exist in sorted part right
                    end = mid - 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }
}
