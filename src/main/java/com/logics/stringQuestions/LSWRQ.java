package com.logics.stringQuestions;

/**
 * @author anju
 * @created on 04/09/24 and 10:13 PM
 */


import java.util.*;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LSWRQ {
    //Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int start=0;
        int left=0;
        int[] a = new int[0];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            if(map.containsKey(currChar) && map.get(currChar) >= left){
                left = map.get(currChar) + 1;
            }

            map.put(currChar, i);

            maxLen = Math.max(maxLen, i - left + 1);

        }
        return maxLen;


    }

    public static void main(String[] args) {
        //tmmzuxt
        // ohvh
        //abcab

        Queue<Integer> q = new LinkedList<>();


        lengthOfLongestSubstring("tmmzuxt");
    }
}
