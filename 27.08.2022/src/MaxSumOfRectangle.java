//Problem statement:Given an m x n matrix matrix and an integer k,
// return the max sum of a rectangle in the matrix such that its sum is no larger than k.
//
//It is guaranteed that there will be a rectangle with a sum no larger than k.

public class MaxSumOfRectangle {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
//
//        int max = Integer.MIN_VALUE;
//        int sum;
//        int[][] dp;
//
//        //loop through the matrix
//        for(int m=0;m<matrix.length;m++){
//            for(int l=0;l<matrix[0].length;l++) {
//                dp = new int[matrix.length + 1][matrix[0].length + 1];
//
//                for (int i = m; i < matrix.length; i++) {
//                    for (int j = l; j < matrix[0].length; j++) {
//
//                        //acquire value of sum of column to that point and add to dp table
//                        dp[i + 1][j + 1] = matrix[i][j] + dp[i][j + 1];
//
//                        //add current square with left and upper values
//                        sum = dp[i + 1][j] + dp[i + 1][j + 1];
//
//                        //find max
//                        if (sum > max && sum <= k) {
//                            max = sum;
//                        }
//
//                    }
//                }
//            }
//        }
//
//        //loop through the matrix
//        for(int m=0;m<matrix.length;m++) {
//
//            for (int l = 0; l < matrix[0].length; l++) {
//                dp = new int[matrix.length + 1][matrix[0].length + 1];
//
//                for (int i = m; i < matrix.length; i++) {
//                    for (int j = l; j < matrix[0].length; j++) {
//
//                        //acquire value of sum of column to that point and add to dp table
//                        dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j];
//
//                        //add current square with left and upper values
//                        sum = dp[i][j + 1] + dp[i + 1][j + 1];
//
//                        if (sum == k) {
//                            return sum;
//                        }
//
//                        //find max
//                        if (sum > max && sum < k) {
//                            max = sum;
//                        }
//
//
//                    }
//                }
//            }
//        }
//
//        return max;

        int max = Integer.MIN_VALUE;
        int sum;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];

        //loop through
        for(int i=1;i<=row;i++){
            for(int j = 1;j<=col;j++){

                //add upper and left value and minus its overlaps
                dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        //loop through
        for(int i=1;i<=row;i++){
            for(int j = 1;j<=col;j++){

                //loop through smaller square
                for(int l=i;l<=row;l++){
                    for(int m = j;m<=col;m++){

                        //get sum removing the excluded areas as dp[][] includes the entire column/row and re-add the twice subtracted overlap
                        sum = dp[l][m] - dp[i-1][m] - dp[l][j-1] + dp[i-1][j-1];

                        if(sum==k){
                            max = sum;
                            return max;
                        }
                        else if(sum<k && sum>max){
                            max = sum;
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{28,4,-19,18,-7,-10,27,19,1,16,0,10,-17,11,11,27,-1,10,12,-1},{-2,-19,17,4,25,-20,4,3,4,28,-10,7,16,-14,-3,-19,6,17,-4,-7},{2,8,18,-17,-2,10,-6,-5,11,10,22,-6,19,-16,6,-4,18,5,22,-17},{-14,-7,-20,13,-19,-20,-15,21,-11,-10,-8,-9,10,13,6,-10,15,9,-15,-2},{-18,26,12,8,2,16,-17,12,0,-5,9,-3,-12,-11,3,-6,-18,16,-7,-14},{5,29,25,22,11,-3,-2,-15,4,13,-17,-2,0,-2,20,10,-18,6,25,-20},{5,-7,8,5,15,22,8,-5,22,-18,-5,-14,23,2,-8,12,-16,-18,12,-12},{27,18,4,11,-3,12,-4,-8,-3,25,-9,24,-14,5,11,-9,-17,0,25,-15},{26,-7,18,4,4,18,-17,9,-19,-9,-19,-8,-4,-13,10,-11,6,-16,-12,12},{28,22,7,11,-6,13,8,22,7,-14,17,14,10,29,16,9,-3,18,-9,10},{27,19,-10,-9,1,3,14,1,7,3,-3,16,-2,9,14,-7,-19,-5,23,19},{-17,7,-20,8,-5,-6,-2,25,29,16,23,4,4,27,16,17,9,20,-6,22},{2,9,-13,1,-18,25,4,7,25,26,-4,8,-19,18,6,-7,-5,7,21,-8},{-2,11,1,29,6,-16,-8,3,7,11,10,-2,-1,-20,20,4,19,5,29,-7},{29,-12,-3,17,6,19,23,12,-19,13,19,5,27,22,-17,27,10,-12,12,23},{24,16,4,25,15,13,24,-19,1,-7,-19,13,-13,14,13,26,9,18,-9,-18},{-17,4,-18,-18,-19,3,-13,12,23,-17,-10,-20,14,2,18,21,-12,27,-3,4},{27,13,12,14,16,-9,-2,-15,-20,8,-2,24,18,15,26,21,27,17,-15,-3},{25,-8,17,-10,-16,13,26,-11,-15,6,-5,-13,23,2,24,-4,5,8,-15,-1},{15,-12,18,5,-3,7,5,11,-4,-13,28,20,0,-4,-13,-5,-13,-8,-16,3}};
        int k = -123;
        System.out.println(maxSumSubmatrix(matrix, k));
    }
}
