package com.tekion.aec.cp.imsjobs.controller.dp;

import java.util.Arrays;

/**
 * @author anju
 * @created on 07/02/25 and 5:14 PM
 */
public class DecodeWays {
    /**
     * You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:
     *
     * "1" -> 'A'
     *
     * "2" -> 'B'
     *
     * ...
     *
     * "25" -> 'Y'
     *
     * "26" -> 'Z'
     *
     * However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").
     *
     * For example, "11106" can be decoded into:
     *
     * "AAJF" with the grouping (1, 1, 10, 6)
     * "KJF" with the grouping (11, 10, 6)
     * The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
     * Note: there may be strings that are impossible to decode.
     *
     * Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
     *
     * The test cases are generated so that the answer fits in a 32-bit integer.
     * */
    public int numDecodings(String s) {
//        return solve(s, 0);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
//        return solve(s, 0, dp);
        return solveDp(s);


    }

    public int solve(String s, int index){
//        if(s.charAt(index)  == '0')
//            return 0;

        if(index == s.length())
                return 1;

        int waysCount = 0;

        if(s.charAt(index)  != '0')
            waysCount = solve(s, index + 1);

        // decode 2 ways

        if(index+1 < s.length() && Integer.parseInt(s.substring(index, index+2)) <=26)
            waysCount+= solve(s, index + 2);

        return waysCount;

    }


    // memorisation
    public int solve(String s, int index, int[] dp){
        if(s.charAt(index)  == '0')
            return 0;

        if(index == s.length())
            return 1;

        int waysCount = 0;

        if(dp[index] !=-1)
            return dp[index];

        waysCount = solve(s, index + 1);

        // decode 2 ways

        if(index+1 < s.length() && Integer.parseInt(s.substring(index, index+2)) <=26)
            waysCount+= solve(s, index + 2);

        dp[index] = waysCount;
        return waysCount;

    }


    // dp
    public int solveDp(String s){
        int[] dp = new int[s.length()+1];

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // No valid decoding for strings starting with '0'
        }
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=s.length();i++ ){
            int count=0;
            // char oneDigit = s.charAt(i-1);
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));

            if(oneDigit != 0 )
                count +=dp[i-1];

            if(twoDigit>=10 && twoDigit <=26 ){
                count +=  dp[i-2];
            }
            dp[i] = count;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
//        System.out.println(new DecodeWays().numDecodings("1234"));
//        System.out.println(new DecodeWays().numDecodings("27"));
//        System.out.println(new DecodeWays().numDecodings("10"));
//        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("06"));




    }
}
