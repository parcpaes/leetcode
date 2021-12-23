package com.paes.heap;

import java.util.Arrays;

public class MaximumScoreFromRemovingStones1753 {
    public static int maximumScore(int a, int b, int c) {
        int piles[] = {a,b,c};
        int score = 0;
        Arrays.sort(piles);
        while(piles[0]>0){
            if(piles[0]>1 && piles[2]==piles[1]){
                int even = (piles[0]%2==0)?piles[0]: piles[0]-1;
                int diff = (even>>1);
                piles[0]-=even;
                piles[1]-=diff;
                piles[2]-=diff;
                score+=even;
            }else{
                piles[0]--;
                score++;
                piles[2]--;
            }
            Arrays.sort(piles);
        }
        return score+piles[1];
    }

    public static int maximumScore2(int a,int b,int c){
        int piles[] = {a,b,c};
        Arrays.sort(piles);
        if(piles[2]>(piles[0]+piles[1]))
            return piles[0]+piles[1];
        return piles[2]+((piles[0]+piles[1]-piles[2])>>1);
    }

    public static void main(String[] args) {
        int a=1,b=8,c=8;
        System.out.println(maximumScore(a,b,c));
    }
}
