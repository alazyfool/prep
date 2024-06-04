package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {
  public static void main(String[] args) {
    Solution80 obj = new Solution80();
    ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
    temp.add(new ArrayList(Arrays.asList(2)));
    temp.add(new ArrayList(Arrays.asList(10)));
    temp.add(new ArrayList(Arrays.asList(16)));
    temp.add(new ArrayList(Arrays.asList(30)));
    temp.add(new ArrayList(Arrays.asList(44)));
    temp.add(new ArrayList(Arrays.asList(57)));
    temp.add(new ArrayList(Arrays.asList(64)));
    temp.add(new ArrayList(Arrays.asList(75)));
    temp.add(new ArrayList(Arrays.asList(81)));
    temp.add(new ArrayList(Arrays.asList(91)));

    System.out.println(obj.searchMatrix(temp, 2));
  }
}


class Solution80 {
  public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
    int m = A.size();
    int n = A.get(0).size();

    int low = 0, high = m * n - 1;
    int mid = -1;
    while (low <= high) {
      mid = (low + high) / 2;
      if (A.get(mid / n).get(mid % n) == B) {
        return 1;
      } else if (A.get(mid / n).get(mid % n) < B) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return 0;

  }
}
