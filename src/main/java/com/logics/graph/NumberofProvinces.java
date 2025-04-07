package com.logics.graph;

/**
 * @author anju
 * @created on 03/03/25 and 6:24 PM
 */
public class NumberofProvinces {
/****
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 */

    public int findCircleNum(int[][] connections) {
        int count = 0;
        boolean[] visited = new boolean[connections.length];
        for(int i=0;i<connections.length;i++){ // visited each city and find its connected graph
                if(visited[i]==false){
                    count++;
                    dfs(connections, i, visited);
                }
        }
        System.out.println(count);
        return count;
    }

    public void dfs(int[][] connections, int currentCity, boolean[]visited) {
        visited[currentCity] = true;
        for(int i=0;i<connections[currentCity].length;i++){ // check for all other city if there is any connected and not visited
            if(connections[currentCity][i]==1 && visited[i]==false){
                dfs(connections, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        boolean[][] visited = new boolean[input.length][input[0].length];
        System.out.println(new NumberofProvinces().findCircleNum(input));
    }

}
