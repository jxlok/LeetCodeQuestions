//Problem Statement: There is a network of n servers, labeled from 0 to n - 1.
// You are given a 2D integer array edges, where edges[i] = [ui, vi] indicates there is a message channel
// between servers ui and vi, and they can pass any number of messages to each other directly in one second.
// You are also given a 0-indexed integer array patience of length n.
//
//All servers are connected, i.e., a message can be passed from one server to any other server(s) directly or
// indirectly through the message channels.
//
//The server labeled 0 is the master server. The rest are data servers. Each data server needs to send its
// message to the master server for processing and wait for a reply. Messages move between servers optimally,
// so every message takes the least amount of time to arrive at the master server. The master server will process
// all newly arrived messages instantly and send a reply to the originating server via the reversed path the message
// had gone through.
//
//At the beginning of second 0, each data server sends its message to be processed. Starting from second 1, at the
// beginning of every second, each data server will check if it has received a reply to the message it sent (including any
// newly arrived replies) from the master server:
//
//If it has not, it will resend the message periodically. The data server i will resend the message every patience[i]
// second(s), i.e., the data server i will resend the message if patience[i] second(s) have elapsed since the last time
// the message was sent from this server.
//Otherwise, no more resending will occur from this server.
//The network becomes idle when there are no messages passing between servers or arriving at servers.
//
//Return the earliest second starting from which the network becomes idle.

import java.util.*;

public class IdleNetwork {

    public static int networkBecomesIdle(int[][] edges, int[] patience) {

        HashMap<Integer, List<Integer>> directions = new HashMap<>();

        //find the directions
        for(int[] edge : edges){
            if(directions.containsKey(edge[0])){
                directions.get(edge[0]).add(edge[1]);
            }
            else{
                List<Integer> connections = List.of(edge[1]);
                directions.put(edge[0], new ArrayList<>(connections));
            }
        }

        HashSet<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int count=0;
        int curr=0;

        //from 0, go outwards until no more layers
        while(!queue.isEmpty()){

            int size = queue.size();

            //one layer out
            while(size>0) {

                curr = queue.poll();

                if (directions.get(curr) != null && !seen.contains(curr)){
                    queue.addAll(directions.get(curr));
                    seen.add(curr);
                    seen.addAll(directions.get(curr));
                    count++;
                }

                size--;
            }

        }


        System.out.println(count);
        count = 2*(count);
        System.out.println(count);


        //resulting idle time
        int timeElapsed = 0;

        //find where final packet will send prior to receiving its first return from master
        while(timeElapsed+patience[curr] < count){
            timeElapsed += patience[curr];
        }

        //result is the max of other nodes and when final packet arrives for current node
        return timeElapsed+count+1;

    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1},{0, 2},{1, 2}};
        int[] patience = {0, 2, 1};
        System.out.println(networkBecomesIdle(arr, patience));
    }
}
