//Problem Statement: Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
//
//Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
//
//You may return the answer in any order.

import java.util.*;

public class NumbersSameConsecutiveDifference {

    public static int[] numsSameConsecDiff(int n, int k) {

        //store result
        HashSet<Integer> result = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        //loop through 1-9 as starting numbers and add to stack
        for(int i=1;i<10;i++){

            //add first digit
            stack.add(i);

            int multiplier = 1;

            //while stack not empty
            while(!stack.isEmpty()){

                //take from stack
                int curr = stack.pop();

                //get size
                int decimalPlaces = String.valueOf(curr).length();

                //while not a large enough number
                if(decimalPlaces<n) {

                    //get final digit
                    int digit = (int) (curr%(Math.pow(10, multiplier)));

                    //smaller digit
                    if (digit - k >= 0) {
                        stack.add(curr * 10 + digit - k);
                    }

                    //greater digit
                    if (digit + k < 10) {
                        stack.add(curr * 10 + digit + k);
                    }

                    //multiplier only increments if curr bigger than current decimal places
                    if(curr>=10*Math.pow(10, decimalPlaces)) {
                        multiplier++;
                    }

                }

                else{
                    result.add(curr);
                }

            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
    }
}
