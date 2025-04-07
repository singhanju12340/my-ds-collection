package com.logics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author anju
 * @created on 25/03/25 and 12:25 PM
 */


public class ZigZagPrintTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        if(root!=null)
            st1.add(root);

        ArrayList<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        while(!st1.isEmpty() || ! st2.isEmpty()){
            while(!st1.isEmpty()){
                TreeNode current = st1.pop();
                temp.add(current.val);

                if(current.left != null){
                    st2.add(current.left);
                }

                if(current.right != null){
                    st2.add(current.right);
                }
            }

            res.add(temp);
            temp = new ArrayList<>();

            while(!st2.isEmpty()){
                TreeNode current = st2.pop();
                temp.add(current.val);

                if(current.right != null){
                    st1.add(current.right);
                }

                if(current.left != null){
                    st1.add(current.left);
                }
            }

            if(!temp.isEmpty())
                res.add(temp);
        }
        return res;
    }



}
