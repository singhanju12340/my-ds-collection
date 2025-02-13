package com.logics.tree.binaryTree;

import com.logics.tree.TreeNode;

/**
 * @author anju
 * @created on 23/01/25 and 1:44 PM
 */
public class GoodNodeInBT {
    int count = 0;

    public int goodNodes(TreeNode root) {
        goodNodesDfs(root,  root.getValue());
        return count;
    }

    public void goodNodesDfs(TreeNode root, int lastValue) {
        if(root == null)
            return;

        if(root.getValue() >= lastValue){
            count++;
            lastValue = root.getValue();
        }

        goodNodesDfs(root.left, lastValue);
        goodNodesDfs(root.right, lastValue);
        return;
    }
}
