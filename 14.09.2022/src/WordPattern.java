//Problem Statement: Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

import java.util.HashMap;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {

        String[] strings = s.split(" ");

        HashMap<Character, String> hashMap = new HashMap<>();

        //varying sizes
        if(pattern.length() != strings.length){
            return false;
        }

        //loop through pattern
        for(int i=0;i<strings.length;i++){

            //if seen pattern key, check if same
            if(hashMap.containsKey(pattern.charAt(i))){
                if(!hashMap.get(pattern.charAt(i)).equals(strings[i])){
                    return false;
                }
            }
            //pattern already exists but different key
            else if(hashMap.containsValue(strings[i])){
                return false;
            }
            //add new key to hashmap
            else{
                hashMap.put(pattern.charAt(i), strings[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "jquery";
        String string = "jquery";
        System.out.println(wordPattern(pattern, string));
    }
}
