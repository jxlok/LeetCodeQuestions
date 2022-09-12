//Problem Statement: You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
//
//Return the sum of all subarray ranges of nums.
//
//A subarray is a contiguous non-empty sequence of elements within an array.



//Time Complexity: O(n^2)
//Space Complexity: O(1)
public class SumOfSubArrays {

    public static long sumOfSubArrays(int[] nums){

        long result = 0;


        //iterate through array of ints and locate the max and minimum as we iterate through
        for(int i=0; i<nums.length;i++){
            long min = nums[i];
            long max = nums[i];
            for(int j=i+1;j<nums.length;j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += Math.abs(max-min);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, -2, -3, 4, 1};
        System.out.println(sumOfSubArrays(nums));
    }
}
