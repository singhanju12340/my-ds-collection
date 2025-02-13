package com.logics.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author anju
 * @created on 31/12/24 and 1:25 PM
 */
public class MaxProfitJobScheduling {
        /**
         * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
         *
         * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
         *
         * If you choose a job that ends at time X you will be able to start another job that starts at time X.
         *
         * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
         * Output: 120
         * Explanation: The subset chosen is the first and fourth job.
         * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
         * **/

        static class Job{
             int startTime;
             int endTime;
             int profit;
            Job(int start, int endTime, int profit){
                this.startTime = start;
                this.endTime = endTime;
                this.profit = profit;
            }
        }


    public static void main(String[] args) {
        MaxProfitJobScheduling solution = new MaxProfitJobScheduling();

        int[] startTime3 = {1, 1, 1};
        int[] endTime3 = {2,3,4};
        int[] profit3 = {5,6,4};
        System.out.println(solution.jobScheduling3(startTime3, endTime3, profit3)); // expected 6

        int[] startTime2 = {1, 2, 3, 4, 6};
        int[] endTime2 = {3, 5, 10, 6, 9};
        int[] profit2 = {20, 20, 100, 70, 60};
        System.out.println(solution.jobScheduling2(startTime2, endTime2, profit2)); // Expected: 150


        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(solution.jobScheduling3(startTime, endTime, profit)); // Expected: 120
    }


    /////////////////// recursive
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit){
        Job[] jobs = new Job[startTime.length];
        for(int i=0;i<startTime.length;i++){
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }
        Arrays.sort(jobs, (a,b)->a.startTime-b.startTime);
        return jobSchedulingRec(0, jobs);
    }

    public int jobSchedulingRec(int index, Job[] jobs){
        int profit=0;
        if(index >= jobs.length)
            return 0;

        Job current = jobs[index];
        int nextIndex = index+1;

        // not take profit
        int noTakeProfit = 0 +  jobSchedulingRec(nextIndex, jobs);
        while(nextIndex< jobs.length && current.endTime > jobs[nextIndex].startTime){
            nextIndex++;
        }
        // take profit
        int takeProfit =  profit+jobs[index].profit + jobSchedulingRec(nextIndex, jobs);
        return Math.max(takeProfit, noTakeProfit);
    }


    ///////////////////////////// recursive with memorisation
    public int jobScheduling3(int[] startTime, int[] endTime, int[] profit){
        Job[] jobs = new Job[startTime.length];
        for(int i=0;i<startTime.length;i++){
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }
        Arrays.sort(jobs, (a,b)->a.startTime-b.startTime);
        Integer[] dp = new Integer[jobs.length];

        return jobSchedulingDp(0, jobs, dp);
    }


    public int jobSchedulingDp(int index, Job[] jobs , Integer[] dp){

        if(index >= jobs.length){
            return 0;
        }
        if(dp[index] != null)
            return dp[index];

        int nextIndex = index+1;

        // not take profit
        int noTakeProfit = 0 +  jobSchedulingDp(nextIndex, jobs, dp);

        while(nextIndex< jobs.length && jobs[index].endTime > jobs[nextIndex].startTime){
            nextIndex++;
        }
        // take profit
        int takeProfit =  jobs[index].profit + jobSchedulingDp(nextIndex, jobs, dp);
        dp[index] = Math.max(takeProfit,noTakeProfit);
        return dp[index] ;
    }

////////////////////////////////////////
// The most improved version with find next element to take as profit using binary search, bottm up approach
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit){
        int netProfit = 0;
        Job[] jobs = new Job[startTime.length];
        int[] dp = new int[startTime.length];

        for(int i=0;i<startTime.length;i++){
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));
        dp[0] = jobs[0].profit;


        for(int i=1;i<startTime.length;i++){
            int nearestValidJob = binarySearch(jobs, i);

            // pick
            int pickProfit = jobs[i].profit;

            if(nearestValidJob != -1){
                pickProfit = dp[nearestValidJob] + pickProfit;
            }
            // non pick
            int noPick = dp[i-1];

            dp[i] = Math.max(noPick, pickProfit);
        }
        return dp[startTime.length-1];
    }

    private int binarySearch(Job[] jobs, int index){
        int low = 0;
        int high = index-1;
        while(low <= high){
            int mid = (low+high)/2;

            if(jobs[mid].endTime <= jobs[index].startTime){

                if(jobs[mid+1].endTime <= jobs[index].startTime)
                    low = mid+1;
                else
                    return mid;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }




}
