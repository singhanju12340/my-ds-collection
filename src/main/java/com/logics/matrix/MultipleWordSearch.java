package com.logics.matrix;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anju
 * @created on 17/01/25 and 1:11 PM
 */
public class MultipleWordSearch {

    /**
     * Given an m x n board of characters and a list of strings words, return all words on the board.
     *
     * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
     *
     * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
     * Output: ["eat","oath"]
     *
     * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
     * Output: []
     * */


    // Algorithm
    // insert all element in tri for prefix matching
    // for each letter in a  board check if it is prefix in tri and backtrack till end of the word mark exist
    // else return if there is no char from the word matching as prefix in the tri

    private class TriNode{
        String word; // to result word at the end of traversal
        Map<Character,TriNode> childrens = new HashMap<>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        TriNode root = new TriNode();
        Set<String> result = new HashSet<>();

        // build trie
        root = buildTri( words);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                traverse(board, words, i, j, result, root);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    private TriNode buildTri(String[] words){
        TriNode root = new TriNode();
        for (String word: words) {
            TriNode wordNode = root;
            for(int i=0;i<word.length();i++){
                wordNode.childrens.putIfAbsent(word.charAt(i), new TriNode());
                wordNode =  wordNode.childrens.get(word.charAt(i));
            }
            wordNode.word = word;
        }
        return root;
    }



    public void traverse(char[][] board, String[] words, int row, int col, Set<String> result, TriNode currRoot) {

        if(row<0 || col<0 || row >= board.length || col >= board[0].length || !currRoot.childrens.containsKey(board[row][col])){
            return;
        }

        char currentChar = board[row][col];
        board[row][col] = '#'; // handle visited by assigning unmatching char

        TriNode childNode = currRoot.childrens.get(currentChar);


        if(childNode.word !=null){
            result.add(childNode.word);
        }


        traverse(board, words, row+1, col, result, childNode);
        traverse(board, words, row-1, col, result, childNode);
        traverse(board, words, row, col+1, result, childNode);
        traverse(board, words, row, col-1, result, childNode);

        board[row][col] = currentChar;

        // remove last char from tri as it is already processed and there is no child node further
        if(childNode.childrens.isEmpty()){
            currRoot.childrens.remove(currentChar);
        }


    }

    public static void main(String[] args) {
        MultipleWordSearch wordSearch = new MultipleWordSearch();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(wordSearch.findWords(board, words));
    }
}
