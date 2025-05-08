package com.logics.arrays.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 07/05/25 and 8:00 PM
 */
public class FindLongestEqualSubarray {
    class Node{
        int count;
        int kCount;
        Node(int count, int kcount){
            this.count = count;
            this.kCount = kcount;
        }
    }
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Node[] dp = new Node[nums.size()];
        int max =1;
        for(int i=0;i<nums.size();i++){
            dp[i] = new Node(1, k);
            for(int j=i-1;j>=0;j--){
                if(nums.get(j) == nums.get(i)){
                    Node prevNode = dp[j];
                    if(prevNode.kCount>= (i-j-1)){
                        int currentMax = prevNode.count + 1;
                        int newkCount = prevNode.kCount - (i-j-1);
                        Node current = new Node(currentMax, newkCount);
                        max = Math.max(max, currentMax);
                        dp[i]=current;
                        break;
                    }else{
                        dp[i] = new Node(1, k);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(1);
        ar.add(3);
        ar.add(2);
        ar.add(3);
        ar.add(1);
        ar.add(3);

        System.out.println(new FindLongestEqualSubarray().longestEqualSubarray(ar, 3));
    }
}
