package com.logics.dp2d;

/**
 * @author anju
 * @created on 28/06/24 and 10:53 PM
 */
public class FrogJump {
    /***
     *https://leetcode.com/problems/frog-jump/
     * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
     *
     * Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
     *
     * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
     *
     * Example 1:
     * Input: stones = [0,1,3,5,6,8,12,17]
     * Output: true
     * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
     *
     * Example 2:
     * Input: stones = [0,1,2,3,4,8,9,11]
     * Output: false
     * Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
     */


//    public static int cal(int curr, int[] arr, int[] dp) {
//        if(curr == 0)
//            return 0;
//        if(dp[curr] !=-1)
//            return dp[curr];
//
//        int r = Integer.MAX_VALUE;
//        int l = Math.abs(arr[curr] - arr[curr-1])  +  cal( curr-1, arr, dp);
//       if(curr >1)
//           r = Math.abs(arr[curr] - arr[curr-2])  +  cal( curr-2, arr, dp);
//
//        dp[curr] = Math.min(l, r);
//         return dp[curr];
//    }

    public static void main(String[] args) {
//        int[] ar = new int[]{0,1,3,5,6,8,12,17};
        int[] ar = new int[]{0,1,2,3,4,8,9,11};

        // frog has reached to 1st position by taking 1 step
        System.out.println(new FrogJump().dfsRecursion(ar, 1, 1));

    }

    public boolean dfsRecursion(int[] stone, int currentIndex, int lastJump){
        // base condition
        // once frog reached to the end stone,

        if(stone[1]!=1)
            return false;
        if(currentIndex == stone.length-1){
            return true;
        }

        //  next possible jump counts are {lastJump+1/ lastJump/ lastJump+1}

        for(int nextpossibleJump = lastJump-1; nextpossibleJump <= lastJump+1 ; nextpossibleJump++){

            int expectedNextPosition = stone[currentIndex] + nextpossibleJump;

            // check for all next  position where frog can jump
            for(int nextPosition=currentIndex+1; nextPosition<stone.length; nextPosition++){

                if(expectedNextPosition == stone[nextPosition]){
                    if(dfsRecursion(stone, nextPosition, nextpossibleJump))
                    return true;
                }
                else if(stone[nextPosition]> expectedNextPosition){
                    // stone array is sorted we do not need to check next if next stone is far from possible jump position
                    break;
                }
            }
        }
        return false;
    }


    public void dfsDpMemorisation(int[] stone){
        int[][] dp = new int[stone.length][stone.length+1];
        // base condition
        // once frog reached to the end stone,


    }
}
