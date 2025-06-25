package com.logics.dp3d;

import java.util.Arrays;

public class waysToSelectBuilding {
    /****
     * You are given a 0-indexed binary string s which represents the types of buildings along a street where:
     *
     * s[i] = '0' denotes that the ith building is an office and
     * s[i] = '1' denotes that the ith building is a restaurant.
     * As a city official, you would like to select 3 buildings for random inspection. However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.
     *
     * For example, given s = "001101", we cannot select the 1st, 3rd, and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
     * Return the number of valid ways to select 3 buildings.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "001101"
     * Output: 6
     * Explanation:
     * The following sets of indices selected are valid:
     * - [0,2,4] from "001101" forms "010"
     * - [0,3,4] from "001101" forms "010"
     * - [1,2,4] from "001101" forms "010"
     * - [1,3,4] from "001101" forms "010"
     * - [2,4,5] from "001101" forms "101"
     * - [3,4,5] from "001101" forms "101"
     * No other selection is valid. Thus, there are 6 total ways.
     * Example 2:
     *
     * Input: s = "11100"
     * Output: 0
     * Explanation: It can be shown that there are no valid selections.
     *
     */




    private long count;
    private long[][][] memo;
    public long numberOfWays(String s) {
        // numberOfWaysRecc(s, 0, 0, -1);
        // return count;

        // DP top down solution

        memo = new long[s.length()][4][3];     // Dimensions: index (up to n), selectedCount (0 to 3), lastSelectedType (-1, 0, 1 -> mapped to 0, 1, 2)

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return findCombinationsDp(s, 0, 0,-1);
    }

    public void numberOfWaysRecc(String s, int index, int currCount, int lastSelected) {
        if(currCount == 3){
            count++;
            return;
        }

        if(index == s.length()){
            return;
        }
        numberOfWaysRecc(s, index+1, currCount, lastSelected);

        int currentVal = s.charAt(index)-'0';

        if(lastSelected ==-1 || lastSelected != currentVal){
            numberOfWaysRecc(s, index+1, currCount+1, currentVal);
        }

    }


    private long findCombinationsDp(String s, int index, int selectedCount, int lastSelectedType) {
        if (selectedCount == 3) {
            return 1;
        }

        if (index == s.length()) {
            return 0;
        }

        int lastTypeIdx = lastSelectedType + 1;
        if (memo[index][selectedCount][lastTypeIdx] != -1) {
            return memo[index][selectedCount][lastTypeIdx];
        }

        long ways = 0;
        ways += findCombinationsDp(s, index + 1, selectedCount, lastSelectedType);
        int currentType = s.charAt(index) - '0'; // Convert '0' to 0, '1' to 1
        if (lastSelectedType == -1 || currentType != lastSelectedType) {
            ways += findCombinationsDp(s, index + 1, selectedCount + 1, currentType);
        }
        memo[index][selectedCount][lastTypeIdx] = ways;
        return ways;
    }

    public static void main(String[] args) {
        waysToSelectBuilding sol = new waysToSelectBuilding();

        System.out.println("s = \"001101\", Ways = " + sol.numberOfWays("001101")); // Expected: 4
        System.out.println("s = \"11100\", Ways = " + sol.numberOfWays("11100"));   // Expected: 0
        System.out.println("s = \"000111\", Ways = " + sol.numberOfWays("000111")); // Expected: 0
        System.out.println("s = \"10101\", Ways = " + sol.numberOfWays("10101"));   // Expected: 5 (as re-evaluated in previous response)
        System.out.println("s = \"010\", Ways = " + sol.numberOfWays("010"));       // Expected: 1
        System.out.println("s = \"101\", Ways = " + sol.numberOfWays("101"));       // Expected: 1
        System.out.println("s = \"0\", Ways = " + sol.numberOfWays("0"));           // Expected: 0
        System.out.println("s = \"01\", Ways = " + sol.numberOfWays("01"));         // Expected: 0
        System.out.println("s = \"01001\", Ways = " + sol.numberOfWays("01001"));  // Manual check:
    }

    }
