package com.logics.math;

/**
 * @author anju
 * @created on 10/04/25 and 1:50 PM
 */
public class EvalPowDivisor {
    //O(log2 n)
    public static double modPow2(long x, long n, long d) {
        double initialN = n;
        double result = 1;
        n = Math.abs(n);
        if(n<0){
            n=-n;
            x = 1/x;
        }

        while (n > 0) {
            // if n is odd, multiply result by current x
            if(n%2 == 1) {
                n = n-1; // odd number
                result  = (result * x)%d;
            }else{
                x = ( x*x ) % d; // even number
                n = n/2;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(modPow2(5, 2, 6));

    }
}
