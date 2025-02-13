package com.logics.stringQuestions;

import java.util.Stack;

/**
 * @author anju
 * @created on 11/11/24 and 9:34 PM
 */
public class ValidParenthesis2 {
    public boolean checkValidString2(String s) {
        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                st1.add("(");
            else if(s.charAt(i) == '*'){
                st2.add("*");
            }
            else{
                if(!st1.isEmpty()){
                    st1.pop();
                }else if(!st2.isEmpty()){
                    st2.pop();
                }
            }
        }

        if(st1.isEmpty()  || !st1.isEmpty() && st1.size() == st2.size()){
            return true;
        }

        return false;
    }

    public boolean checkValidString(String s) {
        int leftMin=0;
        int leftMax=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '('){
                leftMin++;
                leftMax++;
            }
            else if(s.charAt(i) == '*'){
                leftMin = Math.max(0, leftMin-1);
                leftMax++;
            }
            else{
                leftMin--;
                leftMax--;
            }

            if(leftMax<0)
                return false;
        }

        if(leftMin == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new ValidParenthesis2().checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()");
    }
}
