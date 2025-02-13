package com.tekion.aec.cp.imsjobs.controller;

/**
 * @author anju
 * @created on 03/06/24 and 8:26 PM
 */
public class LongestPalindrom {
    public static int longestPalindrome(String s) {
        int[] charArray = new int[52];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<=90 && s.charAt(i)>=65){
                charArray[s.charAt(i)-'A'] ++;
            }else if(s.charAt(i)>=97 && s.charAt(i)<=122){
                charArray[s.charAt(i)-'a'] ++;
            }
        }
        int res = 0;
        boolean isOdd = false;
        for(int i=0;i<52;i++){
            if(charArray[i]%2==0)
                res+=charArray[i];
            else{
                res+=charArray[i]-1;
                isOdd = true;
            }
        }

        if(isOdd)
            res++;

        return res;
    }
    public static void main(String[] args) {
        longestPalindrome("aaaAaaaa");
    }
}
