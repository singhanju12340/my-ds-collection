package com.logics.math;

/**
 * @author anju
 * @created on 10/04/25 and 10:23 PM
 */
public class SuperPow {
    /**
     * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
     *
     *
     *
     * Example 1:
     *
     * Input: a = 2, b = [3]
     * Output: 8
     * Example 2:
     *
     * Input: a = 2, b = [1,0]
     * Output: 1024
     * Example 3:
     *
     * Input: a = 1, b = [4,3,3,8,5,2]
     * Output: 1
     */

    public static int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;

        for(int i= b.length-1; i>=0; i-- ){
            res = (res * pow(a, b[i])) % MOD;
            a =  pow(a, 10);
        }
        return res;
    }


    public int pow(int a, int b){
        int res = 1;
        a = a % MOD; // needed for testcase a = 2147483647, b =[2,0,0]
        for(int i=0; i<b; i++ ){
            res = (res * a) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(15 % 6);
//        System.out.println(15 % 12);
//        System.out.println( ((5%12) * (3%12)) % 12);
//


//        System.out.println(15456 % 15);
//        System.out.println( ((7728%15) * (2%15)) % 15);

        System.out.println(15456 % 81);
        System.out.println( ((7728%81) * (2%81)) % 81);

//        System.out.println(new SuperPow().superPow(2, new int[]{1,0}));
//        System.out.println(new SuperPow().superPow(2147483647, new int[]{2,0,0}));



    }
}
