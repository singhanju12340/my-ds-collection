package com.logics.graph.BFS;

import java.util.*;

/**
 * @author anju
 * @created on 18/03/25 and 4:23 PM
 */
public class WordLadder2 {
    /**
     * A transformation sequence from word beginWord to word endWord
     * using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
     *
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList,
     * return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
     * Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
     */

    public static void main(String[] args) {

    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordList.contains(endWord))
            return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> resultMap = new HashMap<>(); // adjecency list
        Map<String, Integer> distance = new HashMap<>(); // adjecency list

        queue.add(beginWord);
        distance.put(beginWord, 0);

        int height = 0;

        while(!queue.isEmpty()){
            int childSize = queue.size();

            while(childSize != 0){ // not needed as we are maintaining distance map

                String currentNode = queue.poll();
                if(currentNode.equals(endWord)){
                    height = distance.get(currentNode); //final resut if only steps is needed
                }

                int currentDis = distance.get(currentNode);

                List<String> neighbours = getNeighbours(wordSet, currentNode);

                for(String neighbour : neighbours){

                    distance.put(neighbour, currentDis+1);
                    queue.add(neighbour);
                    wordSet.remove(neighbour);

                }
                resultMap.put(currentNode, neighbours);
                childSize--;
            }
        }


        List<String> result = new ArrayList<>();

        result.add(beginWord);
        for (Map.Entry map:resultMap.entrySet()) {

        }

        return null;
    }


    List<String> getNeighbours(Set<String> words, String currentNode){
        char[] newChar = currentNode.toCharArray();
        List<String> neighbours = new ArrayList<>();
        for(int i=0;i<currentNode.length();i++){
            // for each char in string, replace it with chars from 0 to 26
            for(int j = 'a';i<='z';j++){
                newChar[i] = (char) j;
                String newWord = new String(newChar);
                if(words.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
}
