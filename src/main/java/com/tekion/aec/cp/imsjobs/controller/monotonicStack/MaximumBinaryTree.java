package com.tekion.aec.cp.imsjobs.controller.monotonicStack;

import com.tekion.aec.cp.imsjobs.controller.tree.TreeNode;

import java.util.Stack;

/**
 * @author anju
 * @created on 23/12/24 and 11:40 PM
 */
public class MaximumBinaryTree {

    /***
     * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
     *
     * Create a root node whose value is the maximum value in nums.
     * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
     * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
     * Return the maximum binary tree built from nums.
     *
     *
     * Input: nums = [3,2,1,6,0,5]
     * Output: [6,3,5,null,2,0,null,null,1]
     * Explanation: The recursive calls are as follow:
     * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
     *     - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
     *         - Empty array, so no child.
     *         - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
     *             - Empty array, so no child.
     *             - Only one element, so child is a node with value 1.
     *     - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
     *         - Only one element, so child is a node with value 0.
     *         - Empty array, so no child.
     */


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        binaryHalf(0, nums.length-1, nums);
    }

    public TreeNode constructMaximumBinaryTreeRec(int[] nums) {
        Stack<TreeNode> st = new Stack<>();
        for(int i=0;i<nums.length;i++){
            TreeNode curr = new TreeNode(nums[i], null, null);
            while(!st.isEmpty() && st.peek().getValue() <= nums[i]){
                curr.left = st.pop();
            }

            if(!st.isEmpty()){
                st.peek().right = curr;
            }

            st.push(curr);
        }
        return st.isEmpty()? null : st.firstElement();
    }

    public static  TreeNode binaryHalf( int start, int end, int[] nums){
        if(start>end)
            return null;
        int maxIndex = findMax( start, end, nums);
        TreeNode curr = new TreeNode(nums[maxIndex], null, null);
        curr.left = binaryHalf(  start, maxIndex-1, nums);
        curr.right = binaryHalf(  maxIndex+1, end, nums);
        return curr;

    }

    public static int findMax(int start, int end, int[] nums){
        int max = Integer.MIN_VALUE;
        int maxIndex = start;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;

    }
}
