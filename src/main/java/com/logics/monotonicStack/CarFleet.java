package com.logics.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author anju
 * @created on 26/12/24 and 6:58 PM
 */
public class CarFleet {
    /**
     * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
     *
     * You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
     *
     * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
     *
     * A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
     *
     * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
     *
     * Return the number of car fleets that will arrive at the destination.
     *
     *
     * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     *
     * Output: 3
     *
     * Explanation:
     *
     * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
     * The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
     * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
     *
     *
     * Input: target = 10, position = [3], speed = [3]
     *
     * Output: 1
     *
     * Explanation:
     *
     * There is only one car, hence there is only one fleet.
     * Example 3:
     *
     * Input: target = 100, position = [0,2,4], speed = [4,2,1]
     *
     * Output: 1
     *
     * Explanation:
     *
     * The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
     * Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
     * */

    public static int carFleet(int target, int[] position, int[] speed) {
        int res;
        int[][] matrix = new int[position.length][2];

        double[] timeTaking = new double[position.length];

        for(int i=0;i<position.length;i++){
            matrix[i][0] = position[i];
            matrix[i][1] = speed[i];
        }
        // sort vehicle based on position in decreasing order.
        Arrays.sort(matrix, (a,b) -> b[0] - a[0]);

        // calculate time taken by each vehicle to reach target
        // (target - currentPosition) / speed in decending order

        for(int i=0; i<position.length; i++){
            timeTaking[i] =(double) (target - matrix[i][0])/matrix[i][1];
        }

        // calculate fleet based on vehicles reaching target in which sequence
        int fleetCount = 1;
        double max = timeTaking[0];


        for(int  i = 1; i<position.length;i++){
            if(timeTaking[i] <= max){
                continue;
            }else{
                max = timeTaking[i];
                fleetCount++;
            }
        }
        System.out.println(fleetCount);
        return fleetCount;
    }


    /**
     * Can be solved using monotonic stack as we have to increment fleet if we find next greater time taking car in sorted position array
     * */

    public static int carFleetUsingStack(int target, int[] position, int[] speed){
        int[][] matrix = new int[position.length][2];
        Stack<Double> st = new Stack<>();

        for(int i=0;i<position.length;i++){
            matrix[i][0] = position[i];
            matrix[i][1] = speed[i];
        }

        Arrays.sort(matrix, (a,b) -> b[0]- a[0]);

        int fleetCount = 0;

        for(int i=0;i< position.length;i++){
            double time = (double)  (target-matrix[i][0])/matrix[i][1] ;
            if(st.isEmpty() || st.peek()<time){
                st.push(time);
                fleetCount++;
            }
        }

        System.out.println(fleetCount);
        return fleetCount;
    }


    public static void main(String[] args) {
//        carFleet(12, new int[]{10,8,5,3,0}, new int[]{2,4,1,3,1});
//        carFleet(10, new int[]{6,8}, new int[]{3,2});
        carFleetUsingStack(10, new int[]{6,8}, new int[]{3,2});
    }
}
