//Problem Statement: You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint stopping you from
// robbing each of them is that adjacent houses have security systems connected and it will
// automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return
// the maximum amount of money you can rob tonight without alerting the police.

import java.util.Arrays;

public class HouseRobber {

    public static int rob(int[] nums) {

        int length = nums.length;

        //base case on empty array
        if(length==0){
            return 0;
        }

        int max = length==1 ? nums[0] : Math.max(nums[0], nums[1]);

        //loop through and from the top-down sum up the max you can rob at each position
        for(int i = length-3;i>=0;i--) {

            //edge case: if there is no third house
            if (i + 3 >= length) {
                nums[i] += nums[i + 2];
            }
            //check second and third house to see the max sum number following that
            else{
                nums[i] += Math.max(nums[i + 2], nums[i + 3]);
            }

            //set max
            max = Math.max(nums[i], nums[i+1]);

        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(rob(nums));
    }

}
