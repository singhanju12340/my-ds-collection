package com.tekion.aec.cp.imsjobs.controller.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 28/01/25 and 11:27 AM
 */
public class LetterCombOfPhoneNo {

    /***
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     *
     * Constraints:
     *
     * 0 <= digits.length <= 4
     * digits[i] is a digit in the range ['2', '9'].
     */

    private static final Map<Character, String> PHONE_MAP = new HashMap<>();
    static {
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() ==0){
            return result;
        }
        backtrack(0, new StringBuilder(), digits, result);
        return result;
    }

    public void backtrack(int index, StringBuilder builder,String digits,  List<String> result){
            if(index == digits.length()){
                result.add(builder.toString());
                return;
            }

         String currentString = PHONE_MAP.get(digits.charAt(index));

        for (int i=0;i<currentString.length();i++) {
            char currChar = currentString.charAt(i);
            builder.append(currChar);
            backtrack(index+1, builder, digits, result);
            builder.deleteCharAt(builder.length()-1);
        }
    }


    public static void main(String[] args) {
        new LetterCombOfPhoneNo().letterCombinations("29");
    }
}
