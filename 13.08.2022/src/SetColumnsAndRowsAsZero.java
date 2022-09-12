//Given a two-dimensional array, if any element within is zero, make its whole row and column zero
//Time Complexity: O(n^3)
//Space Complexity: O(n^2)

import java.util.Arrays;

public class SetColumnsAndRowsAsZero {

    public static int[][] setZero(int[][] original) {

        int[][] result = new int[original.length][original[0].length];

        //fill result with -1 flag
        for (int i = 0; i < result.length;i++){
            Arrays.fill(result[i], -1);
        }

        //traverse original
        for(int i=0;i<original.length;i++){
            for(int j=0;j<original[0].length;j++){

                //if 0 found, note in new 2d array
                if(original[i][j]==0){
                    //convert column
                    for (int k = 0; k < result.length; k++) {
                        result[k][j] = 0;
                    }
                    //convert row
                    for (int l = 0; l < result[0].length; l++) {
                        result[i][l] = 0;
                    }
                }
            }
        }


        //traverse new array and replace -1 with original values
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++) {

                if(result[i][j]==-1){
                    result[i][j] = original[i][j];
                }
            }
        }

        return result;
    }

    public static void printArray(int[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++) {

                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] test = {{5,4,3,9},{2,0,7,6},{1,3,4,0},{9,8,3,4}};
        printArray(setZero(test));
    }


}
