package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    ArrayList<String> something = new ArrayList<>();
    something.add("abcd");
    something.add("abc");
    something.add("abde");
    Solution33 obj = new Solution33();
    System.out.println(obj.longestCommonPrefix(something));
  }
}

class Solution33 {
  public String longestCommonPrefix(ArrayList<String> A) {
    String common = "";
    char current;
    for (int i = 0; i < A.get(0).length(); i++) {
      try{
        current = A.get(0).charAt(i);
        for (int j = 1; j < A.size(); j++) {
          if (A.get(j).charAt(i) != current) {
            throw new IndexOutOfBoundsException();
          }
        }
      } catch(IndexOutOfBoundsException e) {
        break;
      }
      common += current;
    }

    return common;
  }

  public String longestCommonPrefix(String[] strs) {
    String common = "";
    char current;
    for (int i = 0; i < strs[0].length(); i++) {
      try{
        current = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
          if (strs[j].charAt(i) != current) {
            throw new IndexOutOfBoundsException();
          }
        }
      } catch(IndexOutOfBoundsException e) {
        break;
      }
      common += current;
    }

    return common;
  }
}
