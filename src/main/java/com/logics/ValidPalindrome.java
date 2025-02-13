package com.logics;

import static java.lang.Character.isLetterOrDigit;

/**
 * @author anju
 * @created on 30/05/24 and 4:25 PM
 */
public class ValidPalindrome {

    private static boolean isAlphaNumeric(char b){
        int a = b-'0';
        if(a <=127 && a>=0)
            return true;
        return false;
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){

            if( !isLetterOrDigit(s.charAt(i)))
                i++;
            else if(!isLetterOrDigit(s.charAt(j)))
                j--;
            else if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

}
