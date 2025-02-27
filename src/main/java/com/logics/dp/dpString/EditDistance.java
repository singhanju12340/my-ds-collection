package com.logics.dp.dpString;

import java.util.Arrays;

/**
 * @author anju
 * @created on 27/02/25 and 7:12 PM
 */
public class EditDistance {

    /***
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     *
     * You have the following three operations permitted on a word:
     *
     * Insert a character
     * Delete a character
     * Replace a character
     *
     *
     * Example 1:
     *
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explanation:
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     */



    public static void main(String[] args) {
//        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("sea", "ate"));

    }

    public int minDistance(String word1, String word2) {
//        return minDistanceRec(word1, word2, word1.length(), word2.length());

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return minDistanceMemo(word1, word2, word1.length(), word2.length(), dp);

//        return minDistanceTabu(word1, word2);
    }

    public int minDistanceRec(String word1, String word2, int index1, int index2) {
        if(index1 == 0) return index2; // case of insertion of all remaining char from word2 to make it same as word 1
        if(index2 == 0) return index1; // case of deletion of all remaining char from word1 to make it same as word2

        if(word1.charAt(index1-1) == word2.charAt(index2-1)){
            return minDistanceRec(word1, word2, index1-1, index2-1);
        }

        int insert = minDistanceRec(word1, word2, index1, index2-1);
        int delete = minDistanceRec(word1, word2, index1-1, index2);
        int replace = minDistanceRec(word1, word2, index1-1, index2-1);


        return Math.min(Math.min(insert,delete ), replace)+1;
    }

    public int minDistanceMemo(String word1, String word2, int index1, int index2, int[][] dp) {
        if(index1 == 0) return index2; // case of insertion of all remaining char from word2 to make it same as word 1
        if(index2 == 0) return index1; // case of deletion of all remaining char from word1 to make it same as word2

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(word1.charAt(index1-1) == word2.charAt(index2-1)){
            dp[index1][index2] = minDistanceMemo(word1, word2, index1-1, index2-1, dp);
            return   dp[index1][index2];
        }

        int insert = minDistanceMemo(word1, word2, index1, index2-1, dp);
        int delete = minDistanceMemo(word1, word2, index1-1, index2, dp);
        int replace = minDistanceMemo(word1, word2, index1-1, index2-1, dp);

        dp[index1][index2] = Math.min(Math.min(insert,delete ), replace)+1;
        return   dp[index1][index2];

    }


    public int minDistanceTabu(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<word1.length();i++){
            dp[i][0] = i;
        }

        for(int i=0;i<word2.length();i++){
            dp[0][i] = i;
        }
        for (int i=1;i<=word1.length();i++){
            for (int j = 1; j<=word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] =  Math.min(Math.min(insert,delete ), replace)+1;
                }
            }
        }

        return dp[word1.length()][word2.length()];

    }
}
