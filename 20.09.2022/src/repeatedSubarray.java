//Problem Statement: Given two integer arrays nums1 and nums2,
// return the maximum length of a subarray that appears in both arrays.

public class repeatedSubarray {

    public static int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length+1][nums2.length+1];

        //max value
        int max = 0;

        //loop through dp
        for(int i=1;i<nums1.length+1;i++){

            for(int j=1;j<nums2.length+1;j++){

                //if same, set current index to 1+upper left value
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;

                    //if new max found, set
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
        }

        return max;


    }

    public static void main(String[] args) {
        int[] nums1= {0,0,0,0,0};//{1,2,3,2,1};
        int[] nums2 = {0,0,0,0,0};//{3,2,1,4,7};

        System.out.println(findLength(nums1, nums2));
    }
}
