package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class MergeIntervals {
  public static void main(String[] args) {
    Solution66 obj = new Solution66();
    // [[1,3],[6,9]]
    ArrayList<Interval> allIntervals = new ArrayList<>();
    allIntervals.add(new Interval(3,5));
    allIntervals.add(new Interval(8,10));

//    [1,2],[3,5],[6,7],[8,10],[12,16]
//    [4,9]

    Interval newInterval = new Interval(1,12);

    ArrayList<Interval> answer = obj.insert(allIntervals, newInterval);

    System.out.println(answer);
  }
}


/**
 * Definition for an interval. */
class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}
class Solution66 {
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    Stack<Interval> stack = new Stack<>();
    boolean merged = false;

    for (int i = 0; i < intervals.size() ; i++) {
      if (!merged) {
        if (intervals.get(i).start < newInterval.start) {
          mergeByLookingAtTop(stack, intervals.get(i));
        } else {
          mergeByLookingAtTop(stack, newInterval);
          merged = true;
          i--;
        }
      } else {
        mergeByLookingAtTop(stack, intervals.get(i));
      }
    }

    if (!merged) {
      stack.push(newInterval);
    }
    return new ArrayList<>(stack);
  }

  public void mergeByLookingAtTop(Stack<Interval> stack, Interval newInterval) {
    if (stack.empty()) {
      stack.push(newInterval);
    }
    Interval top = stack.peek();
    if (top.end < newInterval.start) {
      stack.push(newInterval);
    } else {
      stack.pop();
      top.end = Math.max(top.end, newInterval.end);
      stack.push(top);
    }
  }
}
