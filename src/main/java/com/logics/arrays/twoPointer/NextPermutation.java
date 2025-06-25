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

    public void nextPermutation2(int[] nums) {
        int i=nums.length-1;
        while(i>=1 && nums[i-1]>nums[i]){
            i--;
        }
        int left = i-1;

        if(left==0 && nums[left] > nums[left+1]){
            swap(nums,0,nums.length-1);
            return;
        }

        int j=left+1;
        while(j<nums.length-1 && nums[left]<nums[j]){
            j++;
        }
        swap(nums, left, j);

        int x=left+1;
        int y=nums.length-1;

        while(x<y){
            swap(nums, x, y);
        }


    }

    public static void main(String[] args) {
//        new NextPermutation().nextPermutation(new int[]{3,2,1});
        new NextPermutation().nextPermutation2(new int[]{1,2,3});

    }
}
