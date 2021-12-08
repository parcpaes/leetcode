package com.paes.greedy;

public class p1974 {
    public static int minTimeToType(String word) {
        char prevPoint=word.charAt(0);
        int seconds=Math.min((prevPoint-'a'),26-(prevPoint-'a'));
        for(char c: word.toCharArray()){
            int move1 = Math.abs(prevPoint-c);
            int move2 =(c<prevPoint)?(('z'-prevPoint)+(c-'a')+1):(('z'- c)+(prevPoint-'a')+1);
            seconds += Math.min(move1,move2);
            prevPoint=c;
        }
        return seconds+word.length();
    }
    public static int minTimeToType2(String word) {
        char prevPoint=word.charAt(0);
        int seconds=Math.min((prevPoint-'a'),26-(prevPoint-'a'));
        for(int i=1;i<word.length();i++){
            int diff = Math.abs(word.charAt(i)-word.charAt(i-1));
            seconds+= Math.min(diff,26-diff);
        }
        return seconds+word.length();
    }
    public static void main(String[] args) {
        System.out.println(minTimeToType2("pdy"));//31

    }
}
