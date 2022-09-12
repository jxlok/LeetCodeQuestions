//Problem Statement: Given an array of integers arr, replace each element with its rank.
//
//The rank represents how large the element is. The rank has the following rules:
//
//Rank is an integer starting from 1.
//The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//Rank should be as small as possible.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class RankTransform {

    public static int[] arrayRankTransform(int[] arr) {

        //sorted map taking value and list of index's
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        //loop through array and add to map
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else {
                List<Integer> value = List.of(i);
                map.put(arr[i], new ArrayList<>(value));
            }
        }

        int prev = -1;
        int rank=0;
        //loop through keys in map and replace original arr with values
        for(int key : map.keySet()){

            //if different
            if (key != prev) {
                rank++;
            }

            //replace array value from list of indexes with rank
            for(int index : map.get(key)) {
                arr[index] = rank;
            }

            prev = key;
        }

        return arr;

    }

    public static void main(String[] args) {

        int[] arr = {40, 10, 20, 30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
