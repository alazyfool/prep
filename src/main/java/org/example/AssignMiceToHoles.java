package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {
  public static void main(String[] args) {
    Solution46 obj = new Solution46();
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> b = new ArrayList<>();
    a.add(-2);

    b.add(-6);

    System.out.println(obj.mice(a, b));
  }
}


class Solution46 {
  public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
    Collections.sort(A);
    Collections.sort(B);

    int total = 0;

    for (int i = 0; i < A.size(); i++) {
      total = Math.max(total, Math.abs(A.get(i) - B.get(i)));
    }
    return total;
  }
}
