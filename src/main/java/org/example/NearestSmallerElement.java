package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) {
        Solution9 obj = new Solution9();
        Integer[] arr = {1, 6, 4, 10, 2, 5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
        System.out.println(obj.prevSmaller(a));
    }
}
class Solution9 {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            if (!stack.empty() && stack.peek() >= A.get(i)) {
                while (!stack.empty() && stack.peek() >= A.get(i)) {
                    stack.pop();
                }
            }

            if (!stack.empty() && stack.peek() < A.get(i)) {
                answer.add(stack.peek());
            }

            if (stack.empty()) {
                answer.add(-1);
            }

            stack.add(A.get(i));
        }
        return answer;
    }
}
