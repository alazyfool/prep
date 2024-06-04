package com.company;

import java.util.ArrayList;

public class PascalTriangle {
  public static void main(String[] args) {
    Solution56 obj = new Solution56();
    System.out.println(obj.solve(5));
  }
}
class Solution56 {
  public ArrayList<ArrayList<Integer>> solve(int A) {
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
    if (A == 0) {
      return output;
    }

    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    output.add(a);
    if (A == 1) {
      return output;
    }

    ArrayList<Integer> b = new ArrayList<>();
    b.add(1);
    b.add(1);
    output.add(b);
    if (A == 2) {
      return output;
    }

    for (int i = 2; i < A; i++) {
      ArrayList<Integer> old = output.get(i - 1);
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(1);
      for (int j = 0; j < old.size() - 1; j++) {
        temp.add((old.get(j) + old.get(j + 1)));
      }
      temp.add(1);
      output.add(temp);
    }

    return output;

  }
}
