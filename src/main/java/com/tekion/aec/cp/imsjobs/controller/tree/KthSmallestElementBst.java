package com.tekion.aec.cp.imsjobs.controller.tree;

/**
 * @author anju
 * @created on 30/12/24 and 2:29 PM
 */
public class KthSmallestElementBst {
    int count=0;
    int res = -1;
    public void kthSmallestrec(TreeNode root, int k) {
        if(root == null)
            return;

        kthSmallest(root.left, k);

        count++;
        if(count==k){
            res = root.value;
            return;
        }


        kthSmallest(root.right, k);

    }

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestrec(root, k);
        return res;
    }
}
