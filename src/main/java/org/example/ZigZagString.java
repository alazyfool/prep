package com.company;

import java.util.ArrayList;

public class ZigZagString {
    public static void main(String[] args) {
        Solution68 obj = new Solution68();
        System.out.println(obj.convert("PAYPALISHIRING", 3));
    }
}
class Solution68 {
    public String convert(String A, int B) {
        if (B == 1) {
            return A;
        }
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            list.add(new ArrayList<>());
        }

        boolean reverse = false;
        int listCounter = 0;

        for (int i = 0; i < A.length(); i++) {
            list.get(listCounter).add(A.charAt(i));
            if (listCounter == B - 1) {
                reverse = true;
            } else if (listCounter == 0) {
                reverse = false;
            }

            if (reverse) {
                listCounter--;
            } else {
                listCounter++;
            }
        }

        StringBuilder s = new StringBuilder(A.length());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                s.append(list.get(i).get(j));
            }
        }
        return s.toString();
    }
}

