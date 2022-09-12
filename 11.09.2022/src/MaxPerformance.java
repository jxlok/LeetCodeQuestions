//Problem Statement: You are given two integers n and k and two integer arrays speed and efficiency both of
// length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and
// efficiency of the ith engineer respectively.
//
//Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
//
//The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
//
//Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformance {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] players = new int[n][2];

        //fill players with speed and efficieny
        for(int i=0;i<n;i++){
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }

        //descending order
        Arrays.sort(players, (a, b) -> (b[0]-a[0]));

        //priority queue as smallest is removed first
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>();
        long teamPreference =0;
        long teamSpeed =0;

        //loop through
        for(int i=0;i<n;i++){

            //if too big remove the smallest number and check
            if(speedQueue.size() >=k){
                teamSpeed -= speedQueue.remove();
            }

            speedQueue.add(players[i][1]);
            teamSpeed+=players[i][1];

            //multiply teamSpeed by current players efficiency and see if bigger
            teamPreference = Math.max(teamPreference, teamSpeed*players[i][0]);
        }

        return (int) (teamPreference % 1000000007);
    }

    public static void main(String[] args) {
    }
}
