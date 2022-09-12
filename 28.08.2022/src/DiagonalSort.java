//Problem Statement: A matrix diagonal is a diagonal line of cells starting from some cell in either the
// topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end.
// For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix,
// includes cells mat[2][0], mat[3][1], and mat[4][2].
//
//Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

import java.util.Arrays;

public class DiagonalSort {

    public static int[][] diagonalSort(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        //returned matrix
        int[][] result = new int[row][col];

        //loop through every diagonal
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                //if topmost or leftmost edge
                if(i==0 || j==0){

                    int offset = 0;

                    //array of varying size
                    int[] tmp = new int[Math.min(row-i, col-j)];

                    //while edge not reached
                    while(offset+j < col && offset+i < row){

                        //add diag to tmp
                        tmp[offset] = mat[i+offset][j+offset];
                        offset++;
                    }

                    //sort diagonal
                    Arrays.sort(tmp);

                    offset=0;
                    //add diagonal back in
                    //while edge not reached
                    while(offset+j < col && offset+i < row){

                        //add sorted diag to result
                        result[i+offset][j+offset] = tmp[offset];
                        offset++;
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        System.out.println(Arrays.deepToString(diagonalSort(test)));
    }

}
