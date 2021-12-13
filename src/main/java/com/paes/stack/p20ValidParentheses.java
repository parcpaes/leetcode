package com.paes.stack;

import java.util.*;

/*
problem: 20.
Valid Parentheses.
Input: s = "()[]{}"
Output: true

Input: s = "([)]"
Output: false
*/
public class p20ValidParentheses {
    public Map<Character,Character> openClose = Map.of('(',')','[',']','{','}');
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character: s.toCharArray()) {
            Character opened = openClose.get(character);
            if(opened!=null) stack.push(opened);
            else if(stack.isEmpty() || stack.pop()!=character) return false;
        }
        return stack.isEmpty();
    }
}
