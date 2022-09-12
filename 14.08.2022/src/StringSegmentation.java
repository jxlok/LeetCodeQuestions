//Problem Statement: Given a dictionary of words and a large input string,
// find whether or not the input string can be completely segmented into the words of that dictionary.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//time complexity: O(2^n) due to recursion
//space complexity: O(1)
public class StringSegmentation {

    public static boolean segmentedIntoDictionary(List<String> dictionary, String str){

        //declare pointers
        int start=0;
        int end = 1;

        //while end not reached
        while(end<=str.length()){

            for(String word : dictionary) {
                //if substring found in dict, move start of word forward
                if (dictionary.contains(str.substring(start, end))) {
                    //if solvable using rest, else search other alternatives
                    if(segmentedIntoDictionary(dictionary, str.substring(end, str.length()))) {
                        start = end;
                    }

                }
            }
            //iterate end
            end++;
        }

        //if letters not accounted for at the end
        if(start!=end-1){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");

        System.out.println(segmentedIntoDictionary(dict, str));

    }

}
