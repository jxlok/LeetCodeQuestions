//Problem Statement: The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
// such that each number is the sum of the two preceding ones, starting from 0 and 1.

//Given n, calculate F(n)
public class Fibonacci {

    public static int fib(int n) {

        int[] dp = new int[n+2];

        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<dp.length;i++){

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
    }

}
