package com.logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anju
 * @created on 05/11/24 and 11:47 PM
 */
public class Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int imin = 0;
        int imax = matrix.length-1;
        int jmin = 0;
        int jmax = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;
        while(imin <= imax && jmin <= jmax){

            while( j<=jmax && imin <= imax && jmin <= jmax){
                res.add(matrix[imin][j]);
                j++;
            }
            imin++;
            i = imin;

            while( i<=imax && imin <= imax && jmin <= jmax) {
                res.add(matrix[i][jmax]);
                i++;
            }
            jmax--;
            j = jmax;

            while( j >= jmin && imin <= imax && jmin <= jmax){
                res.add(matrix[imax][j]);
                j--;
            }
            imax--;
            i = imax;

            while( i >= imin && imin <= imax && jmin <= jmax){
                res.add(matrix[i][jmin]);
                i--;
            }
            jmin++;
            j=jmin;

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        System.out.println(Arrays.asList(new Matrix().spiralOrder(matrix)));
    }

}
