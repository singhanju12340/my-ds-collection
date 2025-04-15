package com.logics.geometry;

import java.util.HashSet;
import java.util.Set;

/**
 * @author anju
 * @created on 08/04/25 and 1:44 PM
 */
public class CountLatticePointOfCircle {
/***
 * Given a 2D integer array circles where circles[i] = [xi, yi, ri] represents the center (xi, yi) and radius ri of the ith circle drawn on a grid, return the number of lattice points that are present inside at least one circle.
 *
 * Note:
 *
 * A lattice point is a point with integer coordinates.
 * Points that lie on the circumference of a circle are also considered to be inside it.
 *
 */

    public static int countLatticePoints(int[][] circles) {
        Set<String> internalLatticePoint = new HashSet<String>();
        for(int p=0;p<circles.length;p++){
            int[] currentCircle = circles[p];
            int x = currentCircle[0]; // x
            int y = currentCircle[1]; // y
            int r = currentCircle[2]; // radius

            // maximum boundry of lattic point of a circle is
            // (x+r,y+r), (x-r, y-r), (x+r, y-r), (x-r, y+r)

            for(int i=x-r; i<=x+r; i++){ // get all points within lattic point and add it in set.
                for(int j=y-r; j<=y+r; j++){
                    if( ((x-i)*(x-i) + (y-j)*(y-j)) <= (r*r) ){
                        internalLatticePoint.add(i+","+j);
                    }
                }
            }
        }
        return internalLatticePoint.size();
    }

    public static void main(String[] args) {
        System.out.println(countLatticePoints(new int[][]{{2,2,1}}));
    }

}
