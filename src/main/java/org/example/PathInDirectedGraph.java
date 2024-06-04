package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> connections = Util.getConnections(new Integer[] {1,4,2,1,4,3,4,5,2,3,2,4,1,5,5,3,2,5,5,1,4,2,3,1,5,4,3,4,1,3,4,1,3,5,3,2,5,2});
    Solution60 obj = new Solution60();
    System.out.println(obj.solve(5, connections));
  }
}

class Solution60 {
  Node[] nodes;

  public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    nodes = new Node[A + 1 ];

    for (int i = 1; i < A + 1; i++) {
      nodes[i] = new Node(i);

    }

    // createAdjacencyList
    for (int i = 0; i < B.size(); i++) {
      nodes[B.get(i).get(0)].adjacencyList.add(B.get(i).get(1));
    }

    LinkedList<Integer> toVisit = new LinkedList<>(nodes[1].adjacencyList);
    while (!toVisit.isEmpty()) {
      Integer elementToVisit = toVisit.remove();
      if (elementToVisit == A) {
        return 1;
      }
      if (nodes[elementToVisit].visited) {
        continue;
      }
      nodes[elementToVisit].visited = true;
      toVisit.addAll(nodes[elementToVisit].adjacencyList);
    }
    return 0;
  }


  class Node {
    int value;
    boolean visited;
    ArrayList<Integer> adjacencyList;

    public Node(int value) {
      this.value = value;
      this.visited = false;
      this.adjacencyList = new ArrayList<>();
    }
  }
}

