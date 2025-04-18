package com.logics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author anju
 * @created on 04/09/24 and 12:34 PM
 */
public class InsertInterval {
    /***
     *
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     *
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     *
     * Return intervals after the insertion.
     *
     * Note that you don't need to modify intervals in-place. You can make a new array and return it.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     *
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     */


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length+1][2];
        int i=0;
        int n = intervals.length;
        int j=0;
        while( i<n && intervals[i][1] < newInterval[0]){
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
            i++;
            j++;
        }
        //find overlapping
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result[j][0]=newInterval[0];
        result[j][1]=newInterval[1];
        j++;
        while( i<n ){
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
            i++;
            j++;
        }
        return result;
    }

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,3},{6,9}};
        int[] intv = new int[]{2,5};


        int[][] input2 = new int[][]{{1,2},{3,5}, {6,7}, {8,10}, {12,16}};
        int[] intv2 = new int[]{4,8};



        int[][] result = insert2(input2,intv2);
        System.out.println(result);
    }

    //rivision
    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i=0;

        // all interval with end time less than newinterval start time should be added in the result
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        // overlapping intervals with new intervals
        while(i<intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(new int[]{ newInterval[0],  newInterval[1]});


        // remaining intervals

        while( i<intervals.length ){
            result.add(new int[]{ intervals[i][0],  intervals[i][1]});
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
