package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GasStation {
  public static void main(String[] args) {
    Solution62 obj = new Solution62();
    ArrayList A = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList B = new ArrayList(Arrays.asList(3, 4, 5, 1, 2));
    System.out.println(obj.canCompleteCircuit(A, B));
  }
}

class Solution62 {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

    int totaldiff = 0;
    int totalLeftInTank = 0;
    int validPoint = 0;

    for (int i = 0; i < A.size(); i++) {
      int diff = A.get(i) - B.get(i);
      totaldiff += diff;
      totalLeftInTank += diff;

      if (totalLeftInTank < 0) {
        validPoint = i + 1;
        totalLeftInTank = 0;
      }

    }

    return totaldiff < 0 ? -1 : validPoint;

  }
}
