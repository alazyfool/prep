package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class SmallerOrEqual {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Integer[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Collections.addAll(numbers, arr);
        Solution10 ans = new Solution10();
        System.out.println(ans.solve(numbers, 1));

    }
}

class Solution10 {
    public int solve(ArrayList<Integer> A, int B) {
        // if not present, look side and decide the value
        // if found, go to right to find the last occurrence of same value
        int low = 0, high = A.size() - 1, mid = -1;
        boolean found = false;

        while (low <= high) {
            mid = (low + high) / 2;
            if (A.get(mid) == B) {
                found = true;
                break;
            }
            if (A.get(mid) < B) {
                low = mid + 1;
            }

            if (A.get(mid) > B) {
                high = mid - 1;
            }
        }

        System.out.println(mid);

        if (found) {
            while(mid+1 < A.size() && A.get(mid + 1) == B) {
                mid++;
            }
        } else if (A.get(mid) > B){
            mid--;
        }
        return mid+1;
    }
}


