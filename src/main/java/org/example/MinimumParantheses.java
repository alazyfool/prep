package com.company;

import java.util.Stack;

public class MinimumParantheses {
    public static void main(String[] args) {
        Solution51 obj = new Solution51();
        System.out.println(obj.solve(")))("));
    }
}

class Solution51 {
    public int solve(String A) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.add('(');
            }
            if (A.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(')');
                }
            }
        }
        return stack.size();
    }
}
