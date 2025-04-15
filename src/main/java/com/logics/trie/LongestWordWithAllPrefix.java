package com.logics.trie;

/**
 * @author anju
 * @created on 15/04/25 and 4:25 PM
 */
public class LongestWordWithAllPrefix {

    /***
     * String[] input.
     * return longest string whose all prefix are present in input array.
     * [n, ni, nin, ninja, ninj, ninga]
     * Ans: ninja as all of its prefix exist in inout array and its longest in size
     */

    private static TrieNode insertIntoTrie(String[] input){
        TrieNode root  = new TrieNode();
        TrieNode currentRoot  = root;

        for(String word: input){
            currentRoot = root;
            // call trie insert or below implementations
                for(int i=0;i<word.length();i++){
                    if(currentRoot.node[word.charAt(i)-'a'] ==null){
                        currentRoot.node[word.charAt(i)-'a'] = new TrieNode();
                    }
                    currentRoot = currentRoot.node[word.charAt(i)-'a'];
                }
            currentRoot.isWord = true;
        }
        return root;
    }

    private static String findLongestWordWithAllPrefix(String[] input){
        String maxString = "";
        TrieNode root = insertIntoTrie(input);
        TrieNode currentRoot = root;

        for(String word : input){
            int i=0;
            if(word.length() < maxString.length())
            {
                continue;
            }

            if(root.checkIfAllPrefixExist(word)){
                if(maxString.length() == word.length() && maxString.compareTo(word)>0 )
                    maxString = word;
                else if(maxString.length() < word.length()){
                    maxString = word;
                }
            }
        }

        if(maxString.equals(""))
            return "None";

        return maxString;
    }



    public static void main(String[] args) {
        String[] input = new String[]{"n", "ni", "nin", "ninja", "ninj", "ninga"};

        System.out.println(findLongestWordWithAllPrefix(input));
    }


}
