//Problem Statement: There is a strange printer with the following two special properties:
//
//The printer can only print a sequence of the same character each time.
//At each turn, the printer can print new characters starting from and ending at any place and
// will cover the original existing characters.

//Given a string s, return the minimum number of turns the printer needed to print it.

import java.util.HashMap;
import java.util.Stack;

public class StrangePrinter {

    public static int strangePrinter(String s) {

//        int count=0;
//
//        //keep track of characters
//        Stack<Character> stack = new Stack<>();
//
//        //keep track of new print or previous print
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//
//        char recent = '\0';
//        //iterate through string
//        for(int i=0;i<s.length();i++){
//
//            char curr = s.charAt(i);
//
//            //new character seen, increment count and change most recent char
//            if(!hashMap.containsKey(curr)){
//                stack.add(curr);
//                hashMap.put(curr, 1);
//                count++;
//            }
//            //seen
//            else{
//                if(curr!=recent) {
//                    //if 1 then set to 0 to indicate accounted for
//                    if (hashMap.get(curr) == 1) {
//                        hashMap.put(curr, 0);
//
//                        char inbetween = stack.pop();
//
//                        while (inbetween != curr) {
//                            hashMap.put(inbetween, 0);
//                            inbetween = stack.pop();
//                        }
//
//                    }
//                    //if 0 then previous encounter was between another print and needs to be accounted for
//                    else {
//                        stack.add(curr);
//                        hashMap.put(curr, 1);
//                        count++;
//                    }
//                }
//
//            }
//
//            recent = curr;
//        }
//
//        return count;
//    }

        Integer[][] memoiz = new Integer[s.length()][s.length()];
        return solveMemo(s, 0, s.length()-1, memoiz);
    }

    // Memoization
    public static int solveMemo(String s, int i, int j, Integer[][] dp){

        //same character so set to 1
        if(i == j){
            return 1;
        }

        //calculated prior
        if(dp[i][j] != null){
            return dp[i][j];
        }


        int ans = Integer.MAX_VALUE;

        //loop through every iteration and starting from the smallest building up acquire minimums at each stage
        for(int k = i; k < j; k++){
            ans = Math.min(ans, solveMemo(s, i, k, dp) + solveMemo(s, k + 1, j, dp));
        }

        //if characters are same then part of same print
        return dp[i][j] = s.charAt(i) == s.charAt(j) ? ans - 1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(strangePrinter("abcabc"));
    }
}
