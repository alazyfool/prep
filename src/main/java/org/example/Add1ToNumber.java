package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Add1ToNumber {
  public static void main(String[] args) {
    ArrayList<Integer> number = new ArrayList<>();
    number.add(0);
    number.add(0);
    number.add(4);
    number.add(4);
    Solution44 obj = new Solution44();
    System.out.println(obj.plusOne(number).toString());
  }
}
class Solution44 {
  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    boolean carry = true;
    int i;
    for (i = A.size() - 1; i >= 0 && carry; i--) {
      if (A.get(i) + 1 == 10) {
        A.set(i, 0);
      } else {
        A.set(i, A.get(i) + 1);
        carry = false;
      }
    }
    if (carry) {
      if (i == -1) {
        A.add(0, 1);
      } else {
        A.set(i, 1);
      }
    }

    boolean numberReceived = false;
    ArrayList<Integer> indexToRemove = new ArrayList<>();
    for (i = 0; i < A.size() && !numberReceived; i++) {
      if (A.get(i) == 0) {
        indexToRemove.add(i);
      } else {
        numberReceived = true;
      }
    }

    for (i = indexToRemove.size() - 1; i >= 0; i--) {
      A.remove((int)indexToRemove.get(i));
    }

    return A;
  }
}
