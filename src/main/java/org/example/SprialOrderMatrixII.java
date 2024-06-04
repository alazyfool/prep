package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SprialOrderMatrixII {
    public static void main(String[] args) {
        Solution43 obj = new Solution43();
        ArrayList<ArrayList<Integer>> answer = obj.generateMatrix(5);
        System.out.println(answer);
    }
}
class Solution43 {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>(A);
        // initialize everything
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>(Arrays.asList(new Integer[A]));
            answer.add(row);
        }

        int counter = 1;
        for (int i = 0; i < A; i++) {
            // left to right
            for (int j = i; j < A - i; j++) {
                answer.get(i).set(j, counter++);
            }

            // top to bottom
            for (int j = i + 1; j < A - i; j++) {
                answer.get(j).set(A - 1 - i, counter++);
            }

            // right to left
            for (int j = A - i - 2; j >= i; j--) {
                answer.get(A - i - 1).set(j, counter++);
            }

            // bottom to top
            for (int j = A - i - 2; j > i; j--) {
                answer.get(j).set(i, counter++);
            }
        }
        return answer;
    }
}
