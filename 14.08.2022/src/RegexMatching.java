//Problem Statement: Given a text and a pattern, determine if the pattern matches the text completely or not at all using regular expression matching.
// Assume the pattern contains only two operators: . and *. Operator * in the pattern means that the character preceding * may not appear or may appear
// any number of times in the text.
// Operator . matches with any character in the text exactly once.

import java.util.ArrayList;

//Time Complexity: O(n)
//Space Complexity: O(1)
public class RegexMatching {

    public static boolean matchPattern(String str, String pattern) {

        ArrayList<Character> reusable = new ArrayList<>();
        int stringPointer = 0;
        int patternPointer = 0;
        //loop through string and compare
        while (patternPointer < pattern.length() && stringPointer < str.length()) {

            //if reusable, continue
            if(reusable.contains(str.charAt(stringPointer))) {
                stringPointer++;
            }
            //if . is present or present in reusable letters then continue as normal
            else if (pattern.charAt(patternPointer) == '.' || str.charAt(stringPointer) == pattern.charAt(patternPointer)) {
                patternPointer++;
                stringPointer++;
            }
            else if (pattern.charAt(patternPointer) == '*') {
                reusable.add(str.charAt(stringPointer-1));
                patternPointer++;
            }
            //if repeated value, repeated 0 times
            else if(pattern.charAt(patternPointer) != str.charAt(stringPointer) && pattern.charAt(patternPointer+1)=='*'){
                patternPointer++;
                continue;
            }
            else{
                return false;
            }

        }

        //if string not finished checking through, check if the additional letters can be found in reusable
        while(stringPointer<str.length()){
            if(!reusable.contains(str.charAt(stringPointer))){
                return false;
            }
            stringPointer++;
        }

        return true;
    }

    public static void main(String[] args) {
        String Text = "aabbbbbcdda";
        String pattern = "aab*e*cd*a";

        System.out.println(matchPattern(Text, pattern));
    }
}
