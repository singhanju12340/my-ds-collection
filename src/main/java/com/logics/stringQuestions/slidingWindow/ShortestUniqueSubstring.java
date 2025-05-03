package com.logics.stringQuestions.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author anju
 * @created on 18/04/25 and 3:56 PM
 */
public class ShortestUniqueSubstring {
    /**
     * Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.
     *
     * Come up with an asymptotically optimal solution and analyze the time and space complexities.
     *
     * Example:
     *
     * input:  arr = ['x','y','z'], str = "xyyzyzyx"
     *
     * output: "zyx"
     */

    public static String getShortestUniqueSubstring(String str, char[] arr){
        Set<Character> need = new HashSet<>();
        Map<String, Integer> has = new HashMap<>();

        char[] input = str.toCharArray();

        for(char c: arr){
            need.add(c);
        }





        return null;
    }


}
