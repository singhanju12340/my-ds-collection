package com.logics.heapQuestions;

import java.util.*;

/**
 * @author anju
 * @created on 13/03/25 and 7:55 AM
 */
public class TopKFreqIntInArray {
    /***
     * Given an array arr[] and a positive integer k, the task is to find the k most frequently occurring elements from a given array.
     *
     * Note: If more than one element has same frequency then prioritise the larger element over the smaller one.
     *
     * Input: arr= [3, 1, 4, 4, 5, 2, 6, 1], k = 2
     * Output: [4, 1]
     * Explanation: Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum frequency and 4 is larger than 1.
     *
     *
     * Input: arr = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
     * Output: [5, 11, 7, 10]
     * Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is 2, frequency of 10 is 1. These four have the maximum frequency and 5 is largest among rest.
     */


    static class Compare implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {

            // Prioritise element's value in case their frequency was same
            if (p1[1] == p2[1])
                return Integer.compare(p2[0], p1[0]);

            // Sort on the basis of decreasing order
            // of frequencies
            return Integer.compare(p2[1], p1[1]);
        }
    }

    public static int[] findByMap(int[] input, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            freqMap.putIfAbsent(input[i], 0);
            freqMap.put(input[i], freqMap.get(input[i]) + 1);
        }

        // sort integer based on their freq in decending order
        ArrayList<int[]> freArr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> mapEntry : freqMap.entrySet()) {
            freArr.add(new int[]{mapEntry.getKey(), mapEntry.getValue()});
        }

        freArr.sort(new Compare());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = freArr.get(i)[0];
        }

        return result;

    }

    public static int[] findByHeap(int[] input, int k) { // change reverse
        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new CompareMinHeap());

        for (int i = 0; i < input.length; i++) {
            freqMap.putIfAbsent(input[i], 0);
            freqMap.put(input[i], freqMap.get(input[i]) + 1);
        }

        // insert in k size sorted heap based on condition

        for (Map.Entry<Integer, Integer> mapEntry : freqMap.entrySet()) {
            maxHeap.add(new int[]{mapEntry.getKey(), mapEntry.getValue()});
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[] result = new int[k];
        int i=0;
        while(!maxHeap.isEmpty()){
            result[i] = maxHeap.poll()[0];

        }
        return result;

    }

    static class Compare2 implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {

            // Prioritise element's value in case their frequency was same
            if (p1[0] == p2[0])
                return Integer.compare(p1[1], p2[1]);

            // Sort on the basis of increasing order
            // of frequencies (for min heap behavior)
            return Integer.compare(p1[0], p2[0]);
        }
    }

    static class CompareMinHeap implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {

            // Prioritise element's value in case their frequency was same
            if (p1[1] == p2[1])
                return Integer.compare(p2[0], p1[0]);


            // Sort on the basis of increasing order
            // of frequencies (for min heap behavior)
            return Integer.compare(p1[1], p2[1]);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        int[] res = findByHeap(arr, k);


        for (int val : res)
            System.out.print(val + " ");
    }


}
