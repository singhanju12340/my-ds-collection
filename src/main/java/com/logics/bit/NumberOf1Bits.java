package com.logics.bit;

/**
 * @author anju
 * @created on 28/01/25 and 12:17 PM
 */
public class NumberOf1Bits {

    /***
     * Given a positive integer n, write a function that returns the number of
     * set bits
     *  in its binary representation (also known as the Hamming weight).
     *  Example 1:
     *
     * Input: n = 11
     *
     * Output: 3
     *
     * Explanation:
     *
     * The input binary string 1011 has a total of three set bits.
     *
     * Example 2:
     *
     * Input: n = 128
     *
     * Output: 1
     *
     * Explanation:
     *
     * The input binary string 10000000 has a total of one set bit.
     *
     * Example 3:
     *
     * Input: n = 2147483645
     *
     * Output: 30
     *
     * Explanation:
     *
     * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
     */


    // built in java support
    int hammingWeight2(int n) {
        //
        return Integer.bitCount(n);
    }


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {

            String x = Integer.toBinaryString(n);

            String y = Integer.toBinaryString(n-1);
            n &= (n - 1); // drops the rightmost set bit
            count++;
        }
        return count;
    }


    //Bit Shift Approach
    int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // n and 1, if last is 1, count will increment by 1. if number and 1 last gigit is 0. count will increment by 0
            n >>>= 1; // use >>> for logical (zero-fill) right shift if dealing with signed int
        }
        return count;
    }


    public static void main(String[] args) {
        //
        new NumberOf1Bits().hammingWeight(11);
    }


}
