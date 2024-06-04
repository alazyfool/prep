package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {
  public static void main(String[] args) {
    Solution65 obj = new Solution65();
    System.out.println(obj.evalRPN(new ArrayList<String>(Arrays.asList(new String[] { "4", "13", "5", "/", "+" } ))));
  }
}

class Solution65 {
  public int evalRPN(ArrayList<String> A) {
    Stack<Integer> stack = new Stack<>();
    String number = "";
    int answer = 0;
    for (int i = 0; i < A.size(); i++) {
      String s = A.get(i);
      if (s.equals("-") || s.equals("*") || s.equals("/") || s.equals("+")) {
        Integer number1 = stack.pop();
        Integer number2 = stack.pop();
        if (s.equals("-")) {
          stack.push(number2 - number1);
        } else if (s.equals("+")) {
          stack.push(number2 + number1);
        } else if (s.equals("*")) {
          stack.push(number2 * number1);
        } else {
          stack.push(number2 / number1);
        }
      } else {
        stack.push(Integer.parseInt(s));
      }
    }

    return stack.peek();
  }
}

