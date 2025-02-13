package com.tekion.aec.cp.imsjobs.controller.stringQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 02/01/25 and 10:34 PM
 */
public class MinimumWindowSubString {
    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     *
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     *
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     *
     * **/

    public String minWindow(String s, String t) {

        // keep 2 pointer for left and right. keep moving right counter till all target chars are found in current window
        // create map of char frequency for target string
        // create map of char freq for string in current window
        // keep counter for target char count
        // keep counter for window found char count
        //if target_count == window_found_count get the length and left min starting
        // once all found try decreasing window size by moving left pointer. keep calculating left while miniming the window size from left

        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minCount = Integer.MAX_VALUE;

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();


        int windowCount = 0;

        // create map frequency for target characters
        for(int i=0;i<t.length();i++){
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int targetCount = targetMap.size();


        while(right <s.length()){

            Character currentChar = s.charAt(right);

            // add current char in a window
            windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);


            // check if current char frequency is matched in target and window
            if(targetMap.containsKey(currentChar) && targetMap.get(currentChar) == windowMap.get(currentChar)){
                windowCount++;
            }

            // try increasing left, to minimize window length
            while(targetCount == windowCount){
                if( right - left + 1 < minCount){
                    minCount = right - left + 1;
                    minLeft = left;
                }

                // remove left and check if still substring
                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(targetMap.containsKey(leftChar) && (windowMap.get(leftChar) < targetMap.get(leftChar))){
                    windowCount--;
                }
                left++;
            }

            right++;
        }

        return minCount==Integer.MAX_VALUE ? "": s.substring(minLeft, minLeft+minCount);

    }

    public static void main(String[] args) {
        MinimumWindowSubString solution = new MinimumWindowSubString();
//        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
//        System.out.println(solution.minWindow("a", "a")); // Output: "a"
        System.out.println(solution.minWindow("aa", "aa")); // Output: ""

    }
}


