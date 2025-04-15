package com.logics.trie;

/**
 * @author anju
 * @created on 15/04/25 and 6:12 PM
 */
public class CountDistinctSubString {
    /**
    Given string, count all distinct substring

     Brute force: find all substring O(n^2), and add it into set to have unique values log(m ->ttl element in set), then count
    Also we will need to store each unique substring to calculate count so space complexity =
    min substring = 1, max substring size = n, avg: n/2
     all distinct avg substring: n^2
     space : n^2 * n/2 = n^3 approax
     //So avoid using set and use @TODO TRIE,
     element count in trie + 1 (for empty string) will be total count of number of distint substring
     */



    public  static int count(String input){
        TrieNode root = new TrieNode();
        TrieNode currentRoot = root;
        int count=1;


        for(int i=0;i<input.length();i++){ // start with each char of a substring
            currentRoot = root;
            for(int j=i;j<input.length();j++){

                if(currentRoot.node[input.charAt(j)-'a'] == null){
                    currentRoot.node[input.charAt(j)-'a'] = new TrieNode();
                    count++;
                }
                currentRoot = currentRoot.node[input.charAt(j)-'a'];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("abab"));

    }



}
