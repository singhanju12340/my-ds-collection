package com.tekion.aec.cp.imsjobs.controller.monotonicStack;

/**
 * @author anju
 * @created on 25/12/24 and 12:01 AM
 */
public class NextGreaterEle3 {
    /**
     * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
     *
     * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 12
     * Output: 21
     * Example 2:
     *
     * Input: n = 21
     * Output: -1
     *
     * Input: n = 11
     * Output: -1
     *
     * Input: n = 230241
     *      * Output: 230412
     * **/

    public static int nextGreaterElement(int n) {
        char[] num = Integer.toString(n).toCharArray();
        int i=num.length-1;
        int l = i;

        if(num.length == 1)
                return -1;
        int pivot = Integer.MAX_VALUE;

        while( i != 0 ){
            if( num[i-1] >= num[i] ){
                i--;
            }else{
                pivot = i-1;
                break;
            }
        }

        if(pivot == Integer.MAX_VALUE)
            return -1;

        int lastJ = num.length-1;
        // find least  element in array greater than pivot
        while(pivot < lastJ && num[pivot] >= num[lastJ]){
            lastJ--;
        }

        char sw  = num[lastJ];
        num[lastJ] = num[i-1];
        num[i-1] = sw;

        while(pivot+1 < l){
            char sw1 = num[l];
            num[l] = num[pivot+1];
            num[pivot+1] = sw1;
            pivot++;
            l--;
        }


        // swap from i to n
        String num1= new String(num);
        long res = Long.valueOf(num1);
        return res>Integer.MAX_VALUE ? -1 : (int) res;

    }

    public static void main(String[] args) {
        nextGreaterElement(2147483476);
    }
}
