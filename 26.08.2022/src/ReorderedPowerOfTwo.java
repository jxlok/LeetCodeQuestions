//Problem Statement: You are given an integer n.
// We reorder the digits in any order (including the original order) such that the leading digit is not zero.
//
//Return true if and only if we can do this so that the resulting number is a power of two.

import java.util.HashMap;

public class ReorderedPowerOfTwo {

//    public static boolean reorderedPowerOf2(int n) {
//
//        String num = String.valueOf(n);
//        String[] answer = new String[1];
//
//        //try every combination of digits in n
//        calculatePermutations(answer, num, "");
//
//        return answer[0] != null;
//    }
//
//    public static void calculatePermutations(String[] answer, String newNumbers, String usedNumbers) {
//
//        //all numbers used
//        if (newNumbers.length() == 0) {
//
//            //check if the number is a power of 2
//            if (isPowerOfTwo(Integer.parseInt(usedNumbers)) && usedNumbers.charAt(0)!='0') {
//                answer[0] = usedNumbers;
//                return;
//            }
//
//        }
//
//        //recursively check other combinations
//        for(int i=0;i<newNumbers.length();i++) {
//
//            char ch = newNumbers.charAt(i);
//
//            calculatePermutations(answer, newNumbers.substring(0, i)+newNumbers.substring(i+1), usedNumbers+ch);
//        }
//    }
//
//    public static boolean isPowerOfTwo(int n){
//        //for non 0, the bitwise & of a power of 2 and its -1 should equal 0 (ex 4: 100, 3: 011)
//        return (n != 0 && (n & (n - 1)) == 0);
//
//    }

    public static boolean reorderedPowerOf2(int n) {

        String num = String.valueOf(n);

        HashMap<Character, Integer> letters = new HashMap<>();


        for(int i=0;i<num.length();i++){
            if(letters.containsKey(num.charAt(i))){
                letters.put(num.charAt(i), letters.get(num.charAt(i))+1);
            }
            else {
                letters.put(num.charAt(i), 1);
            }
        }

        int power = 0;
        String twoPower="";

        //while power of two number has less digits than input number
        while(twoPower.length() <= num.length()){

            twoPower = String.valueOf((int) Math.pow(2, power++));

            //if lengths are same
            if(twoPower.length()==num.length()){

                //tracker
                boolean valid = true;

                //reset tmp hashmap
                HashMap<Character, Integer> tmp = new HashMap<>(letters);

                //loop through and validate all digits are present
                for(int i=0;i<twoPower.length();i++){
                    char ch = twoPower.charAt(i);
                    if(tmp.containsKey(ch) && tmp.get(ch)!=0){
                        tmp.put(ch, tmp.get(ch)-1);
                    }
                    else{
                        valid = false;
                        break;
                    }
                }


                if(valid){
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(125));
    }
}

