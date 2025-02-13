package com.tekion.aec.cp.imsjobs.controller;

/**
 * @author anju
 * @created on 03/06/24 and 7:01 PM
 */
public class MinClimbingCost {

    private static int solve(int[] num){
        int prev1 = num[0];
        int prev2 = num[1];
        for(int i=2; i<num.length;i++){
            int curr = num[i] + Math.min(num[i-1], num[i-2]);
            prev1 = prev2;
            prev2 = curr;
        }

        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,100,1,1,1,100,1,1,100,1};
        int res = solve(num);
    }
}
