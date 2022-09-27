//Problem Statement: You are given an array of strings equations that represent
// relationships between variables where each string equations[i] is of length 4 and takes
// one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different)
// that represent one-letter variable names.
//
//Return true if it is possible to assign integers to variable names to satisfy all the given equations, or false otherwise.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SatisfyingEqualityEquations {

    static int[] connections = new int[26];
    public static boolean equationsPossible(String[] equations) {

        //fill connections with its alphabet sequence number
        for (int i = 0; i < 26; i++) {
            connections[i] = i;
        }

        //loop through equal equations
        for (String equation : equations) {

            if (equation.charAt(1) == '=') {
                //find connection network of each character
                int val1 = findConnection(equation.charAt(0) - 'a');
                int val2 = findConnection(equation.charAt(3) - 'a');

                //if not the same, make them the same (accounts for same characters)
                if (val1 != val2) {
                    connections[val2] = val1;
                }
            }
        }

        //loop through and check non equals
        for(String equation:equations) {
            if(equation.charAt(1)=='!') {
                //get connection network value
                int val1 = findConnection(equation.charAt(0) - 'a');
                int val2 = findConnection(equation.charAt(3) - 'a');

                //if equals, return false
                if (val1 == val2) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int findConnection(int character) {
        //if disconnected, return character
        //otherwise, find 
        return connections[character]==character ? character : (connections[character]=findConnection(connections[character]));
    }

//    public static boolean equationsPossible(String[] equations) {
//
//        //Hashmap for storing characters with a given value
//        HashMap<Character, List<Character>> hashMap = new HashMap<>();
//
//        //loop through strings
//        for(String equation : equations) {
//
//            char num1 = equation.charAt(0);
//            char num2 = equation.charAt(3);
//            char operator = equation.charAt(1);
//
//            //if operator is equal
//            if (operator == '=') {
//
//                //both exist
//                if (hashMap.containsKey(num1)&&hashMap.containsKey(num2)) {
//                    hashMap.get(num1).addAll(hashMap.get(num2));
//                    hashMap.get(num2).addAll(hashMap.get(num1));
//                    hashMap.get(num1).add(num2);
//                    hashMap.get(num2).add(num1);
//                }
//                //num1 exist but num2 does not
//                else if(hashMap.containsKey(num1)&&!hashMap.containsKey(num2)){
//
//                    hashMap.put(num2, hashMap.get(num1));
//                    hashMap.get(num1).add(num2);
//                    hashMap.get(num2).add(num1);
//                }
//                //num1 doesnt exist but num2 exists
//                else if (hashMap.containsKey(num2) && !hashMap.containsKey(num1)) {
//                    hashMap.put(num1, hashMap.get(num2));
//                    hashMap.get(num1).add(num2);
//                    hashMap.get(num2).add(num1);
//                }
//                //both don't exist
//                else {
//                    List<Character> list1 = List.of(num1);
//                    hashMap.put(num2, new ArrayList<>(list1));
//                    List<Character> list2 = List.of(num2);
//                    hashMap.put(num1, new ArrayList<>(list2));
//
//                }
//            }
//        }
//
//
//        for(String equation: equations){
//
//            char num1 = equation.charAt(0);
//            char num2 = equation.charAt(3);
//            char operator = equation.charAt(1);
//
//            //not equal
//            if(operator=='!') {
//
//                //same char
//                if(num1==num2){
//                    return false;
//                }
//                 //if exists in hashmap and equal
//                if(hashMap.containsKey(num1) && hashMap.containsKey(num2) && (hashMap.get(num1).contains(num2)||hashMap.get(num2).contains(num1))){
//                    return false;
//                }
//            }
//
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        String[] equations = {"a==b","b!=c","c==a"};
        System.out.println(equationsPossible(equations));
    }
}
