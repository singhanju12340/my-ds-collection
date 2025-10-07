package com.logics;

import java.util.Arrays;

/**
 * @author anju
 * @created on 16/01/25 and 7:29 PM
 */
public class TaskScheduler {
    /**
     * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n.
     * Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order,
     * but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
     *
     * Return the minimum number of CPU intervals required to complete all tasks.
     *
     * */

    public static int leastInterval(char[] tasks, int n) {
        // ex : A, A , A , B, B, n=2
        // find frequency for each char
        int[] freq = new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }

        Arrays.sort(freq);

        // count most frequent char count
        int maxFreq = freq[25]; // these many task will be places after handling slots
        int maxFreqCount = 1; // needed to add extra interval after handling empty slots
        for (int i = 24; i >= 0 && freq[i] == maxFreq; i--) {
            maxFreqCount++;
        }

        int slotWithoutLastInterval = (maxFreq-1); // A _ _ | A _ _ |
        int minIntervalToPlaceNextSameTask = n+1; // if n=2, next A will be places at  3rd index, after placeing previous A

        int totalSlotForMostFreq = slotWithoutLastInterval * minIntervalToPlaceNextSameTask; // A _ _ | A _ _

        int calculatedSlot = totalSlotForMostFreq + maxFreqCount;//(A _ _ | A _ _ |AB)

        return Math.max(tasks.length, calculatedSlot); // max of calculated slots, total task

        //

    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

}
