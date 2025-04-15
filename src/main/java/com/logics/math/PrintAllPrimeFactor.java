package com.logics.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 10/04/25 and 3:21 PM
 */
public class PrintAllPrimeFactor {

    public static void main(String[] args) {
        int n=36;
        List<Integer> res = new ArrayList<>();


        for(int i=2; i*i<n ; i++){
            if(n%i==0){
                res.add(i);
            }
            while(n%i==0){
                // divide number by 2 as many times as possible, so now number will not left
                // to be divisible by any further multiplayer of 2
                // this way we do not need to check for prime, same for 3, 5 and many upcoming numbers
                n = n/i;
            }
        }
        res.add(n);

        System.out.println(res);
    }
}
