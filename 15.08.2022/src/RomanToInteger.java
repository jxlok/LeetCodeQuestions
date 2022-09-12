//Problem Statement: Given a roman numeral, convert it to an integer. (up to 3999)

import java.util.HashMap;

public class RomanToInteger {

    public static int convert(String roman){

        HashMap<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);

        int sum =0;

        //loop through roman numerals
        for(int i=0;i<roman.length();i++){

            //last value
            if(i==roman.length()-1){
                sum+=dictionary.get(roman.charAt(i));
                continue;
            }

            //if smaller value first
            if(dictionary.get(roman.charAt(i))<dictionary.get(roman.charAt(i+1))){
                sum+=dictionary.get(roman.charAt(i+1))-dictionary.get(roman.charAt(i));
                i++;
            }
            else{
                sum+=dictionary.get(roman.charAt(i));
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String S = "MCMXCIV";
        System.out.println(convert(S));
    }

}
