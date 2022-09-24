//Problem Statement: Given a list of unique words, return all the pairs of the
// distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

import java.util.*;

public class PalindromPairs {

    public static List<List<Integer>> palindromePairs(String[] words) {


        LinkedHashMap<String, List<Integer>> hashMap = new LinkedHashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        //loop through words and concatenate all pairs
        for(int i=0;i<words.length;i++){

            //go left of word
            for(int j=i-1;j>=0;j--){
                if(isPalindrome(words[i]+words[j])){
                    result.add(Arrays.asList(i, j));
                    continue;
                }
                hashMap.put(words[i]+words[j], Arrays.asList(i, j));
            }

            //go right of word
            for(int j=i+1;j<words.length;j++){
                if(isPalindrome(words[i]+words[j])){
                    result.add(Arrays.asList(i, j));
                    continue;
                }
                hashMap.put(words[i]+words[j],  Arrays.asList(i, j));
            }
        }

        for(String word : hashMap.keySet()){

            //check if reverse is same as original
            if(isPalindrome(word)){
                result.add(hashMap.get(word));
            }
        }


        return result;
    }

    public static boolean isPalindrome(String string){

        String reverse = new StringBuilder(string).reverse().toString();

        return string.equals(reverse);
    }

    public static void main(String[] args) {
        String[] words = {"a","b","c","ab","ac","aa"};
        System.out.println(palindromePairs(words));
    }
}
