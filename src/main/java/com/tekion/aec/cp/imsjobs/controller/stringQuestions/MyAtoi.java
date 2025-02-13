package com.tekion.aec.cp.imsjobs.controller.stringQuestions;

/**
 * @author anju
 * @created on 04/11/24 and 4:15 PM
 */
public class MyAtoi {
    public int myAtoi(String s) {
        int start = 0;
        int sign = 1;

        while(start < s.length()){
            if( s.charAt(start) == ' ' ){
                start++;
            }else
                break;
        }

        if(start < s.length() && s.charAt(start) == '-'){
            sign = -1;
            start++;
        }else if(start < s.length() && s.charAt(start) == '+'){
            start++;
        }

        int num = 0;

        while(start < s.length()){
            if( s.charAt(start) == '0'){
                start++;
            }else if(s.charAt(start) == ' ')
                return num;
            else
                break;
        }



        for(int i = start ; i<s.length() ;i++){
            if( s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <= 9){

                if(  num  > ( Integer.MAX_VALUE - (s.charAt(i) - '0') )/10){
                    if(sign == -1)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                num = s.charAt(i) - '0' + num * 10 ;

            }
            else
                break;
        }


        while(start<s.length() && s.charAt(start)>='0' && s.charAt(start)<='9')
        {
            int digit = s.charAt(start) - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            start++;
        }
        return num*sign;

    }
    public static void main(String[] args) {
        new MyAtoi().myAtoi("2147483646");
    }
}
