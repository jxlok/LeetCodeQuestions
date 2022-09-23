//Problem Statement: Given an integer n, return the decimal value of the binary string formed by
// concatenating the binary representations of 1 to n in order, modulo 109 + 7.

import java.math.BigInteger;

public class ConcatenationOfBinaryNumbers {

    public static int concatenatedBinary(int n) {
//
//        StringBuilder binary = new StringBuilder();
//
//        for(int i=1;i<=n;i++) {
//            binary.append(Integer.toBinaryString(i));
//        }
//
//        double decimal = Double.parseDouble(binary.toString());
//        return (int) (decimal%(1000000000+7));

        long result=0;
        final long modulo = (long) (1e9 + 7);
        int bitShift = 0;

        //loop through numbers
        for(int i=1;i<=n;i++){

            //if increase in size binary size, bitshift increases, i.e if 1000 & 111 then increase detected and
            //bitshift for concatenation also increases
            if((i & (i-1))==0){
                bitShift++;
            }

            //bit shift and add i while geting the remainder
            result = ((result<<bitShift) + i)%modulo;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(12));
    }
}
