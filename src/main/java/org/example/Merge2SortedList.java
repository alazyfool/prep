package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge2SortedList {
    public static void main(String[] args) {
        Solution67 obj = new Solution67();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,5,8));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(6,9));

        obj.merge(a, b);
        System.out.println(a);
    }
}

class Solution67 {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> temp = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                temp.add(a.get(i));
                i++;
            } else {
                temp.add(b.get(j));
                j++;
            }
        }

        for (int k = i; k < a.size(); k++) {
            temp.add(a.get(k));
        }

        for (int k = j; k < b.size(); k++) {
            temp.add(b.get(k));
        }

        a.clear();
        a.addAll(temp);

    }
}
