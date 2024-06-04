package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintLongestIncreasingSubsequence {
  public static void main(String[] args) {
    Solution76 obj = new Solution76();
    ArrayList number = obj.lis(new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
    System.out.println(number);
  }
}


class Solution76 {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> lis(final List<Integer> A) {
    ArrayList[][] arr = new ArrayList[A.size()][A.size()];

    for (int i = 0; i < A.size(); i++) {
      for (int j = 0; j < A.size(); j++) {
        arr[i][j] = new ArrayList<Integer>();
      }
    }
    return solveHelper(A, 0, -1, arr);
  }

  public ArrayList solveHelper(List<Integer> A, int current, int prev, ArrayList[][] arr) {
    if (current == A.size()) {
      return new ArrayList();
    }

    if (arr[prev + 1][current].size() != 0) {
      return arr[prev + 1][current];
    }

    ArrayList list1 = new ArrayList<Integer>(), list2 = new ArrayList<Integer>();
    // take it
    if (prev == -1 || A.get(current) > A.get(prev)) {
      list1.add(A.get(current));
      list1.addAll(solveHelper(A, current + 1, current, arr));
    }

    list2.addAll(solveHelper(A, current + 1, prev, arr));

    if (list1.size() > list2.size()) {
      arr[prev + 1][current].addAll(list1);
      return list1;
    } else {
      arr[prev + 1][current].addAll(list2);
      return list2;
    }
  }
}
