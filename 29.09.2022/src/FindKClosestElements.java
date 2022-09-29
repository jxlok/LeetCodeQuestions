//Problem Statement: Given a sorted integer array arr, two integers k and x,
// return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//
//|a - x| < |b - x|, or
//|a - x| == |b - x| and a < b

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {


        int size = arr.length;
        int index=size;

        //find index closest to x in arr
        for(int i = 0;i<size;i++){
            //if value is greater than our marker, stop
            if(arr[i]>=x){
                index=i;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        if(index==0){
            result = Arrays.stream(Arrays.copyOfRange(arr, 0, k)).boxed().toList();
            return result;
        }

        else if(index==size){
            result = Arrays.stream(Arrays.copyOfRange(arr, size-k, size)).boxed().toList();
            return result;
        }

        else{
            //j iterator on left
            int j = index-1;

            while(k>0){
                if(j==-1){
                    result.add(arr[index]);
                    index++;
                }
                else if(index==size){
                    result.add(arr[j]);
                    j--;
                }
                //if right is closer to value than left
                else if((Math.abs(arr[index]-x) < Math.abs(arr[j]-x))){
                    result.add(arr[index]);
                    index++;
                }
                else if(Math.abs(arr[j]-x) <= Math.abs(arr[index]-x)){
                    result.add(arr[j]);
                    j--;
                }


                k--;
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,6,8,8,9};
        System.out.println(findClosestElements(arr, 5, 9));
    }
}
