package com.logics.tree;

import java.util.*;

/**
 * @author anju
 * @created on 05/09/24 and 1:59 PM
 *
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */
public class BTLevelOrderPrint {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty() || !queue1.isEmpty()){
            List<Integer> row = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode curr = queue.poll();
                row.add(curr.val);
                if(curr.left !=null)
                    queue1.add(curr.left);
                if(curr.right != null)
                    queue1.add(curr.right);

            }

            result.add(row);
            row = new ArrayList<>();
            while(!queue1.isEmpty()){
                TreeNode curr = queue1.poll();
                row.add(curr.val);

                if(curr.left !=null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);

            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack();
        st.add(23423);

        String[] tokens = new String[2];

    }
}
