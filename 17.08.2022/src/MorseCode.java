//Problem Statment: International Morse Code defines a standard encoding where each
// letter is mapped to a series of dots and dashes.

//Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

import java.util.ArrayList;
import java.util.HashSet;

public class MorseCode {

    public static int uniqueMorseRepresentations(String[] words) {

        String[] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                ".-..","--","-.","---", ".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
                "-.--","--.."};

        HashSet<String> result = new HashSet<>();
        //loop through words
        for(String word : words){

            //code for current word
            StringBuilder code = new StringBuilder();
            //loop through letters and convert
            for(char character : word.toCharArray()){
                code.append(alphabet[character-'a']);
            }
            //add to result list
            result.add(code.toString());
        }

        return result.size();

    }

    public static void main(String[] args) {
        String[] words = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

}
