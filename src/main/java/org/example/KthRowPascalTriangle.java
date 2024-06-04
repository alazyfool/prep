package com.company;

import java.util.ArrayList;

public class KthRowPascalTriangle {
    public static void main(String[] args) {
        Solution122 obj = new Solution122();
        System.out.println(obj.getRow(6));
    }
}
class Solution122 {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> answer = new ArrayList<>();
        int next = 1;

        if (A == 0) {
            answer.add(1);
            return answer;
        }

        answer.add(1);

        for (int i = 0; i < A-1; i++) {
            next = next * (A - i);
            next = (int)(next / ((i + 1) * 1.0));
            answer.add(next);
        }

        answer.add(1);

        return answer;
    }
}
