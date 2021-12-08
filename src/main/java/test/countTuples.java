package test;

import java.util.Scanner;

public class countTuples {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sequence = in.nextLine();
        int number = Integer.parseInt(in.nextLine());
        String vals[] = sequence.split(",");
        int count=0;
        for(int i=0;i<vals.length-1;i++){
            int a = Integer.parseInt(vals[i].trim());
            int b = Integer.parseInt(vals[i+1].trim());
            if(number== (a+b)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
