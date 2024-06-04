package com.company;

import java.util.Arrays;
import java.util.List;

public class RotatedArray {
  public static void main(String[] args) {
    Solution57 obj = new Solution57();
    List q = Arrays.asList(7,8,9,10,2,3,4,5);
    System.out.println(obj.findMin(q));
  }
}

class Solution57 {
  // DO NOT MODIFY THE LIST
  public int findMin(final List<Integer> a) {

    int low = 0;
    int high = a.size() - 1;

    if (a.size() == 1) {
      return a.get(0);
    }
    if (a.get(low) < a.get(high)) {
      // this is ascending order
      return a.get(0);
    }
    if (a.get(high) < a.get(high - 1)) {
      return a.get(high);
    }

    while (low <= high) {
      int mid = (low + high) / 2;
      if (a.get(mid) < a.get(mid - 1)) {
        return a.get(mid);
      }
      if (a.get(low) > a.get(mid)) {
        high = mid;
      } else {
        low = mid;
      }
    }
    return a.get(high);
  }
}

