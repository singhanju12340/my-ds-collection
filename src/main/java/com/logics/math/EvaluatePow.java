package com.logics.math;

/**
 * @author anju
 * @created on 10/04/25 and 12:38 PM
 */
public class EvaluatePow {

    //O(n)
    public static long modPow1(long x, long n) {
        long result = 1;
        while (n > 0) {
           result = result * x;
           n--;
        }

        return result;
    }

    //O(log2 n)
    public static double modPow(long x, long n) {
        double initialN = n;
        double result = 1;
        n = Math.abs(n);
        if(n<0){

        }

        while (n > 0) {
            // if n is odd, multiply result by current x
            if(n%2 == 1) {
                n = n-1; // odd number
                result  = result * x;
            }else{
                x = ( x*x ); // even number
                n = n/2;
            }
        }

        if(initialN<0){
            return 1/result;
        }

        return result;
    }

    //O(log2 n)
    public static double modPow2(long x, long n) {
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
                result  = result * x;
            }else{
                x = ( x*x ); // even number
                n = n/2;
            }
        }


        return result;
    }

    // corner case 2, -2147483648
    static double  myPow3(double x, int nInput) {
        long n = nInput;
        double result = 1;
//        n = Math.abs(n);
        if(n<0){
            n=-n;
            x = 1/x;
        }

        while (n > 0) {
            // if n is odd, multiply result by current x
            if((n & 1) == 1) {
                n = n-1; // odd number
                result  = result * x;
            }else{
                x = ( x*x ); // even number
                n = n/2; // n>>1;
            }
        }
        return result;
    }

    public double myPowRec(double x, int n) {
        if (n == 0)
            return 1.0;

        if ((n & 1) == 1)
            return x * myPowRec(x, n - 1);

        if (n % 2 == 0)
            return myPowRec(x * x, n / 2);

        return 1 / myPowRec(x, -n);
    }

    public static void main(String[] args) {
        // Example usages:
//        System.out.println(modPow(2, -1));
        System.out.println(myPow3(2, -2147483648));

//        System.out.println(modPow(2, 10)); // prints 24  (1024 % 1000)
//        System.out.println(modPow(3, 0));     // prints 1   (3^0 % 7)
//        System.out.println(modPow(10, 9));    // prints 4   (10^9 % 6)
    }
}
