package com.tekion.aec.cp.imsjobs.controller.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 04/09/24 and 8:28 PM
 */
public class NearestPoint {
    public static int[][] kClosestArraySort(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p->(p[0]*p[0])+(p[1]*p[1])));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static int[][] kClosest(int[][] points, int K) {
        if(K == points.length) return points;

        PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });

        for(int[] point: points) {
            pq.add(point);
            if(pq.size() > K) pq.poll();
        }
        return pq.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3}, {-2,2}, {3,4}};
        kClosest(points, 1);
    }


}
