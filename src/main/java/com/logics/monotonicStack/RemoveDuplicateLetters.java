package com.logics.monotonicStack;

import java.util.Stack;

/**
 * @author anju
 * @created on 30/12/24 and 11:48 AM
 */
public class RemoveDuplicateLetters {

    /**
     * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
     * the smallest in lexicographical order
     *  among all possible results.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "bcabc"
     * Output: "abc"
     * Example 2:
     *
     * Input: s = "cbacdcbc"
     * Output: "acdb"
     *
     * 1 <= s.length <= 104
     * s consists of lowercase English letters.
     * */


    public static String removeDuplicateLetters(String s) {
        char[] input = s.toCharArray();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();

        // add fre for each char in the string
        for(char c: input){
            freq[c-'a']++;
        }

        for(char c: input){

            int index = c-'a';
            freq[index]--;

            // if char is already present in stack ignore
            if(visited[index]) continue;

            while(!st.isEmpty() && st.peek() > c && freq[ st.peek()-'a'] > 0){
                char pop = st.pop();
                visited[pop-'a'] = false;
            }
            st.push(c);
            visited[index]=true;
        }

        StringBuilder stb = new StringBuilder();
        for(char c: st){
            stb.append(c);
        }
        System.out.println(stb.toString());
        return stb.toString();
    }

    public static void main(String[] args) {
        removeDuplicateLetters("cbacdcbc");
    }
}
