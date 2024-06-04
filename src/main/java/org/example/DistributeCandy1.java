package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy1 {
  public static void main(String[] args) {
    Solution73 obj = new Solution73();
    System.out.println(obj.candy(new ArrayList<>(Arrays.asList(1, 3, 2, 1))));
  }
}

class Solution73 {
  public int candy(ArrayList<Integer> A) {
    int[] ans = new int[A.size()];

    for (int i = 0; i < A.size(); i++) ans[i] = 1;

    for (int i = 0; i < A.size() - 1; i++) {
      if (A.get(i + 1) > A.get(i)) {
        ans[i + 1] = ans[i] + 1;
      }
    }

    int sum = 0;
    for (int i = A.size() - 2; i >= 0; i--) {
      if (A.get(i) > A.get(i + 1) && ans[i] <= ans[i + 1]) {
        ans[i] = ans[i + 1] + 1;
      }
      sum += ans[i];
    }
    sum += ans[A.size() - 1];
    return sum;
  }
}
