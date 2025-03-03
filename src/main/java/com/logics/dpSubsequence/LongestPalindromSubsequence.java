package com.logics.dpSubsequence;

/**
 * @author anju
 * @created on 28/02/25 and 12:30 PM
 */
public class LongestPalindromSubsequence {
    /***
     * Given a string s, find the longest palindromic subsequence's length in s.
     *
     * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
     *

     * Example 1:
     *
     * Input: s = "bbbab"
     * Output: 4
     * Explanation: One possible longest palindromic subsequence is "bbbb".
     */

    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(new LongestPalindromSubsequence().longestPalindromeSubseq(str));
    }

    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqRec(s, 0, s.length()-1);
    }

    public int longestPalindromeSubseqRec(String s, int start, int end) {
        if(start==end)
            return 1;
        if(start>end){
            return 0;
        }

        if(s.charAt(start) == s.charAt(end)){
            return 2 + longestPalindromeSubseqRec(s, start+1, end-1);
        }else{
            return Math.max(longestPalindromeSubseqRec(s, start+1, end),
                    longestPalindromeSubseqRec(s, start, end-1)
                    );
        }

    }
}
