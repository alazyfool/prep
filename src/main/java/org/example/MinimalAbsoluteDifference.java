package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimalAbsoluteDifference {
    public static void main(String[] args) {
        Solution83 obj = new Solution83();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-6, 1, 8, 10));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(6,9,15));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(2,3,6,6));
        System.out.println(obj.solve(a,b,c));
    }
}


class Solution83 {

    /*
    Explanation:
    this is the overall ask of the problem


    Math.min(Abs(Max(a,b,c) - Min(a,b,c)))
    if you can see we have to minimize the difference between the maximum and minimum element
    start with 0 for all the 3 arrays
    now, check the difference between the smallest and largest element, update the min if it is smaller than what we already have
    because we want to decrease the gap between min and max element, and the biggest element is also smallest for that array, the only
    thing we can do is to increase the element among those 3 to decrease the gap, now, decrease the gap and check this whole thing again

     */
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int a = 0, b = 0, c = 0, min = Integer.MAX_VALUE;
        while (a < A.size() && b < B.size() && c < C.size()) {
            min = Math.min(min, Math.abs(Math.max(A.get(a), Math.max(B.get(b), C.get(c))) - Math.min(A.get(a), Math.min(B.get(b), C.get(c)))));
            if (A.get(a) < B.get(b)) {
                if (A.get(a) < C.get(c)) {
                    a++;
                } else {
                    c++;
                }
            } else {
                if (B.get(b) < C.get(c)) {
                    b++;
                } else {
                    c++;
                }
            }
        }

        return min;
    }


    // this solution isn't working, ignore this
    public int solve1(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // find the smallest array
        // try to find the same element, if not found, go ahead and chose the closest element, this last part of this step is a bit tricky
        // now, compare the difference and
        // the absolute part is when we are checking the difference, so binary search should be fine

        if (B.size() > A.size() && B.size() > C.size()) {
            return solve(B, A, C);
        } else if (C.size() > A.size() && C.size() > B.size()) {
            return solve(C, A, B);
        }

        int diff = Integer.MAX_VALUE;

        // till here, A would be the biggest one
        for (int i = 0; i < A.size(); i++) {
            int target = A.get(i);
            // for each element,do a binary search in both the other arrays, if any of high, low, mid is lower than -1, discard it and choose between other two
            // search in B
            int low1 = 0, high1 = B.size() - 1, mid1 = -1;
            boolean find1 = false;
            while (low1 <= high1) {
                mid1 = (low1 + high1) / 2;
                if (B.get(mid1) == target) {
                    find1 = true;
                    break;
                } else if (B.get(mid1) > target) {
                    high1 = mid1 - 1;
                } else {
                    low1 = low1 + 1;
                }
            }

            int low2 = 0, high2 = C.size() - 1, mid2 = -1;
            boolean find2 = false;
            while (low2 <= high2) {
                mid2 = (low2 + high2) / 2;
                if (C.get(mid2) == target) {
                    find2 = true;
                    break;
                } else if (C.get(mid2) > target) {
                    high2 = mid2 - 1;
                } else {
                    low2 = low2 + 1;
                }
            }
            // do check to remember for -1 index
           if (find1 && find2) {
               return 0;
           }

           int a = target, b, c;

           if (find1) {
               b = target;
               c = findNearest(C, target, low2, high2);
           } else if (find2) {
               c = target;
               b = findNearest(B, target, low1, high1);
           } else {
               b = findNearest(B, target, low1, high1);
               c = findNearest(C, target, low2, high2);
           }
           diff =  Math.min(diff, (Math.abs(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)))));
        }

        return diff;
    }

    int findNearest(ArrayList<Integer> arr, int target, int low, int high) {
        if (high < 0) {
            return arr.get(low);
        }
        if (low >= arr.size()) {
            return arr.get(high);
        }

        if (Math.abs(target - arr.get(low)) < Math.abs(target - arr.get(high))) {
            return arr.get(low);
        } else {
            return arr.get(high);
        }

    }
}

