package com.logics.heapQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 02/01/25 and 8:30 PM
 */
public class MedianFinder {

    PriorityQueue<Integer> halfMin ;
    PriorityQueue<Integer> halfMax ;


    public MedianFinder() {
        halfMin =  new PriorityQueue<>(Comparator.reverseOrder()); // max heap
        halfMax = new PriorityQueue<>(); // min heap

    }



    public void addNum2(int num) {
        // first add num to max heap, so that max heap balances the order of half min values and keep max value as root i
        halfMin.add(num);

        // pop the sorted max value and add it in the min heap, to add it as min in later max half portion
        halfMax.add(halfMin.remove());

        // balance halfMin and halfMax as size of halfMin should always be halfMax.size +1

        if(halfMin.size() < halfMax.size())
                halfMin.add(halfMax.remove());
    }

    public void addNum(int num) {
        // add num ot max heap, if it is smaller than max heap top
        if( halfMin.isEmpty() || halfMin.peek() >= num){
            halfMin.add(num);
        }else{ // add in min heap
            halfMax.add(num);
        }

        // balance halfMin and halfMax as size of halfMin should always be halfMax.size +1

        if(halfMin.size() > halfMax.size()+1){
            halfMax.add(halfMin.remove());
        }else if(halfMin.size() < halfMax.size()){
            halfMin.add(halfMax.remove());
        }
    }





    public double findMedian() {
        if(halfMin.size() > halfMax.size()){
            return halfMin.peek();
        }else{
            return (double) (halfMin.peek() + halfMax.peek() )/2;
        }
    }

    public static void main(String[] args) {
//        MedianFinder mf = new MedianFinder();
//        mf.addNum(6);
//        mf.addNum(10);
//        mf.addNum(2);
//        mf.findMedian();
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());

    }
}
