//Problem Statement: You have an initial power of power, an initial score of 0, and a bag of tokens
// where tokens[i] is the value of the ith token (0-indexed).
//
//Your goal is to maximize your total score by potentially playing each token in one of two ways:
//
//If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
//If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
//Each token may be played at most once and in any order. You do not have to play all the tokens.
//
//Return the largest possible score you can achieve after playing any number of tokens.

import java.util.Arrays;

public class PowerAndTokens {

    public static int bagOfTokensScore(int[] tokens, int power) {


        //greedy algorithm
        int score =0;

        //sort tokens from smallest
        Arrays.sort(tokens);

        //iterators for start and end
        int start=0;
        int end=tokens.length-1;

        //iterate through each token
        while(start<=end){

            //see if smallest can be played
            if(tokens[start]<=power){
                power -= tokens[start];
                score++;
                start++;
            }
            //else use score to get largest power back
            else{
                if(score>0 && start!=end){

                    power += tokens[end];
                    score--;

                }
                end--;
            }


        }

        return score;
    }

    public static void main(String[] args) {
        int[] tokens = {100};
        System.out.println(bagOfTokensScore(tokens, 50));
    }
}
