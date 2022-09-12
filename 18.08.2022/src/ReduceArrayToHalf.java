//Problem Statement: You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
//
//Return the minimum size of the set so that at least half of the integers of the array are removed.

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ReduceArrayToHalf {

    public static int minSetSize(int[] arr) {

        HashMap<Integer, Integer> numbers = new HashMap<>();

        //loop through array and add unique values to hashmap with count
        for(int i=0;i<arr.length;i++){

            //not in hashmap
            if(!numbers.containsKey(arr[i])){
                numbers.put(arr[i], 1);
            }
            //increment value
            else{
                numbers.put(arr[i], numbers.get(arr[i])+1);
            }
        }

        //half of array
        int minimum = (arr.length+1)/2;

        Integer[] values = numbers.values().toArray(new Integer[0]);
        Arrays.sort(values, Collections.reverseOrder());

        int count = 0;
        int total = 0;

        //loop through values
        for(int value : values){
            //if minimum not surpassed
            if(total<minimum){
                total+=value;
                count++;
            }
            else{
                break;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7};
        System.out.println(minSetSize(arr));
    }
}
