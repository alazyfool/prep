package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class kthNodeFromMiddleLinkedList {
    public static void main(String[] args) {
//        1 -> 14 -> 6 -> 16 -> 4 -> 10
//        ListNode n1 = new ListNode(1);
//        ListNode n14 = new ListNode(14);
//        ListNode n6 = new ListNode(6);
//        ListNode n16 = new ListNode(16);
//        ListNode n4 = new ListNode(4);
//        ListNode n10 = new ListNode(10);
//
//        n1.next = n14;
//        n14.next = n6;
//        n6.next = n16;
//        n16.next = n4;
//        n4.next = n10;
//
        Solution39 obj = new Solution39();

        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n7 = new ListNode(7);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n16 = new ListNode(16);
        ListNode n15 = new ListNode(15);
        ListNode n61 = new ListNode(61);
        ListNode n162 = new ListNode(16);

        n3.next = n4;
        n4.next = n7;
        n7.next = n5;
        n5.next = n6;
        n6.next = n16;
        n16.next = n15;
        n15.next = n61;
        n61.next = n162;

        System.out.println(obj.solve(n3, 3));

        ListNode n468 = new ListNode(468);
        ListNode n335 = new ListNode(335);

        n468.next = n335;
//        System.out.println(obj.solve(n468, 1));

    }
}

class Solution39 {
    public int solve(ListNode A, int B) {
        LinkedList<Integer> queue = new LinkedList<>();
        ListNode slow = A, fast = A;
        int count = B;
        while (fast != null && fast.next != null) {
            if (count != 0) {
                queue.add(slow.val);
                count--;
            } else {
                queue.removeFirst();
                queue.add(slow.val);
            }
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        if (queue.size() == B) {
            return queue.peekFirst();
        }
        return -1;
    }
}