package com.logics.tree;

/**
 * @author anju
 * @created on 21/08/24 and 4:15 PM
 */
public class TreeDiameter {
    static int max = -1;

    public int diameterOfBinaryTree(TreeNode root) {
         diameterOfBinaryTree1(root);
         return max-1;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = diameterOfBinaryTree1(root.left);
        int rightSum = diameterOfBinaryTree1(root.right);
        max = Math.max(max, leftSum+rightSum+1);
        System.out.println(max);
        return 1 + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeDiameter treeDiameter = new TreeDiameter();

        TreeNode lNode1 = new TreeNode(4, null, null);
        TreeNode rNode1 = new TreeNode(5, null, null);

        TreeNode lNode = new TreeNode(2, lNode1, rNode1);
        TreeNode rNode = new TreeNode(3, null, null);
        TreeNode node = new TreeNode(1, lNode,  rNode);

        node.left = lNode;
        node.right = rNode;

        System.out.println(treeDiameter.diameterOfBinaryTree(node));

    }
}
