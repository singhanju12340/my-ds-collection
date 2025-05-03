package com.logics.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 20/04/25 and 7:50 PM
 */
public class Subset {
    /***
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     */

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        printAllSubSetEfficient(0,new ArrayList<>(), nums ,list);
        return list;
    }

    public static void printAllSubSetEfficient(int i,ArrayList<Integer> l, int[] arr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(l));
        for(int j = i; j < arr.length; j++) {
            l.add(arr[j]);
            printAllSubSetEfficient(j+1, l, arr, ans);
            l.remove(l.size()-1);
        }
    }

    public static void printAllSubSet(int i, ArrayList<Integer> l, int[] arr, List<List<Integer>> ans){
       if(i>arr.length){
            ans.add(new ArrayList<>(l));
       }
       l.add(arr[i]);
       printAllSubSetEfficient(i+1, l, arr, ans); // take
        l.remove(l.size()-1);
        printAllSubSetEfficient(i+1, l, arr, ans); // do not take
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
}
