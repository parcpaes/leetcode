package test;

import java.util.Scanner;

public class Triple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sequence = in.nextLine();
        int number = Integer.parseInt(in.nextLine());
        String vals[] = sequence.split(",");
        int count=0;
        for(int i=0;i<vals.length-2;i++){
            int a = Integer.parseInt(vals[i].trim());
            int b = Integer.parseInt(vals[i+1].trim());
            int c = Integer.parseInt(vals[i+2].trim());
            if(number== (a+b+c)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
