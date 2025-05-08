package com.logics.greedy;

/**
 * @author anju
 * @created on 04/05/25 and 5:48 PM
 */
public class PatchArray {

    public int minPatches(int[] nums, int n) {
        long missing=1;
        int count=0;
        int i=0;
        while(missing<=n){
            if(i<nums.length && nums[i]<=missing){
                missing+=nums[i];
                i++;
            }else{
                missing += missing;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PatchArray().minPatches(new int[]{1,3}, 6));
    }
}
