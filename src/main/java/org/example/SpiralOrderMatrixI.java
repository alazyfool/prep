package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrixI {
  public static void main(String[] args) {
    Solution79 obj = new Solution79();
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    arr.add(new ArrayList<>(Arrays.asList(44)));
    arr.add(new ArrayList<>(Arrays.asList(36)));
    arr.add(new ArrayList<>(Arrays.asList(395)));
    arr.add(new ArrayList<>(Arrays.asList(179)));
    arr.add(new ArrayList<>(Arrays.asList(249)));
    arr.add(new ArrayList<>(Arrays.asList(349)));
    arr.add(new ArrayList<>(Arrays.asList(5)));
    arr.add(new ArrayList<>(Arrays.asList(139)));

    System.out.println(obj.spiralOrder(arr));
  }
}

class Solution79 {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
    ArrayList<Integer> obj = new ArrayList<>();
    int top = 0, bottom = A.size() - 1, left = 0, right = A.get(0).size() - 1;

    while (top <= bottom && left <= right) {

      for (int i = left; i <= right; i++) {
        obj.add(A.get(top).get(i));
      }
      top++;

      for (int i = top; i <= bottom; i++) {
        obj.add(A.get(i).get(right));
      }
      right--;

      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          obj.add(A.get(bottom).get(i));
        }
        bottom--;
      }

      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          obj.add(A.get(i).get(left));
        }
        left++;
      }
    }

    return obj;
  }
}
