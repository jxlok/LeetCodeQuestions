//Problem Statement: There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order.
// You are given an array heights of distinct integers where heights[i] represents the height of the ith person.
//
//A person can see another person to their right in the queue if everybody in between is shorter than both of them.
// More formally, the ith person can see the jth person if i < j and
// min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).
//
//Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.

import java.util.Arrays;
import java.util.Stack;

public class VisiblePeopleInQueue {

    public static int[] canSeePersonsCount(int[] heights) {
        //Time limit exceeded O(n^2)
//
//        //answer array
//        int[] answer = new int[heights.length];
//
//        for(int i=0;i<heights.length;i++) {
//            int max = 0;
//            int count =0;
//
//            //loop through following people
//            for(int j=i+1;j< heights.length;j++){
//
//                //if greater than this persons height, stop
//                if(heights[j]>heights[i]){
//                    count++;
//                    break;
//                }
//                //if taller than max, can see this person
//                if(heights[j]>max){
//                    count++;
//                    max=heights[j];
//                }
//            }
//
//            answer[i] = count;
//
//        }
//
//        return answer;

        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        //start at end
        for(int i=heights.length-1;i>=0;i--){

            int visibility = 0;

            //use stack to keep track of visible minimum from i position
            while(!stack.isEmpty() && heights[i] > stack.peek()){
                stack.pop();
                visibility++;
            }

            //heights[i] is less than or equal to something so account for it
            if(!stack.isEmpty()){
                visibility++;
            }

            stack.push(heights[i]);
            answer[i] = visibility;

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(canSeePersonsCount(heights)));
    }
}
