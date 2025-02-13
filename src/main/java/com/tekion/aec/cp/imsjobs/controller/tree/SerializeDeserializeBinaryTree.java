package com.tekion.aec.cp.imsjobs.controller.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author anju
 * @created on 03/01/25 and 2:30 PM
 */
public class SerializeDeserializeBinaryTree {
    // Algorithm
    /**
     *
     The problem requires designing a method to serialize (convert a binary tree to a string) and deserialize (reconstruct the binary tree from the string). A common approach is to use preorder traversal and a marker for null nodes.

     Approach
     Serialization:

     Use preorder traversal (node → left → right) to convert the tree into a string.
     Represent null nodes with a special marker, such as #.
     Use a delimiter (e.g., ,) to separate node values.
     Deserialization:

     Read the serialized string and use a queue (or index pointer) to reconstruct the tree in preorder:
     Read the next value.
     If it's #, return null for the current node.
     Otherwise, create a node with the value and recursively construct the left and right subtrees.
     Algorithm
     Serialization:
     Traverse the tree in preorder.
     Append node values to the result string.
     Append # for null nodes.
     Deserialization:
     Split the serialized string into an array of node values.
     Use a queue (or index) to keep track of the current position.
     Recursively build the tree using preorder traversal.
     * **/

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
            StringBuilder stb = new StringBuilder();
        serializeHelper(root, stb);
        return stb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder stb) {
        if(root == null){
            stb.append("#,");
            return;
        }
        stb.append(root.value);
        stb.append(",");
        serializeHelper(root.left, stb);
        serializeHelper(root.right, stb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper( queue);
    }

    public TreeNode deserializeHelper(  Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("#"))
            return null;
        TreeNode root = new TreeNode();
        root.value = Integer.valueOf(val);
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}
