package com.company;

public class ClimbingStairs {
  public static void main(String[] args) {
    Solution77 obj = new Solution77();
    int num = 10;
    int[] dp = new int[num];
    for (int i = 0; i < num; i++) {
      dp[i] = -1;
    }

    System.out.println(obj.climbStairs(0, num, dp));
  }
}



class Solution77 {
  public int climbStairs(int current, int end, int[] dp) {
    if (current == end) {
      return 1;
    } else if (current > end) {
      return 0;
    }

    if (dp[current] != -1) {
      return dp[current];
    }

    dp[current] = climbStairs(current + 1, end, dp) + climbStairs(current + 2, end, dp);
    return dp[current];
  }
}