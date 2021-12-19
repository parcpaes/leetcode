package com.paes.stack;

import java.util.*;
import java.util.function.Consumer;

public class BaseBallGame682 {
    static final HashMap<String, Consumer<Deque<Integer>>> mapOperations = new HashMap<>();
    static{
        mapOperations.put("+",(stack)->{
            int last = stack.pop();
            int sum = last+stack.peek();
            stack.push(last);
            stack.push(sum);
        });
        mapOperations.put("D",(stack)-> stack.push(stack.peek()*2));
        mapOperations.put("C",(stack)-> stack.pop());
    }
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;
        for (String operation : ops) {
            if(mapOperations.get(operation)==null){
                stack.push(Integer.valueOf(operation));
            }else{
                mapOperations.get(operation).accept(stack);
            }
        }
        for (int score : stack) total+=score;
        return total;
    }
}
