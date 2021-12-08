package com.paes.heap;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class p506 {
    public enum Rank {
        GOLD("Gold Medal"),
        SILVER("Silver Medal"),
        BRONZE("Bronze Medal");
        public String rank;
        Rank(String rank) {
            this.rank = rank;
        }
    }
    public static String[] findRelativeRanks(int[] score) {
        int indexScore[][] = new int[score.length][2];
        String rank[] = new String[score.length];
        IntConsumer fn1 = (i->{indexScore[i][0]=i;indexScore[i][1]=score[i];});
        loop(fn1,score.length);

        Arrays.sort(indexScore,(a,b)->b[1]-a[1]);

        Rank[] values = Rank.values();
        IntConsumer fn2 = (i->rank[indexScore[i][0]] =""+ ((i<values.length)?values[i].rank:i+1));
        loop(fn2,score.length);
        return rank;
    }
    public static void loop(IntConsumer fn,int len){
        for(int i=0;i<len;i++) fn.accept(i);
    }
    public static String[] findRelativeRanks2(int[] score) {
        PriorityQueue<int[]> queueScore = new PriorityQueue<>((a,b)->b[1]-a[1]);
        String rank[] = new String[score.length];
        Rank[] values = Rank.values();

        loop(i->queueScore.add(new int[]{i,score[i]}),score.length);
        loop((i->rank[queueScore.poll()[0]] =""+ ((i<values.length)?values[i].rank:i+1)),score.length);
        return rank;
    }
    public static String[] findRelativeRanks3(int[] score) {
        int len = score.length;
        Map<Integer,Integer> index = new HashMap<>();
        String rank[] = new String[len];
        Rank[] values = Rank.values();

        loop(i->index.put(score[i],i),len);

        Arrays.sort(score);

        loop((i->rank[index.get(score[len-1-i])]=""+((i<values.length)?values[i].rank:i+1)), len);
        return rank;
    }
    public static void main(String[] args) {
        int score[] = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks3(score)));
    }
}
