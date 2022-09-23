//Problem Statement: Given a string s, reverse the order of characters in each word within
// a sentence while still preserving whitespace and initial word order.

import java.util.Arrays;
import java.util.Collections;

public class reverseStringIII {

    public String reverseWords(String s) {

        String[] string = s.split(" ");

        StringBuilder result = new StringBuilder();
        //loop through words and reverse and add to result with space
        for(String words : string){
            StringBuilder word = new StringBuilder(words);
            word.reverse();
            result.append(word).append(" ");
        }

        return result.toString().trim();

    }
}
