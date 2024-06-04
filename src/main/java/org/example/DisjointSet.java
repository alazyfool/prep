package com.company;

public class DisjointSet {
    int[] rank;
    int[] parent;

    // consider as array starting from 1
    DisjointSet(int number) {
        rank = new int[number + 1];
        parent = new int[number + 1];

        // initialize parent
        for (int i = 1; i <= number; i++) {
            parent[i] = i;
        }
    }

    int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    void unionByRank(int a, int b) {
        int ultimateParentA = findUltimateParent(a);
        int ultimateParentB = findUltimateParent(b);

        if (ultimateParentA == ultimateParentB) {
            return;
        }

        if (rank[ultimateParentA] < rank[ultimateParentB]) {
            parent[ultimateParentA] = ultimateParentB;
        } else if (rank[ultimateParentB] < rank[ultimateParentA]) {
            parent[ultimateParentB]= ultimateParentA;
        } else {
            parent[ultimateParentB] = ultimateParentA;
            rank[ultimateParentA]++;
        }
    }
}