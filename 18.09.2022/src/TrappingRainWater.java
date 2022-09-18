//Problem Statement: Given n non-negative integers representing an elevation
// map where the width of each bar is 1, compute how much water it can trap after raining.

public class TrappingRainWater {

    public static int trap(int[] height) {

        int length = height.length;

        int[] leftRight = new int[length];
        int max = Integer.MIN_VALUE;

        //go left to right and create a new array with max value
        for(int i=0;i<length;i++){

            //if new max found, set
            if(height[i]>max){
                max = height[i];
            }

            leftRight[i] = max;
        }

        //reset max
        max=Integer.MIN_VALUE;
        int[] rightLeft = new int[length];
        //loop right to left and create new array with max value
        for(int i=length-1;i>=0;i--){

            //if new max found, set
            if(height[i]>max){
                max = height[i];
            }

            rightLeft[i] = max;
        }

        int[] minimum = new int[length];
        //loop through leftRight and RightLeft and create new array with minimum value
        for(int i=0;i<length;i++){

            minimum[i] = Math.min(leftRight[i], rightLeft[i]);
        }

        int sum=0;
        //loop through and subtract the real height from minimum heights
        for(int i=0;i<length;i++){

            sum+=minimum[i]-height[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] heights = {4,2,0,3,2,5};
        System.out.println(trap(heights));
    }
}
