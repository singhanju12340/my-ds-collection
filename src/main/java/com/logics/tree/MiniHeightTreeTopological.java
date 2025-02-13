package com.logics.tree;

import java.util.*;

/**
 * @author anju
 * @created on 16/01/25 and 5:26 PM
 */
public class MiniHeightTreeTopological {

    /***
     * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
     *
     * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
     *
     * Return a list of all MHTs' root labels. You can return the answer in any order.
     *
     * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
     */

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // create graph by creating adjecency list
        // start checking graph by level order traveral starting with leaf node
        // insert all leaf node into queue
        // remove each nodes from queue and reduce its indegree count
        // if there is any node whose in degree=1 i.e has become leaf after removing node
        // remove all the leaf iteratively until only 1 or 2 leaf nodes are left

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[n];

        // created adjacent list
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);

            // create indegree array
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        Queue<Integer> leafQueue = new LinkedList<>();

        // add all the leaf node to queue
        for (int i=0;i<n;i++) {
            if(inDegree[i] == 1)
                leafQueue.add(i);
        }

        // size check for 2 because root can be 1 or 2 based on the even and odd size of tree
        while(leafQueue.size()>2){
            int leafNodeSize = leafQueue.size();
            while(leafNodeSize > 0){
                int current = leafQueue.poll();

                for (Integer adjNodes: adjList.get(current)) {

                    inDegree[adjNodes] = inDegree[adjNodes] - 1;

                    if(inDegree[adjNodes] == 1)
                        leafQueue.add(adjNodes);
                }
                leafNodeSize--;
            }
        }

        while(!leafQueue.isEmpty()){
            result.add(leafQueue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
//       int[][] input =  {{1,0},{1,2},{1,3}};
        int[][] input =  {{3,0},{3,1},{3,2},{3,4},{5,4}};

        findMinHeightTrees(6, input);
    }
}
