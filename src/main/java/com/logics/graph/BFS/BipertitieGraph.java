package com.logics.graph.BFS;

import java.util.*;

/**
 * @author anju
 * @created on 03/05/25 and 10:48 AM
 */
public class BipertitieGraph {
    //https://leetcode.com/problems/is-graph-bipartite/

    public boolean isBipartite3(int[][] graph) {
        Set<Integer> red = new HashSet<>();
        Set<Integer> green = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        while(!queue.isEmpty()){
            int current = queue.poll();
            int[] child = graph[current];

            if(!red.contains(current) && !green.contains(current)){
                red.add(current);
            }

            if(red.contains(current)){
                // check if child is in green
                for(int i=0;i<child.length;i++){
                    int currentChild = child[i];
                    if(red.contains(currentChild)){
                        return false;
                    }else if(!green.contains(currentChild)){
                        green.add(currentChild);
                        queue.add(currentChild);
                    }
                }
            }
            else if(green.contains(current)){
                for(int i=0;i<child.length;i++){
                    int currentChild = child[i];
                    if(green.contains(currentChild)){
                        return false;
                    }else if(!red.contains(currentChild)){
                        red.add(currentChild);
                        queue.add(currentChild);
                    }
                }
            }


        }
        return true;
    }

    public boolean isBipartite2(int[][] graph,  int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(color, -1);

        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            int[] child = graph[current];

            if(color[current] == -1){
                color[current] = 0;
            }

            int parentColor = color[current];
            // check if child is in green
            for(int i=0;i<child.length;i++){
                int currentChild = child[i];
                if(color[currentChild]== (parentColor)){ // of same color as parent
                    return false;
                }else if(color[currentChild]==-1){ // no color filled till now
                    color[currentChild]=(parentColor^1);
                    queue.add(currentChild);
                }
                // opposite color processed child is ignored
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[graph.length]; // 0-red, 1-green, -1 not filled
        Arrays.fill(color, -1);

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1)
               if(isBipartite2(graph, color, i) == false)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int[][] graph = new int[][]{{1,3}, {0,2}, {1,3}, {0,2}};

        System.out.println(new BipertitieGraph().isBipartite(graph));
    }
}
