//Problem Statement: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
//And then read line by line: "PAHNAPLSIIGYIR"

import java.util.HashMap;

//Time Complexity: O(n)
//Space Complexity: O(n), length of rows in hashmap
public class ZigZagConversion {

    public static String convert(String s, int numRows) {


        HashMap<Integer, String> rows = new HashMap<>();

        boolean asc = false;
        int currentRow=0;

        //loop through string
        for(int i=0;i<s.length();i++){

            //if empty, add first character
            if(rows.get(currentRow)==null){
                rows.put(currentRow, ""+s.charAt(i));
            }
            //not empty, concatenate to end
            else {
                rows.put(currentRow, rows.get(currentRow) + s.charAt(i));
            }

            //if bottom limit reached, switch direction
            if(currentRow==numRows-1){
                asc = true;
            }
            else if(currentRow==0){
                asc=false;
            }

            //change row value depending on direction
            if(asc){
                currentRow--;
            }
            else{
                currentRow++;
            }
        }

        //add strings on each row to answer
        StringBuilder result = new StringBuilder();
        for(String stringInRows : rows.values()){
            result.append(stringInRows);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "A";
        System.out.println(convert(s, 1));
    }
}
