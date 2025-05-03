package com.logics.arrays.slidingWindow;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author anju
 * @created on 27/04/25 and 12:57 PM
 */
public class SlidingWindMax {
    //time complexity = O(Nlog(k)), gave timeout need solution in O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] result = new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()==k){
                result[j++] = queue.peek();
                queue.remove(nums[i-(k-1)]);
            }
        }
        return result;
    }


    public int[] maxSlidingWindowDequeue(int[] nums, int k) {
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        int[] result = new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()<= i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            if(i>=(k-1))
                result[i-(k-1)] = nums[deque.peekFirst()];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new SlidingWindMax().maxSlidingWindowDequeue(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

}
