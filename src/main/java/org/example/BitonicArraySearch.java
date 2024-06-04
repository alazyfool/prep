package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
public class BitonicArraySearch {
    public static void main(String[] args) {

        int[] ints = {1, 20, 50, 40, 10};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

        Solution40 obj = new Solution40();
        System.out.println(obj.solve((ArrayList<Integer>) list, 5));
    }
}

class Solution40 {
    public int solve(ArrayList<Integer> A, int B) {
        int max = getDeviationPoint(A);
        int answer = bs(A, 0, max, B,true);
        if (answer != -1) {
            return answer;
        }
        answer = bs(A, max, A.size(), B,false);
        if (answer != -1) {
            return answer;
        }
        return -1;
    }

    public int bs(ArrayList<Integer> arr, int low, int high, int number, boolean asc) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr.get(mid) == number) {
            return mid;
        }
        if (asc) {
            if (arr.get(mid) < number) {
                return bs(arr, mid + 1, high, number, asc);
            } else {
                return bs(arr, low, mid - 1, number, asc);
            }
        } else {
            if (arr.get(mid) < number) {
                return bs(arr, low, mid - 1, number, asc);
            } else {
                return bs(arr, mid + 1, high, number, asc);
            }
        }
    }

    public int getDeviationPoint(ArrayList<Integer> A) {
        int low = 0, high = A.size() - 1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            //if both are less, we have found the point
            if (A.get(mid - 1) < A.get(mid) && A.get(mid + 1) < A.get(mid)) {
                break;
            } else {
                if (A.get(mid + 1) > A.get(mid)) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        return mid;
    }
}
