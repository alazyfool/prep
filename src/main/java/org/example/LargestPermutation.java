package com.company;

import java.util.*;

public class LargestPermutation {
    public static void main(String[] args) {
        Solution59 obj = new Solution59();
        System.out.println(obj.solve(new ArrayList<>(Arrays.asList( 8, 3, 9, 7, 6, 2, 5, 4, 1)), 3));
    }
}

class Solution59 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> indexes = new HashMap<>();
        for(int i = 0; i < A.size(); i++) {
            indexes.put(A.get(i), i);
        }

        for (int i = 0; i < A.size() && B > 0; i++) {
            int highIndex = indexes.get(A.size() - i);
            if (highIndex != i) {
                // swap number at both the indexes
                int temp = A.get(i);
                A.set(i, A.get(highIndex));
                A.set(highIndex, temp);

                // update the hashmap by updating the index of elements
                indexes.put(temp, highIndex);
                indexes.put(A.size() - i, i);
                B--;

            }

        }


        return A;
    }

}

