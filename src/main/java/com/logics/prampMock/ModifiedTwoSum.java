package com.logics.prampMock;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author anju
 * @created on 20/04/25 and 12:03 PM
 */
public class ModifiedTwoSum {
    /**
     * Merging 2 Packages
     *  * Given a package with a weight limit limit and an array arr of item weights, implement a function
     *  getIndicesOfItemWeights that finds two items whose sum of weights equals the weight limit limit.
     *  Your function should return a pair [i, j] of the indices of the item weights, ordered such that i > j.
     *  If such a pair doesn't exist, return an empty array.
     *  *
     *  * Analyze the time and space complexities of your solution.
     */

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
// // [4, 6, 10, 15, 16],  lim = 21
// (15,6)

// 4-<0,1>
//inout 4,4
// and <1,0>

        if(arr.length < 2)
            return new int[]{};

        // your code goes here
        Map<Integer, Stack<Integer>> metaData = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(metaData.containsKey(arr[i])){
                Stack<Integer> newStack = metaData.get(arr[i]);
                newStack.add(i);
                metaData.put(arr[i], newStack);
            }else{
                Stack<Integer> newStack = new Stack<Integer>();
                newStack.add(i);
                metaData.put(arr[i], newStack);
            }
        }

        for(int a:arr){
            if(metaData.containsKey(limit-a)){
                return new int[]{metaData.get(limit-a).pop(), metaData.get(a).pop()};
            }
        }
        return new int[]{};

    }

    static int[] getIndicesOfItemWeightsEfficient(int[] arr, int limit) {
// // [4, 6, 10, 15, 16],  lim = 21
// (15,6)

// 4-<0,1>
//inout 4,4
// and <1,0>

 /* improved solution
 // [4, 6, 10, 15, 16]
// 21 - 4 not in {} -> {4: 0}
// 21 - 6 not in {} -> {4: 0, 6: 1}
// 21 - 10 not in {} -> {4:0, 6:1, 10:2}
// 21 - 15 in {} -> [3, 1]


// [4,4] lim = 8
// 8-4 in {} -> {4: 0}
// 8 -4 in {} -> [1, 0]
  */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if(!map.containsKey(limit-arr[i])){
                map.put(arr[i], i);
            }else{
                return new int[]{i, map.get(limit-arr[i])};
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        System.out.println(getIndicesOfItemWeightsEfficient(new int[]{4, 6, 10, 15, 16}, 21));
    }

}
