package com.tekion.aec.cp.imsjobs.controller.dpSubsequence;

/**
 * @author anju
 * @created on 23/08/24 and 2:51 PM
 */
public class MovieRatingSubsequence {
    static int fun(int[] ratings, int index){
        if(index == 0){
            return ratings[0];
        }

        if(index < 0){
            return 0;
        }

        int notPick = 0 + fun(ratings,index-1);
        int pick = ratings[index] + fun(ratings,index-2);
        return Math.max(pick,notPick);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, -1, -3, 4, 5};
        System.out.println(fun(arr, arr.length-1));
    }
}
