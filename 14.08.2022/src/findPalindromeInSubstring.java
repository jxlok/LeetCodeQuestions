//Problem Statement: Given a string, find all non-single letter substrings that are palindromes.

import java.util.ArrayList;
import java.util.List;

//time complexity: O(n^3)
//space complexity: O(1)
public class findPalindromeInSubstring {

//    public static List<String> findPalindromes(String str){
//
//        int n = str.length();
//        boolean[][] dp = new boolean[n][n];
//
//        //iterate diagonally through dp array
//        for(int diag=0;diag<str.length();diag++){
//
//            int start = 0;
//            for(int end=diag;end<str.length();end++){
//
//                if(diag==0){
//                    dp[start][end]=true;
//                }
//                else if(diag == 1){
//                    dp[start][end] = str.charAt(start)==str.charAt(end);
//                }
//                else{
//                    if(str.charAt(start)==str.charAt(end) && dp[start+1][end-1]){
//                        dp[start][end] = true;
//                    }
//                }
//
//                start++;
//            }
//        }
//
//
//    }

        public static boolean isPalindrome(String str){

            //non single letter condition
            if(str.length()<=2){
                return false;
            }
            //declare pointers
            int start=0;
            int end = str.length()-1;

            //while no overlap in pointers
            while(start<end){
                //if no match, return false
                if(str.charAt(start)!=str.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }

        //check for every substring, if it is a palindrome
        public static List<String> findPalindromes(String str) {

            List<String> answer = new ArrayList<>();

            for(int i=0;i<str.length();i++){
                for(int j=i+1;j<str.length();j++){
                    if(isPalindrome(str.substring(i, j))){
                        answer.add(str.substring(i, j));
                    }
                }
            }

            return answer;
        }

    public static void main(String[] args) {
        System.out.println(findPalindromes("poppopo"));
    }

}
