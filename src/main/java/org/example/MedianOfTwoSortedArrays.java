package com.company;

import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    Solution69 obj = new Solution69();
    System.out.println(obj.findMedianSortedArrays(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40), Arrays.asList(-2)));
  }
}

class Solution69 {
  // DO NOT MODIFY BOTH THE LISTS
  public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
    if (a.size() > b.size()) {
      // a should always be smaller
      return findMedianSortedArrays(b, a);
    }

    int m = a.size();
    int n = b.size();

    int noOfElements = (m + n + 1) / 2;

    int low = 0;
    int high = m;

    while (low <= high) {
      int mid1 = (low + high) / 2;
      int mid2 = noOfElements - mid1;

      int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
      int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;


      if (mid1 - 1 >= 0) l1 = a.get(mid1 - 1);
      if (mid2 - 1 >= 0) l2 = b.get(mid2 - 1);

      if (mid1 < m) r1 = a.get(mid1);
      if (mid2 < n) r2 = b.get(mid2);

      if (l1 <= r2 && l2 <= r1) {
        if ((m + n) % 2 == 1) {
          return Math.max(l1, l2);
        }
        return (((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0);
      }

      if (l2 > r1) low = mid1 + 1;
      if (l1 > r2) high = mid1 -  1;


    }

    return 0;
  }
}
