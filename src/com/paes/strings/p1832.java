package com.paes.strings;
// Check if the Sentence Is Pangram
public class p1832 {
    public static boolean checkIfPangram(String sentence) {
        int nbOfLetter = 26;
        boolean letters[] = new boolean[nbOfLetter];
        for(char c:sentence.toCharArray()){
            int index =  (c-'a');
            if(!letters[index]){
                letters[index]=true;
                nbOfLetter--;
            }
        }
        return nbOfLetter==0;
    }
    public static boolean checkIfPangram2(String sentence){
        int seen=0;
        for(char c: sentence.toCharArray()){
            int index = c-'a';
            seen = seen | (1<<index);
        }
        return seen==((1<<26)-1);
    }
    public static void main(String[] args) {
        String sentence ="thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram2(sentence));
        int x = 67108863;
        for(int i=0;i<10;i++){
            x = x&(x-1);
            System.out.println(Integer.toBinaryString(x));
        }
    }
}
