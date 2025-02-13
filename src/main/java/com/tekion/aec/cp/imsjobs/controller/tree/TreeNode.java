package com.tekion.aec.cp.imsjobs.controller.tree;

/**
 * @author anju
 * @created on 21/08/24 and 4:15 PM
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    Integer value;

    public TreeNode() {

    }

    public TreeNode(Integer value, TreeNode left, TreeNode right ) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
