package com.logics.dp.dpString;

import java.util.Arrays;

/**
 * @author anju
 * @created on 16/04/25 and 4:48 PM
 */
public class LongestCommonSubSequence {

    // given 2 string str1 and str2. find longest matching subsequence between two strings.
    // find all substrings of both the strings: 2^n + 2^m
    // compare and find longest matching 2^n  * 2^m


    // also print longest common subsequence string

    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[text1.length()+1][text2.length()];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return longestCommonSubsequenceRec(text1, text2, 0,0,dp);
    }

    public int longestCommonSubsequenceRec(String text1, String text2, int i, int j, int[][] dp) {
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1+ longestCommonSubsequenceRec(text1, text2, i+1,j+1,dp);
        }else{
            dp[i][j] = 0+ Math.max(
                    longestCommonSubsequenceRec(text1, text2, i+1,j,dp),
                    longestCommonSubsequenceRec(text1, text2, i,j+1,dp)
            );

        }
        return dp[i][j];

    }


    public int longestCommonSubsequenceTabu(String text1, String text2) {
        int[][]dp = new int[text1.length()+1][text2.length()+1];


        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0+ Math.max( dp[i-1][j],  dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public int longestCommonSubsequenceTabuSpace(String text1, String text2) {
//        int[][]dp = new int[text1.length()+1][text2.length()+1];
        int[]prev = new int[text1.length()+1];
        int[]curr = new int[text1.length()+1];

        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = 0 +  Math.max( prev[j],  curr[j-1]);
                }
            }
            prev = curr;
        }
        return curr[text1.length()];
    }



    public String longestCommonSubsequenceTabuPrintString(String text1, String text2) {
        int[][]dp = new int[text1.length()+1][text2.length()+1];


        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0+ Math.max( dp[i-1][j],  dp[i][j-1]);
                }
            }
        }
        int resultCount = dp[text1.length()][text2.length()];

        char[] resultArray  = new char[resultCount];

        int i=text1.length()+1;
        int j=text2.length()+1;

        while(i>0 && j>0 && resultCount>=0){

            if(text1.charAt(i-1) == text2.charAt(j-1)){
                resultArray[resultCount-1] = text1.charAt(i-1);
                resultCount = resultCount-1;
                i--;
                j--;
            }else{
                if(dp[i-1][j]> dp[i][j-1]){
                    i=i-1;
                }else{
                    j=j-1;
                }
            }
        }

        System.out.println(resultArray.toString());
        return resultArray.toString();
    }


    public static void main(String[] args) {
        System.out.println(new LongestCommonSubSequence().longestCommonSubsequence("abcde", "ace"));
//        System.out.println(new LongestCommonSubSequence().longestCommonSubsequenceTabu("abcde", "ace"));
        System.out.println(new LongestCommonSubSequence().longestCommonSubsequenceTabuPrintString("abcde", "ace"));


    }

}
