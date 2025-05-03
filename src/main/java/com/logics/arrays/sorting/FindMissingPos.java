package com.logics.arrays.sorting;

/**
 * @author anju
 * @created on 02/05/25 and 4:45 PM
 */
public class FindMissingPos {
    public int firstMissingPositive(int[] nums) {

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                while(nums[i]>0 && nums[i]-1 != i && nums[i]-1>i){
                    int curr = nums[i]-1;
                    int temp = nums[i];
                    nums[i] = nums[curr];
                    nums[curr] = temp;
                }

            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
//        System.out.println(new FindMissingPos().firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(new FindMissingPos().firstMissingPositive(new int[]{1,1}));

    }
}
