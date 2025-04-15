package com.logics.trie;

public class SearchWordDataStructure {
    TrieNode root;
    public SearchWordDataStructure() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currentRoot = this.root;

        for(int i=0;i<word.length();i++){
            Character currentChar = word.charAt(i);
            if(currentRoot.node[currentChar-'a']!=null)
            {
                currentRoot = currentRoot.node[currentChar-'a'];
            }else{
                currentRoot.node[currentChar-'a'] = new TrieNode();
                currentRoot = currentRoot.node[currentChar-'a'];

            }

        }
        currentRoot.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, this.root);
    }

    public boolean searchHelper(String word, int wordIndex, TrieNode root) {
        if(root == null)
                return false;
        if( wordIndex == word.length())
            return root.isWord;

        TrieNode currentRoot = root;
        Character currentChar = word.charAt(wordIndex);

        if(currentChar == '.'){
            for(int j=0;j<26;j++){
                if(searchHelper(word, wordIndex+1, currentRoot.node[j]))
                    return true;
            }
            return false;
        }else{
            if( currentRoot.node[currentChar-'a'] != null)
                return searchHelper(word, wordIndex+1, currentRoot.node[currentChar-'a']);
            else
                return false;
        }
//        return true;
    }

    public static void main(String[] args) {
        SearchWordDataStructure searchWordDataStructure = new SearchWordDataStructure();
        searchWordDataStructure.addWord("bad");
        searchWordDataStructure.addWord("dad");
        searchWordDataStructure.addWord("mad");
        searchWordDataStructure.search("pad");
        searchWordDataStructure.search("bad");
        System.out.println(searchWordDataStructure.search(".ad"));
        searchWordDataStructure.search("b..");
    }

}
