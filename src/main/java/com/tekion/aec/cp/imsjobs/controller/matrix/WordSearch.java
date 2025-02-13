package com.tekion.aec.cp.imsjobs.controller.matrix;

/**
 * @author anju
 * @created on 16/01/25 and 10:07 PM
 */


public class WordSearch {
    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * Output: true
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * Output: false
     * **/

    public boolean exist(char[][] board, String word) {
        // traverse for each matrix[row][col] considering any cell as starting of the word
        boolean result;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
//                result = checkIn4Direction(board, word, i,j, 0);
//                if(result == true)
//                    return true;

                if(board[i][j] == word.charAt(0) && checkIn4Direction(board, word, i,j, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean checkIn4Direction(char[][] board, String word, int row, int col, int index) {

        if(index == word.length()){
            return true;
        }

//        if(word.charAt(index) != board[row][col]){
//            return false;
//        }

        if(row>=board.length || row < 0|| col>=board[0].length || col <0 || board[row][col] != word.charAt(index)){
            return false;
        }



        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = checkIn4Direction(board, word, row+1,col, index+1)||
                checkIn4Direction(board, word, row-1,col, index+1)||
                checkIn4Direction(board, word, row,col+1, index+1)||
                checkIn4Direction(board, word, row,col-1, index+1);

        board[row][col] = temp;

        return found;

    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(wordSearch.exist(board, "SEE"));
    }


}
