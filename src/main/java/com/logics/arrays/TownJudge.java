package com.logics.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author anju
 * @created on 28/04/25 and 5:17 PM
 */
public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0;i<trust.length;i++){
            int p = trust[i][0];
            int pTrust = trust[i][1];
            map.computeIfAbsent(pTrust, k -> new HashSet<>()).add(p);
            people[p-1] = 1;
        }

        for( Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){

            if(entry.getValue().size() == n-1 && people[entry.getKey()-1]==0)
                return entry.getKey();
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new TownJudge().findJudge(2, new int[][]{
                {1,2}
        }));
    }
}
