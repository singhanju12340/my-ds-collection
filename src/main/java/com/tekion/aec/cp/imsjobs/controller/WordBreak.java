package com.tekion.aec.cp.imsjobs.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author anju
 * @created on 05/06/24 and 5:03 PM
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
       String s = "catsandog";
        String[] SET_VALUES = new String[]  {"cats","dog","sand","and","cat"};
        Set<String> wordDict = new HashSet<String>(Arrays.asList(SET_VALUES));
        wordBreak(s, wordDict);
    }
}
