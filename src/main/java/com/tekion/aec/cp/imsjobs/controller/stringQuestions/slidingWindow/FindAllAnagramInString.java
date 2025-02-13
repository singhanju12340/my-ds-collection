package com.tekion.aec.cp.imsjobs.controller.stringQuestions.slidingWindow;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author anju
 * @created on 17/01/25 and 10:26 PM
 */
public class FindAllAnagramInString {
    /**
     * Given two strings s and p, return an array of all the start indices of p's
     * anagrams
     *  in s. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     * */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result; // Edge case
        }

        int[] pCounter = new int[26];
        int[] sCounter = new int[26];


        for(int i=0;i<p.length();i++){
            pCounter[p.charAt(i)-'a']++;
        }

        int pLength = p.length();
        // sliding window
        for(int i=0;i<s.length();i++) {
            // add new char freq
            sCounter[s.charAt(i)-'a']++;

            // remove older chars which is already compared
            if(i >= p.length())
            {
                sCounter[s.charAt(i-pLength)-'a']--;
            }

            // compare counters, if equal add starting index  into result
            if(Arrays.equals(sCounter, pCounter)){
                result.add(i-pLength+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FindAllAnagramInString solver = new FindAllAnagramInString();

        // Example usage
        System.out.println(solver.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(solver.findAnagrams("abab", "ab"));
    }
}
