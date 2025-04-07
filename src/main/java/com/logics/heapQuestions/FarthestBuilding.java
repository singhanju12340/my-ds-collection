package com.logics.heapQuestions;

/**
 * @author anju
 * @created on 25/03/25 and 11:51 AM
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/****
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 */
public class FarthestBuilding {

    private static int farthestHouseRec(int current, int totalBricks, int totalLadder, int[] heights){
        if(current>heights.length-1){
            return 0;
        }
        if(totalBricks<0 && totalLadder<0)
            return Integer.MIN_VALUE;

        int res = current;
        if(heights[current-1] >= heights[current]){
            return 1+ farthestHouseRec(current+1, totalBricks-0, totalLadder-0, heights);
        }else{
            int numOfBricksNeeded = heights[current] - heights[current-1];
            if(totalLadder>=1){
                 res = Math.max(res, farthestHouseRec(current+1, totalBricks, totalLadder-1, heights)); // ladder
            }

            if(totalBricks- numOfBricksNeeded > 0){
                 res = Math.max(res, farthestHouseRec(current+1, totalBricks- numOfBricksNeeded, totalLadder-0, heights)); // bricks
            }

            return res +1 ;
        }
    }
    // exponential time complexity O(2^n)
    //You can add memoization using a Map<String, Integer> (or 3D DP table) keyed on (index, bricks, ladders) to avoid recomputation.




    /**
     * Below is a Java solution that uses a greedy algorithm with a min-heap (priority queue) to determine the furthest building index you can reach.
     * The idea is to always use ladders for the largest gaps and bricks for the smaller ones.
     * We use a min-heap to keep track of all positive height differences encountered along the way.
     * When the number of gaps (i.e. differences) exceeds the number of available ladders, we replace the smallest gap (from the heap) with bricks.
     * If at any point we run out of bricks, we return the current building index.
     *
     * */


    /***
     *
     * nlogn time complexity
     *
     */

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // min-heap to store the gaps where we used ladders
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse from building 0 to building n - 1.
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                // Always consider using a ladder for the jump.
                minHeap.offer(diff);

                // If we used more ladders than available, replace the smallest gap with bricks.
                if (minHeap.size() > ladders) {
                    bricks -= minHeap.poll();
                    // If we run out of bricks, return current index.
                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }
        // If we've gone through all buildings, return the last index.
        return heights.length - 1;
    }


    public int furthestBuildingMemo(int[] heights, int bricks, int ladders) {
        // Create a memoization map to store computed results.
        Map<String, Integer> memo = new HashMap<>();
        return dfs(heights, 0, bricks, ladders, memo);
    }

    private int dfs(int[] heights, int index, int bricks, int ladders, Map<String, Integer> memo) {
        // Base case: if we've reached the last building.
        if (index == heights.length - 1) {
            return index;
        }

        // Create a unique key for the current state.
        String key = index + "," + bricks + "," + ladders;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int diff = heights[index + 1] - heights[index];
        int furthest = index;

        if (diff <= 0) {
            // No resource needed, so move to the next building.
            furthest = dfs(heights, index + 1, bricks, ladders, memo);
        } else {
            // Option 1: Use bricks if possible.
            int useBricks = -1;
            if (bricks >= diff) {
                useBricks = dfs(heights, index + 1, bricks - diff, ladders, memo);
            }

            // Option 2: Use a ladder if available.
            int useLadder = -1;
            if (ladders > 0) {
                useLadder = dfs(heights, index + 1, bricks, ladders - 1, memo);
            }

            // Choose the option that allows us to reach the furthest building.
            furthest = Math.max(useBricks, useLadder);
        }

        memo.put(key, furthest);
        return furthest;
    }

}
