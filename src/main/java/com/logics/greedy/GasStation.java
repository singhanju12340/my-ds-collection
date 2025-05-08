package com.logics.greedy;

/**
 * @author anju
 * @created on 06/05/25 and 11:07 PM
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int currentFuel = 0;
            if( gas[i]<cost[i])
                continue;

            int next = i;
            int j=1;
            while(j<=gas.length && currentFuel>=0){

                currentFuel = currentFuel+gas[next]-cost[next];
                next++;
                if(next==gas.length){
                    next-=gas.length; // move to smaller indexes
                }
                j++;
            }
            if(currentFuel>=0)
                return i;
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        // there is a soultion present find starting point
        int currentFuel = 0;
        int start = 0;

        for(int i=0;i<gas.length;i++){
            currentFuel = currentFuel+ gas[i]-cost[i];
            if(currentFuel<0){
                currentFuel=0;
                start = i+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3} ));
    }
}
