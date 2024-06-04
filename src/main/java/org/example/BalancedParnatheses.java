package com.company;

import java.util.Stack;

public class BalancedParnatheses {
    public static void main(String[] args) {
        Solution50 obj = new Solution50();
        System.out.println(obj.solve("(()())"));
    }
}

class Solution50 {
    public int solve(String A) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.add('(');
            }
            if (A.charAt(i) == ')') {
                try {
                    if (stack.pop() != '(') {
                        return 0;
                    }
                } catch (Exception e) {
                    return 0;
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }
}
