package com.logics.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author anju
 * @created on 16/09/24 and 10:16 AM
 */
public class rottingOrange {

    class Node{
        int r;
        int c;
        int sec;
        Node(int row, int col, int sec){
            r = row;
            c = col;
            this.sec = sec;
        }
    }

    public int orangesRotting(int[][] grid) {
            int[][] visited = new int[grid.length][grid[0].length];
            int minRes = 0;
            Queue<Node> qu = new LinkedList<Node>();
            int freshCount =0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j] == 1){
                        freshCount++;
                    }
                    else if( grid[i][j] == 2){
                        qu.add(new Node(i, j, 0));
                        visited[i][j] = 1;
                    }
                }
            }
            // minRes = bfs(visited, grid, freshCount, qu);

            int[] dirX = new int[]{-1,1,0,0};
            int[] dirY = new int[]{0,0,-1,1};
            while(!qu.isEmpty()){
                Node curr = qu.poll();
                int time = curr.sec;
                minRes = Math.max(minRes, time);

                for(int i=0;i<4;i++){
                    int newX = curr.r + dirX[i];
                    int newY = curr.c + dirY[i];
                    if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && visited[newX][newY] == 0 &&
                            grid[newX][newY] == 1
                    ){
                        freshCount--;
                        visited[newX][newY] = 1;
                        qu.add(new Node(newX, newY, time+1));
                    }
                }

            }


            if(freshCount>0)
                return -1;
            return minRes;

    }



    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new rottingOrange().orangesRotting(grid));
    }

}
