package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
  public static void main(String[] args) {
    SolutionHist obj = new SolutionHist();

    ArrayList<ArrayList<Integer>> q = new ArrayList<>();
    q.add(new ArrayList(Arrays.asList(new Integer[]{1,1,1})));
    q.add(new ArrayList(Arrays.asList(new Integer[]{0,1,1})));
    q.add(new ArrayList(Arrays.asList(new Integer[]{1,0,0})));

    System.out.println(obj.maximalRectangle(q));

    System.out.println(obj.largestRectangleArea(new int[]{0,2,2}));
  }
}
class SolutionHist {

  public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
    int max = 0;
    if (A.size() == 0) {
      return max;
    }

    int a = A.get(0).size();
    int[] arr = new int[a];

    for (int i = 0; i < A.size(); i++) {
      for (int j = 0; j < a; j++) {
        if (A.get(i).get(j) == 1)  {
          arr[j] = arr[j] + 1;
        } else {
          arr[j] = 0;
        }
      }
      max = Math.max(max, largestRectangleArea(arr));
    }

    return max;
  }

  public int largestRectangleArea(int[] heights) {

    Stack<Integer> stk = new Stack<>();
    int max = -1;

    for (int i = 0; i <= heights.length; i++) {
      while (!stk.empty() && (i == heights.length || heights[stk.peek()] >= heights[i])) {
        int height = heights[stk.pop()];
        int width;

        if (stk.empty()) width = i;
        else width = i - stk.peek() - 1;
        max = Math.max(max, (height * width));
      }
      stk.add(i);
    }
    return max;
  }
}