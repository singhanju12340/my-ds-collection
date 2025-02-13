package com.logics.graph.BFS;

import java.util.*;

/**
 * @author anju
 * @created on 30/12/24 and 4:44 PM
 */
public class WordLadder {



    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();

        if(!wordList.contains(endWord)){
            return 0;
        }

        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0; j<size; j++)
            {
                char[] current = queue.poll().toCharArray();
                for(int i=current.length-1;i>=0;i--){
                    char originalChar = current[i];
                    for(char c = 'a'; c<='z';c++){
                        if(current[i] == c) continue;
                        current[i] = c;
                        String newWord = new String(current);

                        if(newWord.equals(endWord)){
                            return length+1;
                        }

                        if(wordList.contains(newWord) && !visited.contains(newWord))
                        {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                        current[i] = originalChar;

                    }

                }
            }
            length++;
        }

        System.out.println(length);
        return 0;
    }



    public int ladderLength(String beginWord, String endWord, List<String> wordSet){
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                String currentWord = queue.poll();
                Set<String> nextWords = nextWord(currentWord, wordSet);
                if (currentWord.equals(endWord)) {
                    return distance;
                }
                for (String nextWord: nextWords) {
                    queue.offer(nextWord);
                    wordSet.remove(nextWord);
                }
            }
            distance++;
        }
        return 0;
    }



    private  Set<String> nextWord(String src, List<String> wordSet){
        char [] beginWord = src.toCharArray();
        Set<String> nextWords = new HashSet<>();
        for (int i = 0;i < beginWord.length;i++) {
            char temp = beginWord[i];
            for (int j = 1;j < 26;j++) {
                beginWord[i]++;
                if (beginWord[i] > 'z') {
                    beginWord[i] -= 26;
                }
                String newWord = new String(beginWord);
                if (wordSet.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
            beginWord[i] = temp;
        }
        return nextWords;
    }



}



