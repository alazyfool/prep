package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        Integer[] arr = {100};
        Solution1 obj = new Solution1();
        obj.majorityElement(Arrays.asList(arr));

    }
}


class Solution1 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Integer flooredValue = (int) Math.floor(A.size() / 2);
        Integer[] finalValue = new Integer[1];

        A.forEach(element -> {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);

            } else {
                map.put(element, 1);
            }
            if (map.get(element) > flooredValue) {
                finalValue[0] = element;
            }
        });
        return finalValue[0];
    }
}
