package com.logics.arrays;

/**
 * @author anju
 * @created on 25/02/25 and 3:35 PM
 */
public class FindMinInSortedRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= nums[start]) {
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else {
                end = mid - 1;
                start++;
                min = Math.min(nums[mid], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums2 = new int[]{0,1,2,4,5,6,7};
        int[] nums3 = new int[]{3,4,5,1,2};
        int[] nums4 = new int[]{1};
        int[] nums5 = new int[]{2,1};

        System.out.println(new FindMinInSortedRotatedArray().findMin(nums5));
    }
}


