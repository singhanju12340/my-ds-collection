package com.logics.arrays.twoPointer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author anju
 * @created on 15/02/25 and 7:54 PM
 */
public class QuadSum {
    public static void main(String[] args) {
        int[] nums2 = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target2 = -294967296;
        ///
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target1 = 0;

        int[] nums3 = new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
                ,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};


        System.out.println(new QuadSum().getQuadSumDuplicateUsingMap(nums3, target1));
    }



    // for duplicate array, multiple response
    public List<List<Integer>> getQuadSumDuplicate(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            //skip ith index handler duplicate
            if(i>0 && nums[i] == nums[i-1])continue;

            for(int j = i+1 ; j<nums.length-2; j++) {
                //skip ith index handler duplicate
                if(j>i+1 && nums[j] == nums[j-1])continue;

                // use 2 pointer to find remaining sum from other 2 indexes
                int left = j+1;
                int right = nums.length-1;

                while(left < right){
                    long sum = nums[i];
                    sum = sum + nums[j] ;
                    sum = sum + nums[left];
                    sum = sum + nums[right];

                    if(sum == target){
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[left], nums[right]}));
                        left++;
                        right--;

                        // skip duplicate left
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    //skip duplicate right
                    while(right+1 < nums.length-1 && left < right && nums[right] == nums[right+1]){
                            right--;
                    }
                    }else if( sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> getQuadSumDuplicateUsingMap(int[] nums, int target){
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        // same sum can be created with different combinations
        Map<Long, List<Integer[]>> map = new HashMap();


        // create map for each pair
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                Long sum = Long.valueOf(nums[i]+nums[j]);
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(new Integer[]{i, j});
            }
        }

        for ( Long sum: map.keySet()) {
            Long complementarySum = target-sum;

            if(map.containsKey(complementarySum)){

               List<Integer[]> pairList1 = map.get(sum);
                List<Integer[]> pairList2 = map.get(complementarySum);

                for (Integer[] pair1:pairList1) {
                    for (Integer[] pair12:pairList2 ) {
                        if(pair1[1] < pair12[0]){
                            List<Integer> quad = Arrays.asList(
                                    nums[pair1[0]],
                                    nums[pair1[1]],
                                    nums[pair12[0]],
                                    nums[pair12[1]]
                            );
                            result.add(quad);
                        }
                    }
               }
            }
        }
        return  new ArrayList<>(result);
    }

    // for non duplicate array, single response
    public int[] getQuadSum(int[] nums, int target){
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){


            for(int j = i+1 ; j<nums.length-2; j++) {
                // use 2 pointer to find remaining sum from other 2 indexes

                int left = j+1;
                int right = nums.length-1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        return new int[]{i,j,left, right};
                    }else if(left >= j+1 && sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }


            }

        }
        return null;
    }

    // for non duplicate array, multiple response
    public List<List<Integer>> getQuadSum2(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length-3;i++){


            for(int j = i+1 ; j<nums.length-2; j++) {
                // use 2 pointer to find remaining sum from other 2 indexes

                int left = j+1;
                int right = nums.length-1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        result.add(Arrays.asList(new Integer[]{i,j,left, right}));
                        left++;
                        right--;
                    }else if(left >= j+1 && sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }


            }

        }
        return null;
    }



    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        int n = nums.length;
        // Sort the array to help avoid duplicates and to enforce an order.
        Arrays.sort(nums);

        // Map to store sum of pairs -> list of pairs (represented as int[] {i, j})
        Map<Integer, List<int[]>> pairSumMap = new HashMap<>();

        // Precompute all pair sums.
        for (int i = 0; i < n - 1; i++) {
            // To avoid duplicates in a single pair, we start j from i+1.
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                pairSumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // Use a Set to prevent duplicate quadruplets.
        Set<List<Integer>> quadrupletsSet = new HashSet<>();

        // Iterate through each unique pair sum in the map.
        for (Integer sum : pairSumMap.keySet()) {
            int complement = target - sum;
            if (pairSumMap.containsKey(complement)) {
                List<int[]> list1 = pairSumMap.get(sum);
                List<int[]> list2 = pairSumMap.get(complement);

                // Combine pairs from list1 and list2.
                for (int[] pair1 : list1) {
                    for (int[] pair2 : list2) {
                        // Ensure that the indices do not overlap and are in order.
                        // We require pair1[1] < pair2[0] so that indices are strictly increasing.
                        if (pair1[1] < pair2[0]) {
                            List<Integer> quad = Arrays.asList(
                                    nums[pair1[0]],
                                    nums[pair1[1]],
                                    nums[pair2[0]],
                                    nums[pair2[1]]
                            );
                            quadrupletsSet.add(quad);
                        }
                    }
                }
            }
        }

        result.addAll(quadrupletsSet);
        return result;
    }


}
