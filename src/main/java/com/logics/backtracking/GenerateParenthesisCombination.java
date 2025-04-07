package com.logics.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 28/01/25 and 4:52 PM
 */
public class GenerateParenthesisCombination {
/***
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisbacktrace(n, result, 0,0, new StringBuilder());
        return result;
    }


    public void  generateParenthesisbacktrace(int n, List<String> result, int currentOpen, int currentClose, StringBuilder builder) {
        if(currentOpen == n && currentClose == n)
        {
            result.add(builder.toString());
            return;
        }

        if(currentOpen<n){
            builder.append("(");
            generateParenthesisbacktrace(n, result, currentOpen+1, currentClose, builder);
            builder.deleteCharAt(builder.length()-1);
        }

        if(currentClose<currentOpen){
            builder.append(")");
            generateParenthesisbacktrace(n, result, currentOpen, currentClose+1, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesisCombination().generateParenthesis(3);
    }

}
