package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// I am using Disjoin set along with Krushkal algorithm to solve this. Refer to Strivers' disjoint set and Krushkal algorithm
public class CommutableIsland {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
        obj.add(new ArrayList<Integer>(Arrays.asList(1,2,1)));
        obj.add(new ArrayList<Integer>(Arrays.asList(2,3,4)));
        obj.add(new ArrayList<Integer>(Arrays.asList(1,4,3)));
        obj.add(new ArrayList<Integer>(Arrays.asList(4,3,2)));
        obj.add(new ArrayList<Integer>(Arrays.asList(1,3,10)));

        Solution82 obj1 = new Solution82();
        System.out.println(obj1.solve(4, obj));

    }
}



class Solution82 {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // first sort all the edges based on the distance
        // each time check if all the edges are connected till now
        // go to each edge and see if it is not connected to the main graph - by checking ultimate parent, if not connected, then add it to the graph and increase the path length
        // once we have all the edges connected, pass it broooo

        Collections.sort(B, new PathLengthComparator());
        int total = 0;
        DisjointSet set = new DisjointSet(A);
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> temp = B.get(i);
            if (set.findUltimateParent(temp.get(0)) != set.findUltimateParent(temp.get(1))) {
                set.unionByRank(temp.get(0), temp.get(1));
                total += temp.get(2);
            }
        }
        return total;
    }
}

class PathLengthComparator implements Comparator<ArrayList<Integer>> {
    // override the compare() method
    public int compare(ArrayList<Integer> s1, ArrayList<Integer> s2)
    {
        if (s1.get(2) == s2.get(2))
            return 0;
        else if (s1.get(2) > s2.get(2))
            return 1;
        else
            return -1;
    }
}
