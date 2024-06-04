package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {
  public static void main(String[] args) {
    Solution58 obj = new Solution58();
    ArrayList bulbs = new ArrayList(Arrays.asList(0, 1, 0, 1));
    System.out.println(obj.bulbs(bulbs));
  }
}

class Solution58 {
  public int bulbs(ArrayList<Integer> A) {
    Integer match = 1;
    int counter = 0;

    for (int i = 0; i < A.size(); i++) {
      if (!(A.get(i).equals(match))) {
        counter++;
        if (match.equals(1)) {
          match = 0;
        } else {
          match = 1;
        }
      }
    }
    return counter;
  }
}
