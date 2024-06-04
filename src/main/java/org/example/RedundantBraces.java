package com.company;

import java.util.Stack;

public class RedundantBraces {
  public static void main(String[] args) {
    Solution34 obj = new Solution34();
    System.out.println(obj.braces("((a+b)+(e+(c*d)))/(a+c)"));
  }
}

class Solution34 {
  public int braces(String A) {
    Stack<Character> characters = new Stack<>();
    int issues = 0;

    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) != ')') {
        characters.add(A.charAt(i));
      } else {
       int variableCounter = 0;
       int operatorCounter = 0;

       while (!characters.empty()) {
         char temp = characters.pop();
         if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
             operatorCounter++;
         } else if (temp == '(') {
           break;
         } else {
             variableCounter++;
         }
       }
       // if no operator counter and one variable counter

       if (operatorCounter == 0 && variableCounter == 1) {
         issues++;
       } else if (variableCounter == 0 && operatorCounter == 0) {
           issues++;
       }
      }
    }

    return issues;
  }
}




