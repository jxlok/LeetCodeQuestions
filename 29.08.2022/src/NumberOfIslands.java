//Problem Statement: Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

import java.util.*;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        //queue for encountered positions to check
        Queue<int[]> queue = new LinkedList<>();
        LinkedList<int[]> islands = new LinkedList<>();
        int num = 0;

        //loop through and add all land to islands
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(grid[i][j]=='1'){
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';

                    //increment islands
                    num++;
                    while(!queue.isEmpty()){

                        //take from queue
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];


                        //check upper position
                        if(x-1 >= 0 && grid[x-1][y]=='1') {
                            queue.add(new int[]{x - 1, y});
                            grid[x - 1][y] = '0';
                        }

                        //check lower position
                        if(x+1 < row && grid[x+1][y]=='1') {
                            queue.add(new int[]{x + 1, y});
                            grid[x + 1][y] = '0';
                        }

                        //check left position
                        if(y-1 >= 0 && grid[x][y-1]=='1') {
                            queue.add(new int[]{x, y - 1});
                            grid[x][y - 1] = '0';
                        }

                        //check right position
                        if(y+1 < col && grid[x][y+1]=='1'){
                            queue.add(new int[]{x, y+1});
                            grid[x][y+1] = '0';
                        }
                    }
                }
            }
        }

        return num;

    }

    public static void main(String[] args) {
            char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};

        System.out.println(numIslands(grid));
    }
}
