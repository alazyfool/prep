package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesInterviewBit {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Solution31 obj = new Solution31();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        System.out.println(obj.removeDuplicates(arr));
        System.out.println(Arrays.asList(arr));
    }
}

class Solution31 {
    int removeDuplicates(ArrayList<Integer> a) {
        int lastNum = -1;
        int pointer = 0;
        int unique = 0;
        for (int i = 0; i < a.size(); i++) {
            if (lastNum != a.get(i)) {
                lastNum = a.get(i);
                a.set(pointer, a.get(i));
                pointer++;
                unique++;
            }
        }

        return unique;
    }
}

