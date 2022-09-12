//Problem Statement: There are N block from 0 to N-1.
// A couple of frogs were sitting together on one block,
// They had a quarrel and need to jump away from one another.
// The frogs can only jump to another block if the height of the other block is greater than equal to the current one.
// You need to find the longest possible distance that they can possible create between each other,
// if they also choose to sit on an optimal starting block initially.

//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class FrogQuarrel {

    public static int longestDistance(int[] blocks){

        int result=0;

        for(int i=0;i<blocks.length;i++){

            int leftMax= i;
            int rightMax =i;

            while(leftMax-1 >= 0 && blocks[leftMax] <= blocks[leftMax-1]){
                leftMax--;
            }
            while(rightMax+1 < blocks.length && blocks[rightMax] <= blocks[rightMax+1]){
                rightMax++;
            }

            result = Math.max(result, rightMax-leftMax);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] blocks = new int[]{1, 2, 1, 2, 2, 3};
        System.out.println(longestDistance(blocks));
    }
}
