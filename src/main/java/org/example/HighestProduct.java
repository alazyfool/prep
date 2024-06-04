package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighestProduct {
  public static void main(String[] args) {
    int[] ints = {0, -1, -2, -3};
    List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

    Solution36 obj = new Solution36();
    System.out.println(obj.maxp3((ArrayList<Integer>) list));


  }
}


class Solution36 {
  public int maxp3(ArrayList<Integer> A) {
    Collections.sort(A);
    Integer[] arr;
    if (A.size() < 5) {
      arr = A.toArray(new Integer[A.size()]);
    } else {

       arr = new Integer[5];
    }

    int i = 0;
    int j = A.size() - 1;
    int count1 = 0;
    int count2 = 0;

    if (arr.length == 5) {
      while (count1 < 2 || count2 < 3) {

        if (count2 < 3) {
          if (A.get(j) != 0) {
            arr[4 - count2] = A.get(j);
            count2++;
          }
        }

        if (count1 < 2) {
          if (A.get(i) != 0) {
            arr[count1] = A.get(i);
            count1++;
          }
        }

        i++;
        j--;
      }
    }
    return Math.max(arr[0] * arr[1] * arr[arr.length - 1], arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3]);
  }
}
