package com.logics;

import java.util.ArrayList;

/**
 * @author anju
 * @created on 24/06/24 and 1:07 PM
 */
public class SubSetSum {

    public static void sum(int index, int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> currRes){
        res.add(new ArrayList<>(currRes));
        for(int i=index; i<arr.length;i++){

            currRes.add(arr[i]);
            sum(i+1, arr, res, currRes);
            currRes.remove(currRes.size()-1);
        }

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int index =0;
        int[] arr = new int[]{3,1,2};

        sum(index, arr, res, new ArrayList<>());

    }
}
