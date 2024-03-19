package org.example;

import java.util.Stack;

public class BracketsWithStack {
    public static void main(String[] args) {

        System.out.println("BracketsWithStack!");
        System.out.println("Is properly nested: " + new BracketsWithStack().solution("{[()()]}"));
        System.out.println("Is properly nested: " + new BracketsWithStack().solution("([)()]"));
    }

    public int solution(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String ch = S.substring(i, i+1);
            if(ch.equals("(") || ch.equals("[") || ch.equals("{")){
                stack.push(ch);
            }else {
                if (stack.isEmpty()){
                    return 0;
                }
                if(ch.equals(")")){
                    if (!stack.pop().equals("(")){
                        return 0;
                    }
                }
                if(ch.equals("]")){
                    if (!stack.pop().equals("[")){
                        return 0;
                    }
                }
                if(ch.equals("}")){
                    if (!stack.pop().equals("{")){
                        return 0;
                    }
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
