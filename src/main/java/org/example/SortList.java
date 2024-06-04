package com.company;

public class SortList {
  public static void main(String[] args) {
    Solution64 obj = new Solution64();
    ListNode l1 = Util.getHeadNode(new int[] {6,5,4,3,2,1});
    ListNode sorted = obj.sortList(l1);
    System.out.println(sorted);

  }
}
class Solution64 {
  public ListNode sortList(ListNode list1) {
    if (list1 == null || list1.next == null) {
      return list1;
    }
    ListNode midNode = getMidNode(list1);
    ListNode list2 = midNode.next;
    midNode.next = null;

    list1 = sortList(list1);
    list2 = sortList(list2);

    return mergeSortedList(list1, list2);
  }

  ListNode mergeSortedList(ListNode list1, ListNode list2) {

    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    ListNode head = new ListNode(0);
    ListNode current = head;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }

    if (list1 == null) {
      current.next = list2;
    }
    if (list2 == null) {
      current.next = list1;
    }

    return head.next;
  }

  ListNode getMidNode(ListNode node) {
    ListNode slow = node;
    ListNode fast = node;

    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}

