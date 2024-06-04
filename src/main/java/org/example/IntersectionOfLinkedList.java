package com.company;

public class IntersectionOfLinkedList {
  public static void main(String[] args) {
    ListNode a1 = new ListNode(1);
    ListNode a2 = new ListNode(2);
    ListNode b1 = new ListNode(3);
    ListNode b2 = new ListNode(4);
    ListNode b3 = new ListNode(5);
    ListNode c1 = new ListNode(6);
    ListNode c2 = new ListNode(7);
    ListNode c3 = new ListNode(8);

    c1.next = c2;
    c2.next = c3;

    a1.next = a2;
    a2.next = c1;

    b1.next = b2;
    b2.next = b3;
    b3.next = c1;

    Solution53 obj = new Solution53();
    ListNode interestion = obj.getIntersectionNode(a1, b1);
    System.out.println(interestion.val);

  }
}


class Solution53 {
  public ListNode getIntersectionNode(ListNode a, ListNode b) {
    int count1 = getCount(a);
    int count2 = getCount(b);

    int diff = Math.abs(count1 - count2);

    if (count1 > count2) {
      ListNode currentNode1 = getNodeUntil(a, diff);
      return getIntersectionPoint(currentNode1, b);
    } else {
      ListNode currentNode2 = getNodeUntil(b, diff);
      return getIntersectionPoint(a, currentNode2);
    }
  }

  int getCount(ListNode node) {
    int count = 0;
    while (node != null) {
      if (node.next == null) {
        count++;
        node = node.next;
      } else  {
        count += 2;
        node = node.next.next;
      }
    }
    return count;
  }

  ListNode getIntersectionPoint(ListNode a, ListNode b) {
    while (a != null) { // both have same length, so looping should be fine
      if (a == b) {
        return a;
      }
      a = a.next;
      b = b.next;
    }
    return null;
  }

  ListNode getNodeUntil(ListNode node, int count) {
    for (int i = 0; i < count; i++) {
      node = node.next;
    }
    return node;
  }
}
