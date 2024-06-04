package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CyclesInDirectedGraph {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> numbers = Util.getConnections(new Integer[]{1, 2,2, 3 ,3, 4 ,4, 5});
        Solution49 obj = new Solution49();
        System.out.println(obj.solve(5, numbers));

    }
}

class Solution49 {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if (B.size() == 0) {
            return 0;
        }
        boolean[] visited = new boolean[A + 1];
        ArrayList<Integer>[] ajlist = new ArrayList[A + 1];
        for (int i = 1; i < A + 1; i++) {
            ajlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.size(); i++) {
            Integer target = B.get(i).get(1);
            if (visited[target]) {
                return 1;
            }
            ajlist[B.get(i).get(0)].add(target);
            visited[B.get(i).get(0)] = true;
        }
        return 0;
    }
}


