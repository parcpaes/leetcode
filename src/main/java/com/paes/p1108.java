package com.paes;

import java.util.Scanner;

public class p1108 {
    public static String defangIPaddr(String address){
        return address.replaceAll("\\.","[.]");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String ip = in.next();
            System.out.println(defangIPaddr(ip));
        }
    }
}
