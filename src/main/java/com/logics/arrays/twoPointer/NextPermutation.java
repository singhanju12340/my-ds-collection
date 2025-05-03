package com.logics.arrays.twoPointer;

/**
 * @author anju
 * @created on 02/05/25 and 2:55 PM
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int end = nums.length-1;
        int move = end-1;

        if(move<0)
            return;

        if(nums[move]< nums[end]){
            swap(nums, move, end);
            return;
        }

        while(move>=1 && nums[move]>=nums[move+1]){
            move--;
        }

        if(nums[move] < nums[move+1]){
            // find right element greather that move(smalest)
            int currentEnd=end;
            while(nums[move] >= nums[currentEnd] ){
                currentEnd--;
            }
            swap(nums, move, currentEnd);
            move++;
        }

        while(move<end){
            swap(nums, move, end);
            move++;
            end--;
        }
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y]= temp;
    }

    public static void main(String[] args) {
//        new NextPermutation().nextPermutation(new int[]{3,2,1});
        new NextPermutation().nextPermutation(new int[]{1,3,2});

    }
}
