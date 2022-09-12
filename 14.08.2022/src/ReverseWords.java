//Reverse the order of words in a given sentence.
//
//Example: "sphinx of black quartz judge my vow" should output as "vow my judge quartz black of sphinx"

import java.util.Stack;
import java.util.StringTokenizer;

//time complexity: O(n)
//space complexity: O(n)
public class ReverseWords {

    public static String reverseWordOrderInString(String str){

        //tokenise string
        StringTokenizer stringTokenizer = new StringTokenizer(str);

        StringBuilder answer = new StringBuilder();

        //use stack to hold words
        Stack<String> stack = new Stack<>();

        //add tokens to stack
        while(stringTokenizer.hasMoreTokens()){
            stack.add(stringTokenizer.nextToken());
        }

        //add words from stack into answer
        while(stack.size()!=0){
            answer.append(stack.pop());
            if(!stack.isEmpty()){
                answer.append(" ");
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String test = "sphinx of black quartz judge my vow";
        System.out.println(reverseWordOrderInString(test));
    }
}
