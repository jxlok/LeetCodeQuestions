//Problem statement: Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

import java.util.HashMap;

public class FirstUniqueChar {

    public static int firstUniqChar(String s){

        HashMap<Character, Integer> dictionary = new HashMap<>();

        //add values to dictionary
        for(int i=0;i<s.length();i++){

            //if value already in dictionary
            if(dictionary.get(s.charAt(i))!=null){
                dictionary.put(s.charAt(i), -1);
            }
            //new value
            else{
                dictionary.put(s.charAt(i), i);
            }

        }

        //keep track of earliest appearance

        int first = s.length();
        //loop through and find position
        for(int position : dictionary.values()){

            if(position!=-1){
                if(position<first){
                    first=position;
                }
            }
        }

        //no unique char found
        if(first == s.length()) {
            return -1;
        }

        return first;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
