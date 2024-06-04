package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CharacterFrequencies {
  public static void main(String[] args) {
    Solution61 obj = new Solution61();
    System.out.println(obj.solve("interviewbit"));
  }
}

class Solution61 {
  public ArrayList<Integer> solve(String A) {
    LinkedHashMap<Character, Integer> store = new LinkedHashMap();

    for (int i = 0; i < A.length(); i++) {
      if (store.containsKey(A.charAt(i))) {
        store.put(A.charAt(i), store.get(A.charAt(i)) + 1);
      } else {
        store.put(A.charAt(i), 1);
      }
    }

    ArrayList<Integer> temp = new ArrayList<>();

    for (Integer value: store.values()) {
      temp.add(value);
    }
    return temp;
  }
}
