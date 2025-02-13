package com.tekion.aec.cp.imsjobs.controller.dpSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anju
 * @created on 07/11/24 and 4:57 PM
 */
public class Subset2 {
    /**
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets
     *  (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *Example 1:
     *
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * */


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsDuplicate(nums, res, 0, new ArrayList<>());
        return res;
    }


    public void subsetsDuplicate(int[] nums, List<List<Integer>> res, int index, List<Integer> currRes) {

        if(index > nums.length-1){
            res.add(new ArrayList<>(currRes));
            return;
        }

        //take
        if(index > 0 && nums[index] == nums[index-1]) {
            return;
        }
            currRes.add(nums[index]);
            subsetsDuplicate(nums, res,  index+1, currRes);
            //revert
            currRes.remove(currRes.size()-1);
            //notTake
            subsetsDuplicate(nums, res, index+1, currRes);


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println( new Subset2().subsetsWithDup(nums));
    }

}
