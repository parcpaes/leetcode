package com.paes.array;

public class p2011 {
    public static int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String operation: operations)
            x+=(operation.contains("+"))?1:-1;
        return x;
    }
    public static void main(String[] args) {
        String operations[] = {"X++","++X","--X","X--"};
        System.out.println(finalValueAfterOperations(operations));
    }
}
