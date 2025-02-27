package com.logics.arrays;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author anju
 * @created on 17/10/24 and 2:14 PM
 */
public class MergeInterval {

    /***
     *
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     *
     * input {{1,3} , {4,8} ,{6,7}}
     *
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     */

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 1;
        List<int[]> result = new ArrayList<>();
        while(i < intervals.length){
            if(intervals[i][0] <= end){
                end = Math.max(end,intervals[i][1]);
            }else{
                result.add(new int[]{start, end});
                start= intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        result.add(new int[]{start, end});


        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        String a = null;
        String b = "as";
        String res = String.join("-", "wdwdw", "");

        final String displayName = StringUtils.isNotBlank(a) ?
                String.join(" - ", b,
                        a) : b;

        System.out.println(displayName);

         HashMap<String, TreeMap<Integer, String>> map;

        HashMap<String, TreeMap<Integer, String>> map1 = new HashMap(){
            @Override
            public boolean containsKey(Object key) {
                return super.containsKey(key);
            }
        };



        int[][] intervals = {{1,4}, {0,4}};

        int[][] intervals2 = {{1,3}, {2,6}, {8,10}, {15,18}};

        int[][] intervals3 = {{1,5}, {0,4}};

        int[][] result = merge2(intervals3);
    }

    public static int[][] merge2(int[][] intervals) {
        // sort interval based on end time in assending order
        Arrays.sort(intervals,(a,b)-> a[1]-b[1] );
        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        int i=1;
        while(i<intervals.length){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart<=end){
                end = Math.max(currentEnd, end);
            }else{
                result.add(new int[]{start, end});
                end = intervals[i][1];
                start = intervals[i][0];
            }
            i++;
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }


}


