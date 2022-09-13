//Problem Statement: Given an integer array data representing the data, return whether
// it is a valid UTF-8 encoding
// (i.e. it translates to a sequence of valid UTF-8 encoded characters).
//
//A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
//
//For a 1-byte character, the first bit is a 0, followed by its Unicode code.
//For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0,
// followed by n - 1 bytes with the most significant 2 bits being 10.
//This is how the UTF-8 encoding would work:
//
//     Number of Bytes   |        UTF-8 Octet Sequence
//                       |              (binary)
//   --------------------+-----------------------------------------
//            1          |   0xxxxxxx
//            2          |   110xxxxx 10xxxxxx
//            3          |   1110xxxx 10xxxxxx 10xxxxxx
//            4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
//x denotes a bit in the binary form of a byte that may be either 0 or 1.
//
//Note: The input is an array of integers. Only the least significant 8 bits of each integer
// is used to store the data. This means each integer represents only 1 byte of data.

public class UTF8 {

    public static boolean validUtf8(int[] data) {

        int count=0;

        //loop through
        for(int i=0;i<data.length;i++){

            int value = data[i];

            //if new number
            if(count==0){

                //find number of bytes following this byte
                if((value >> 5) == 0b110){
                    count=1;
                }
                else if((value >> 4) == 0b1110){
                    count=2;
                }
                else if((value>>3) == 0b11110){
                    count=3;
                }
                else if((value>>7) !=0){
                    return false;
                }
            }
            //part of a sequence of bytes, check for 10....
            else{
                if((value>>6) != 0b10){
                    return false;
                }
                count--;
            }
        }

        return count==0;
    }

    public static void main(String[] args) {
        int[] data = {248, 130, 130, 130};
        System.out.println(validUtf8(data));
    }
}
