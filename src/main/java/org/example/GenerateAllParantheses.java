package com.company;

import java.util.HashMap;
import java.util.Stack;

public class GenerateAllParantheses {
  public static void main(String[] args) {
    Solution78 obj = new Solution78();
    System.out.println(obj.isValid("()[]{}"));
  }
}

class Solution78 {
  public int isValid(String A) {
    Stack stack = new Stack();
    HashMap<Character, Character> brackets = new HashMap<>();
    brackets.put('(', ')');
    brackets.put('{', '}');
    brackets.put('[', ']');
    for (int i = 0; i < A.length(); i++) {
      if (brackets.containsKey(A.charAt(i))) {
        stack.add(A.charAt(i));
      } else {
        if (stack.empty()) {
          return 0;
        }
        if (brackets.get(stack.pop()) != A.charAt(i)) {
          return 0;
        }
      }
    }
    return stack.empty() ? 1 : 0;
  }
}

