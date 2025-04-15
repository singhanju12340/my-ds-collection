package com.logics.trie.bitManupulation;


/**
 * @author anju
 * @created on 15/04/25 and 8:02 PM
 */

class BinaryNode{
    BinaryNode[] node;
    boolean contains(int bit){
        return (node[bit]!=null) ? true: false;
    }

    void insert(int bit, BinaryNode node){
        this.node[bit] = node;
    }
}

class BinaryTrie{
    BinaryNode root;

    BinaryTrie(){
        root = new BinaryNode();
    }

    public void insert(int n){
        BinaryNode currentRoot = this.root;
        for(int i=31;i>=0;i--){
            int bit =  n>>i & 1; // is ith index binary position of n is set or not
            if(currentRoot.node[bit] == null){
                currentRoot.node[bit] = new BinaryNode();
            }
            currentRoot = currentRoot.node[bit];
        }
    }

    public int getMax(int m){
        BinaryNode currentRoot = this.root;
        int maxNum = 0;
        for(int i=31;i>=0;i--){
            int bit =  m>>i & 1; // is ith index binary position of n is set or not
            if(currentRoot.node[1- bit] != null){ // check if opposite node exist
                maxNum = maxNum | 1<<i; // find or of max and 1 at current position
                currentRoot = currentRoot.node[1- bit];
            }else{
                currentRoot = currentRoot.node[1- bit];
            }
        }
        return maxNum;
    }
}
public class MaximumXor {
    /*
     find maximum value of XOR of 2 elements from 2 arrays a and b.
     */

    public static int findMax(int[]a, int[]b){
        BinaryTrie root = new BinaryTrie();
        int result = 0;

        //insert in trie from a array
        for(int i=0;i<a.length;i++) {
            int currentNo = a[i];
            root.insert(currentNo);
        }

        //insert in trie from b array
        for(int i=0;i<b.length;i++) {
            int currentNo = b[i];
            int max = root.getMax(currentNo);
            result = Math.max(result, max);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = new int[]{};
        int[] b = new int[]{};

        // create binary trie from one array elements
        // take xor for each element from 2nd array and calculate the maximum.

    }
}
