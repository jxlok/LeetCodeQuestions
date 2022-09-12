//Problem Statement: You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class ClimbingSteps {

    public static int climbStairs(int n) {

        int[] dp = new int[n+3];

        //base cases
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //add previous two
        for(int i=3;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
