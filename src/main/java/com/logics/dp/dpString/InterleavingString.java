package com.logics.dp.dpString;

/**
 * @author anju
 * @created on 20/03/25 and 6:36 PM
 */
public class InterleavingString {
    /***
     * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     *
     * An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
     *
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
     * Note: a + b is the concatenation of strings a and b.
     *
     */

// s1=aa, s2=ab, s3=aaba
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(k<s3.length()){
            int oldk = k;

            while(i< s1.length() &&  k<s3.length() && s1.charAt(i) == s3.charAt(k)){
                i++;
                k++;
            }
            while(j< s2.length() && k<s3.length() && s2.charAt(j) == s3.charAt(k)){
                j++;
                k++;
            }
            if(s1.length()==i && s2.length()==j && k == s3.length())
                return true;
            else if((s1.length()!=i || s2.length()!=j) && k == s3.length()){
                return false;
            }

            if(oldk == k)
                return false;
        }
        return true;
    }


    public boolean isInterleaveRec(String s1, String s2, String s3, int s1Index, int s2Index){


        if(s1Index == s1.length() && s2Index == s2.length()){
            return true;
        }

        boolean result=false;
        if(s1Index<s1.length() && s1.charAt(s1Index) == s3.charAt(s1Index+s2Index)){
             result= isInterleaveRec(s1, s2, s3, s1Index+1, s2Index);
        }

        if(!result && s2Index<s2.length() && s2.charAt(s2Index) == s3.charAt(s1Index+s2Index)){
             result= isInterleaveRec(s1, s2, s3, s1Index, s2Index+1);
        }

        return result;

    }


    public boolean isInterleaveMemo(String s1, String s2, String s3, int s1Index, int s2Index, Boolean[][] dp){

        if(s1Index == s1.length() && s2Index == s2.length()){
            return true;
        }

        if(dp[s1Index][s2Index] != null)
            return dp[s1Index][s2Index];

        boolean result=false;
        if(s1Index<s1.length() && s1.charAt(s1Index) == s3.charAt(s1Index+s2Index)){
            result= isInterleaveMemo(s1, s2, s3, s1Index+1, s2Index, dp);
        }

        if(!result && s2Index<s2.length() && s2.charAt(s2Index) == s3.charAt(s1Index+s2Index)){
            result= isInterleaveMemo(s1, s2, s3, s1Index, s2Index+1, dp);
        }

        dp[s1Index][s2Index] = result;
        return result;

    }
    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";



        String s1 = "aa";
        String s2 = "ab";
        String s3 = "aaba";
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
//        System.out.println(interleavingString.isInterleave(s1, s2, s3));
        System.out.println(interleavingString.isInterleaveMemo(s1, s2, s3, 0,0, dp));

    }
}
