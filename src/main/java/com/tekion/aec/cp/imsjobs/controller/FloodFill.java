package com.tekion.aec.cp.imsjobs.controller;

/**
 * @author anju
 * @created on 31/05/24 and 4:10 PM
 */
public class FloodFill {

    public static void fill(int[][] image, int sr1, int sc1, int old, int color) {
        if(sr1<0 || sr1>=image.length || sc1<0 || sc1>=image[0].length || image[sr1][sc1]!=old ){
            return;
        }
        image[sr1][sc1] = color;
        fill(image, sr1+1, sc1, old, color);
        fill(image, sr1-1, sc1, old, color);
        fill(image, sr1, sc1+1, old, color);
        fill(image, sr1, sc1-1, old, color);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        if(image[sr][sc] != color){
            fill(image, sr, sc, image[sr][sc], color);
//        }
        return image;
    }

    public static void main(String[] args) {
        int[][] mat = new int[2][];
        mat[0] = new int[]{0,1,1};
        mat[1] = new int[]{1,0,1};
//        mat[2] = new int[]{1,0,1};

        floodFill(mat, 0,0,0);
    }
}
