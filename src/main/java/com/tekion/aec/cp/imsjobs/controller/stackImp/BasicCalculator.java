package com.tekion.aec.cp.imsjobs.controller.stackImp;

import java.util.Stack;

/**
 * @author anju
 * @created on 30/12/24 and 9:18 PM
 */
public class BasicCalculator {
/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * */


    public static int calculate(String s){

        char[] input = new char[s.length()];
        Stack<Integer> st = new Stack<>();
        int oneNum =0;

        for(int i=0; i< input.length;i++){

            if(input[i] == ' ')
                continue;



            if(Character.isDigit(input[i])){
                // convert into single number
                int current = input[i]-'0';
                while( i< input.length && Character.isDigit(input[i])){
                    oneNum = (oneNum *10) + current;
                    i++;
                }
                i--;

            }
            else if(input[i] == '('){
                int count = 0;

                int startOpen = i;
                for(startOpen = i; startOpen<input.length;startOpen++){
                    if(input[startOpen] == '(') count++;
                    if(input[startOpen] == ')') count--;
                    if(count==0)
                        break;
                }
                // cal recursion for substring
                calculate(s.substring(i+1, startOpen));
            }


            // evaluation if its digit
            if(input[i] == '+'){
                st.push(oneNum);
            }else if(input[i] == '-'){
                st.push(-oneNum);
            }else if(input[i] == '*'){
                st.push(st.pop() * oneNum);
            }else if(input[i] == '/'){
                st.push(st.pop() / oneNum);
            }

            oneNum = 0;
        }


        int result =0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }



    public static void main(String[] args) {
        calculate("1+1");
    }

// only for + and -
    public static int calculate2(String s) {
        int result = 0;
        int num=0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i< s.length();i++){
            char current = s.charAt(i);
            if(Character.isDigit(current)){
                num = num * 10 + current-'0';
            }
            else if(current == '+'){
                result = result + (sign * num);
                sign = 1;
                num=0;
            }
            else if(current == '-'){
                result = result + (sign * num);
                sign = -1;
                num=0;
            }
            else if(current == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign=1;
            }
            else if(current == ')'){
                result = result + (sign * num);
                result = result * st.pop(); // multiple with the saved sign
                result = result + st.pop(); // eval with existing old calculated value
                num =0;
            }
        }

        return result;
    }
}
