package com.logics.arrays;

/**
 * @author anju
 * @created on 24/02/25 and 3:22 PM
 */
public class SearchInRoatedSortedArray2 {
    /**
     *      * There is an integer array nums sorted in non-decreasing order with duplicate
     * @param nums
     * @param target
     * @return
     */

    public boolean searchForWithDuplicate(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] == target)
                return true;

            if(nums[start] == nums[mid])
            {
                start++;
                end--;
                continue;
            }



             if( nums[mid] >= nums[start]){ // sorted on the left
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
