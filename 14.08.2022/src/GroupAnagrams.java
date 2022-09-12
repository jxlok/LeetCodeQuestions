//Problem Statement: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time complexity: O(n^2)
//Space Complexity: O(n)
public class GroupAnagrams {
    int[] A = new int[5];

    public static List<List<String>> groupAnagrams(String[] strs){

        List<List<String>> result = new ArrayList<>();

        //iterate through strs and fill in result with lists containing strings
        for(int i=0;i<strs.length;i++){
            ArrayList<String> word = new ArrayList<>();
            word.add(strs[i]);
            result.add(word);
        }

        //iterate through list and sort
        for(int i=0;i< strs.length;i++){
            char tmp[] = strs[i].toCharArray();
            Arrays.sort(tmp);
            strs[i] = new String(tmp);
        }

        //find matches in strs and move corresponding indexes in result to match
        for(int i=0;i<strs.length;i++){

        if(result.get(i)!=null) {

                //iterate through and find matches
                for (int j = i+1; j < strs.length; j++) {
                    if (result.get(j) != null) {
                        if (strs[i].equals(strs[j])) {
                            result.get(i).addAll(result.get(j));
                            result.set(j, null);
                        }
                    }
                }
            }
        }


        return result;


    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] strs1 = new String[]{""};
        String[] strs2 = new String[]{"a"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
    }
}
