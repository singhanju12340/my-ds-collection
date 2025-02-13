package com.logics.arrays;

/**
 * @author anju
 * @created on 29/11/24 and 1:34 PM
 */
public class MaximumMultiplSubArray {
/**
 * 152. Maximum Product Subarray
 *
 * Given an array ‘Arr’ that has ‘N’ elements. You have to find the subarray of ‘Arr’ that has the largest product.
 * You must return the product of the subarray with the maximum product.
 *
 * For example:
 *
 * {2, 3, 4, 5}
 *
 * When ‘N’ = 5, and ‘Arr’ = {-2, 3, -4, 0}
 * The subarrays of ‘Arr’ are:
 * {-2}, {-2, 3}, {-2, 3, -4}, {-2, 3, -4, 0}, {3}, {3, -4}, {3, -4, 0}, {-4}, {-4, 0}, {0}.
 * Among these, {-2, 3, -4} is the subarray having the maximum product equal to 24.
 * Hence, the answer is 24.
 *
 *
 * 1 -2 3 -4
 * Sample Output 1:
 * 24
 * Explanation Of Sample Input 1:
 * Given, ‘Arr’ = {1, -2, 3, -4}. The subarrays of ‘Arr’ are:
 * {{1}, {1, -2}, {1, -2, 3}, {1, -2, 3, -4}, {-2}, {-2, 3}, {-2, 3, -4}, {3}, {3, -4}, {-4}}.
 * Among these subarrays, {1, -2, 3, -4} and {-2, 3, -4} have the maximum product, equal to 24.
 * Hence, the answer is 24.
 *
 *
 * {-2,-3,-4,5}
 * */


/**
 * word conversion: dp
 * */


        // O(n^2) solution
    public static int subarrayWithMaxProduct(int []arr){
        // Write your code here.
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            int prod = 1;
            for(int j = i; j<=i; j++){
                prod = prod * arr[j];
            }
            max = Math.max(max, prod);
        }
        System.out.println(max);
        return max;
    }

    // O(n) solution
    public static int subarrayWithMaxProduct2(int []arr){
        // Write your code here.
        // Write your code here.
        int max = Integer.MIN_VALUE;
        int suff = 1;
        int pref = 1;

        for(int i=0;i<arr.length;i++){
            if(suff == 0) suff = 1;
            if(pref == 0) pref = 1;
            {
                pref = pref * arr[i];
                suff = suff * arr[arr.length-i-1];
            }

            max = Math.max(max,Math.max(suff, pref));
        }
        return max;
    }



    public static void main(String[] args) {
        subarrayWithMaxProduct2(new int[]{-2,0,-1});
//        maxProduct(new int[]{0, 2});
    }

}
