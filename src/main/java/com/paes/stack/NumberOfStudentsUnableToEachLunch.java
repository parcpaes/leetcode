package com.paes.stack;

import java.util.LinkedList;

public class NumberOfStudentsUnableToEachLunch {
    public static int countStudents(int[] students, int[] sandwiches) {
        byte zerosOnes[] = new byte[2];
        LinkedList<Integer> listOfStudents = new LinkedList<>();
        for (int student : students){
            zerosOnes[student]++;
            listOfStudents.add(student);
        }
        int top=0, len = sandwiches.length;
        while(zerosOnes[sandwiches[top]]>0){
            int student = listOfStudents.removeFirst();
            if(student==sandwiches[top]){
                zerosOnes[student]--;
                top++;
            }else{
                listOfStudents.addLast(student);
            }
        }
        return listOfStudents.size();
    }

    public static int countStudents2(int[] students, int[] sandwiches) {
        byte zerosOnes[] = new byte[2];
        int len = sandwiches.length,j;
        for (int student : students) zerosOnes[student]++;
        for(j=0; j<len && zerosOnes[sandwiches[j]]>0;j++){
            zerosOnes[sandwiches[j]]--;
        }
        return len-j;
    }

    public static void main(String[] args) {
        int students[] = {1};
        int sandwiches[] = {0};
        System.out.println(countStudents(students,sandwiches));
    }
}
