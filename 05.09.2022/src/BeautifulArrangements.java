//Problem Statement: Given two integers n and k, construct a list answer that contains n different positive
// integers ranging from 1 to n and obeys the following requirement:
//
//Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... ,
// |an-1 - an|] has exactly k distinct integers.
//Return the list answer. If there multiple valid answers, return any of them.

import java.util.Arrays;
import java.util.Collections;

public class BeautifulArrangements {

    public static int[] constructArray(int n, int k) {

        //answer array
        int[] answer = new int[n];

        //create sorted answer array from 1-n
        for(int i=1;i<=n;i++){
            answer[i-1] = i;
        }

        //reverse from here
        int startPosition =1;

        //in order to create a new distinct difference, we only need to reverse
        while(startPosition < k){

            reverse(answer, startPosition, answer.length-1);

            startPosition++;
        }

        return answer;
    }

    public static void reverse(int[] arr, int i, int j){

        for(;i<=j;i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(5, 4)));
    }

}
