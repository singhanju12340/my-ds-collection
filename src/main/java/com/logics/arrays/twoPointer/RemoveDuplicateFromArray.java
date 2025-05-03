package com.logics.arrays.twoPointer;

/**
 * @author anju
 * @created on 21/04/25 and 1:16 PM
 */
public class RemoveDuplicateFromArray {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

    public static int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int count;
        while(j<nums.length-1){
            count=1;
            while(j<nums.length-1 && nums[j] == nums[j+1]){
                count++;
                j++;
            }
            j++;
            nums[i++] = nums[j-1];
            if(count>1){
                nums[i++] = nums[j-1]; // add twice
            }
        }
        if(j==nums.length-1)
            nums[i++] = nums[j];
        return i;
    }

    public static int removeDuplicateSimple(int[] nums){
        int i=2;
        for(int j=2;j<nums.length;j++) {
            if(nums[j] != nums[i-2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        //1,1,1,2,2,3
        //System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(removeDuplicateSimple(new int[]{1,1,1,2,2,3}));


    }
}
