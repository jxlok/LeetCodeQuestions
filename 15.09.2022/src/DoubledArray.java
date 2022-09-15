//Problem Statement: An integer array original is transformed into a doubled array changed by appending twice the value of every element
// in original, and then randomly shuffling the resulting array.
//
//Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array.
// The elements in original may be returned in any order.
//
//

import java.util.*;

public class DoubledArray {

    public static int[] findOriginalArray(int[] changed) {
        //result
        int[] result = new int[changed.length/2];

        //sort
        Arrays.sort(changed);

        //queue
        Queue<Integer> queue = new LinkedList<>();

        //result indexer
        int i=0;

        //loop through
        for(int num : changed){

            //if number is found
            if(!queue.isEmpty() && queue.peek()==num){
                //add half
                result[i] = queue.poll()/2;
            }
            //add double
            else {
                queue.add(num * 2);
            }
        }

        //if queue is empty, return result else empty array
        return queue.size()>0 ? new int[0] : result;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0};
        System.out.println(Arrays.toString(findOriginalArray(arr)));
    }
}
