//Problem Statement: There are n dominoes in a line, and we place each domino vertically upright.
// In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
//
//After each second, each domino that is falling to the left pushes the adjacent domino on the left.
// Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
//
//When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
//
//For the purposes of this question, we will consider that a falling domino expends no additional force to
// a falling or already fallen domino.
//
//You are given a string dominoes representing the initial state where:
//
//dominoes[i] = 'L', if the ith domino has been pushed to the left,
//dominoes[i] = 'R', if the ith domino has been pushed to the right, and
//dominoes[i] = '.', if the ith domino has not been pushed.
//Return a string representing the final state.
//
//

import java.util.Arrays;

public class PushDominoes {

    public static String pushDominoes(String dominoes) {
//
//        int len = dominoes.length();
//        //create array for left pushes
//        int[] leftArray = new int[len];
//        //create array for right pushed
//        int[] rightArray = new int[len];
//        int leftStart = 0;
//        int rightStart=0;
//
//        int count=0;
//        boolean start = false;
//        //loop through and keep count of direction and distance from initial left push
//        for(int i=len-1;i>=0;i--){
//            //if first push found
//            if(dominoes.charAt(i)=='L'){
//                count=1;
//                start=true;
//                leftStart = i;
//            }
//
//            leftArray[i]= count;
//
//            if(start){
//                count++;
//            }
//        }
//
//        start = false;
//        count=0;
//        //loop through and keep count of direction and initial right push
//        for(int i=0;i<len;i++){
//            //if first push found
//            if(dominoes.charAt(i)=='R'){
//                count=1;
//                start=true;
//                rightStart=i;
//            }
//
//            rightArray[i] = count;
//
//            if(start){
//                count++;
//            }
//
//        }
//
//        StringBuilder result = new StringBuilder();
//        //loop through both arrays and compare two arrays
//        for(int i=0;i<len;i++){
//
//            //if equal, add .
//            if(leftArray[i]==rightArray[i]){
//                result.append(".");
//            }
//            //if left is smaller but undefined
//            else if(leftArray[i]<rightArray[i] && leftArray[i]==0){
//                if(i<leftStart) {
//                    result.append(".");
//                }
//                else{
//                    result.append("R");
//                }
//            }
//            else if(rightArray[i]<leftArray[i] && rightArray[i]==0){
//                if(i>rightStart){
//                    result.append(".");
//                }
//                else {
//                    result.append("L");
//                }
//            }
//            else if(leftArray[i]<rightArray[i]){
//                result.append("L");
//            }
//            else{
//                result.append("R");
//            }
//        }
//
//        return result.toString();

        int left=0;
        int len = dominoes.length();
        char[] dom = dominoes.toCharArray();

        for(int right =0;right<len;right++){

            //if empty, then skip
            if(dom[right]=='.'){
                continue;
            }
            //if empty on left or between two left forces, fill with L's
            else if((dom[right]==dom[left]) ||dom[left]=='.'&&dom[right]=='L'){

                for(int k=left;k<right;k++){
                    dom[k] = dom[right];
                }
            }
            //dont overlap
            else if(dom[left]=='L'&&dom[right]=='R'){

            }
            //overlap
            else if(dom[left]=='R'&&dom[right]=='L'){
                //get midpoint
                int between = (right-left-1)/2;
                //loop to centre and make changes
                for(int k=1;k<=between;k++){
                    dom[right-k] = 'L';
                    dom[left + k] = 'R';
                }
            }

            left=right;
        }

        if(dom[left]=='R'){
            for(int k=left;k<len;k++){
                dom[k] = 'R';
            }
        }

        return new String(dom);
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        System.out.println(pushDominoes(dominoes));
    }
}
