package com.tekion.aec.cp.imsjobs.controller;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author anju
 * @created on 24/06/24 and 1:07 PM
 */
public class SubSetSumNonDuplicateWithDuplicateElementArray {

    public static void sum(int index, int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> currRes){
        res.add(new ArrayList<>(currRes));
        for(int i=index; i<arr.length;i++){
            if(i!=index && arr[i] == arr[i-1]) continue;
            currRes.add(arr[i]);
            sum(i+1, arr, res, currRes);
            currRes.remove(currRes.size()-1);
        }

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int index =0;
        int[] arr = new int[]{1,2,3,2,3,2};
        Arrays.sort(arr); // 1,2,2,2,3,3
        sum(index, arr, res, new ArrayList<>());

    }
}
