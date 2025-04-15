package com.logics.trie;

/**
 * @author anju
 * @created on 15/04/25 and 10:43 AM
 */


class TrieNode {
    TrieNode[] node;
    boolean isWord;

    TrieNode() {
        node = new TrieNode[26];
    }

    public void insert(String word){
        TrieNode currentRoot = this;
        for(int i=0;i<word.length();i++){
            if(currentRoot.node[word.charAt(i)-'a'] ==null){
                currentRoot.node[word.charAt(i)-'a'] = new TrieNode();
            }
            currentRoot = currentRoot.node[word.charAt(i)-'a'];
        }
        currentRoot.isWord = true;
    }

    public boolean checkIfAllPrefixExist(String word){
        TrieNode currentRoot = this;
        int i=0;

        while(i<word.length()){
            if(currentRoot.node[word.charAt(i)-'a']!=null && currentRoot.node[word.charAt(i)-'a'].isWord){
                currentRoot = currentRoot.node[word.charAt(i)-'a'];
                i++;
            }else{
                return false;
            }
        }
        return true;
    }

}
