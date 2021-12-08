package com.paes;

import java.util.Scanner;

public class p1678 {
    public static String interpret(String command){
        String result = command;
        result = command.replace("()","o");
        result = result.replace("(al)","al");
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(interpret(in.next()));
        }
    }
}
