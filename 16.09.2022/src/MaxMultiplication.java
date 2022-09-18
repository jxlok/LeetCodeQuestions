//Problem Statement: You are given two integer arrays nums and multipliers of size n and m respectively,
// where n >= m. The arrays are 1-indexed.
//
//You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
//
//Choose one integer x from either the start or the end of the array nums.
//Add multipliers[i] * x to your score.
//Remove x from the array nums.
//Return the maximum score after performing m operations.

import java.util.Arrays;

public class MaxMultiplication {

    public static int maximumScore(int[] nums, int[] multipliers) {
//
//        int maxSum = 0;
//
//        int n = nums.length;
//        int m = multipliers.length;
//
//        int start = 0;
//        int end = n-1;
//
//        //loop until all multipliers used
//        while(m>0){
//
//            //acquire start value * multiplier && end value * multiplier
//            int startMultiple = nums[start]*multipliers[multipliers.length-m];
//            int endMultiple = nums[end]*multipliers[multipliers.length-m];
//
//            //if start is bigger than end, add to max and move start pointer
//            if(startMultiple>endMultiple){
//                maxSum += startMultiple;
//                start++;
//            }
//            //else end is bigger than start, add to max and move end pointer
//            else{
//                maxSum+=endMultiple;
//                end--;
//            }
//
//            //decrement m
//            m--;
//        }
//
//        return maxSum;

        //use dynamic programming
        int end = nums.length;

        if(multipliers.length==0){
            return 0;
        }

        return Math.max(nums[0]*multipliers[0] + maximumScore(Arrays.copyOfRange(nums,  1, end), Arrays.copyOfRange(multipliers, 1, end)), maximumScore(Arrays.copyOfRange(nums,  0, end-1), Arrays.copyOfRange(multipliers, 1, end)));
    }

    public static void main(String[] args) {
        int[] multiplier = {-10,-5,3,4,6};
        int[] nums = {-5,-3,-3,-2,7,1};

        System.out.println(maximumScore(nums, multiplier));
    }

}
