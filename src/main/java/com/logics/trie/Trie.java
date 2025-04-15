package com.logics.trie;

/**
 * @author anju
 * @created on 10/09/24 and 6:22 PM
 */
public class Trie {

    /**
     * where each node represents a single character of a string
     * A Trie node contains:
     * An array or map for its child nodes (one for each possible character).
     * A flag (isEnd or flag) indicating if the node marks the end of a valid word.
     *
     *
     * Use Cases of a Trie
     * Autocomplete Systems:
     *
     * Suggest words based on prefixes entered by a user.
     * Spell Checking:
     *
     * Check if a word exists in a dictionary or is misspelled.
     * Search by Prefix:
     *
     * Find all words that start with a given prefix.
     * Dictionary Implementation:
     *
     * Store and search words efficiently.
     * Word Games:
     *
     * Solve word search puzzles or play games like Scrabble.
     * IP Routing:
     *
     * Store routing prefixes in network routing systems.
     *
     * */


    public Trie[] trie;
    public boolean flag;

    public Trie() {
        trie = new Trie[26];
        flag = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.trie[index] == null){
                Trie newT = new Trie();
                node.trie[index] = newT;
            }
            node = node.trie[index];
        }
        node.flag = true;
    }

    public boolean search(String word) {
        Trie node = this;
        if(node == null)
            return false;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.trie[index] == null)
                return false;
            node = node.trie[index];
        }

        return node.flag;

    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        if(node == null)
            return false;

        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(node.trie[index] == null)
                return false;
            node = node.trie[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie1 = new Trie();
        trie1.insert("apple");

        trie1.insert("cat");
        trie1.insert("car");
        trie1.insert("dog");

        // Search words
        System.out.println(trie1.search("cat")); // Output: true
        System.out.println(trie1.search("cap")); // Output: false

        // Check prefixes
        System.out.println(trie1.startsWith("ca")); // Output: true
        System.out.println(trie1.startsWith("do")); // Output: true
        System.out.println(trie1.startsWith("bat")); // Output: false
    }


}
