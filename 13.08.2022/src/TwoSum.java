//Problem Statement: Given an array of integers and a value,
// determine if there are any two integers in the array whose sum is equal to the given value.
// Return true if the sum exists, and false if it does not.

//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class TwoSum {

    public static boolean validTwoSum(int[] array, int target){

        //loop through array
        for(int i=0;i<array.length;i++){
            //find difference
            int difference = target - array[i];
            //loop through and search for difference
            for(int j=i+1;j<array.length;j++){
                if(array[j] == difference){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {5,7,1,2,8,4,3};
        System.out.println(validTwoSum(test, 7));
    }
}
