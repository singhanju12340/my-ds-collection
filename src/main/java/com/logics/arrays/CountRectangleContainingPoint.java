package com.logics.arrays;

import java.util.*;

/**
 * @author anju
 * @created on 08/04/25 and 7:48 PM
 */
public class CountRectangleContainingPoint {
    /***
     *
     * You are given a 2D integer array rectangles where rectangles[i] = [li, hi] indicates that ith rectangle has a length of li and a height of hi. You are also given a 2D integer array points where points[j] = [xj, yj] is a point with coordinates (xj, yj).
     *
     * The ith rectangle has its bottom-left corner point at the coordinates (0, 0) and its top-right corner point at (li, hi).
     *
     * Return an integer array count of length points.length where count[j] is the number of rectangles that contain the jth point.
     *
     * The ith rectangle contains the jth point if 0 <= xj <= li and 0 <= yj <= hi. Note that points that lie on the edges of a rectangle are also considered to be contained by that rectangle.
     *
     * Input: rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]
     * Output: [2,1]
     * Explanation:
     * The first rectangle contains no points.
     * The second rectangle contains only the point (2, 1).
     * The third rectangle contains the points (2, 1) and (1, 4).
     * The number of rectangles that contain the point (2, 1) is 2.
     * The number of rectangles that contain the point (1, 4) is 1.
     * Therefore, we return [2, 1].
     */

    public static int[] countRectangles(int[][] rectangles, int[][] points) {
// group by y, as 1 <= y <= 100
        int limit = 101;
        List<Integer>[] heightGroup = new List[limit];

        for (int i = 0; i < heightGroup.length; i++)
            heightGroup[i] = new ArrayList<Integer>();

        // create height group
        for (int[] rect : rectangles) {
            heightGroup[rect[1]].add(rect[0]);
        }

        // sort all x cordinates of each heigh present in group
        for(List<Integer> arrr : heightGroup){
            Collections.sort(arrr);
        }

        int[] res = new int[points.length];
        for (int p=0;p<points.length;p++) {

            int pointX = points[p][0];
            int pointY = points[p][1];

            int count=0;
            for(int py=pointY; py<101;py++){
                List<Integer> xCordinates = heightGroup[py];
                int index = bSearch(xCordinates, pointX); // find index of current point x cordinate of point height
                count += xCordinates.size() - index;
            }
            res[p]= count;
        }

        return res;
    }

   static int bSearch(List<Integer> list, int n) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (n > list.get(mid))
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        countRectangles(new int[][]{{1,2}, {2,3}, {2,5}}, new int[][]{{2,1}, {1,4}});
//        countRectangles(new int[][]{{1,1}, {2,2}, {3,3}}, new int[][]{{1,3}, {1,1}});

    }
}
