package com.tekion.aec.cp.imsjobs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anju
 * @created on 06/05/24 and 5:08 PM
 */
public class Sum3 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        threeSum(arr);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;
        while(start<end-2){
            int a = nums[start];
            int target = -a;
            int bPosition = start+1;
            int cPosition = end-1;
            while(bPosition<cPosition){

                if(target == nums[bPosition] + nums[cPosition]){
                    List<Integer> entity = new ArrayList<Integer>();
                    entity.add(a);
                    entity.add(nums[bPosition]);
                    entity.add(nums[cPosition]);
                    result.add(entity);

                    while(bPosition<cPosition && nums[bPosition] == nums[bPosition+1]){
                        bPosition++;
                    }
                    while(cPosition>bPosition && nums[cPosition] == nums[cPosition-1]){
                        cPosition--;
                    }
                    bPosition++;
                    cPosition--;
                }
                else if(target > nums[bPosition] + nums[cPosition]){
                    bPosition++;
                }else {
                    bPosition--;
                }


            }
            while(start<end-1 && nums[start]==nums[start+1])
                start++;
            start++;

        }
        return result;
    }
}
