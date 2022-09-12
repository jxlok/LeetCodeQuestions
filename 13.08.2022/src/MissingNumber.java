//Problem Statement: Given an array of positive numbers ranging from 1 to n,
// such that all numbers from 1 to n are present except one number x, find x.
// Assume the input array is unsorted.

import java.util.Arrays;

//Time complexity: O(n)
//Space complexity: O(1)
public class MissingNumber {

    public static int findMissingNumber(int[] array){

        //sort array
        Arrays.sort(array);

        //loop through and find if the number matches with index+1
        for(int i=0;i<array.length;i++){
            if(array[i]!=i+1){
                return i+1;
            }
        }

        //all present
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {3, 7, 1, 2, 8, 4, 6};
        System.out.println(findMissingNumber(test));
    }
}
