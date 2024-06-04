package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        Solution obj = new Solution();
    }
}

class Solution5 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        List<Integer> small;
        List<Integer> large;

        HashMap<Integer, Integer> unique = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int last = -1;

        if (A.size() > B.size()) {
            large = A;
            small = B;
        } else {
            large = B;
            small = A;
        }

        small.forEach(element -> {
            unique.merge(element, 1, Integer::sum);
        });


        for (Integer element : large) {
            if (unique.get(element) != null && unique.get(element) > 0) {
                answer.add(element);
                unique.put(element, unique.get(element) - 1);
            }
        }
        return answer;

    }
}
