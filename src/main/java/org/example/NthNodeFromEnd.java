package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class NthNodeFromEnd {
//    1->2->3->4->5
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        Solution41 something = new Solution41();
        ListNode modified = something.removeNthFromEnd(node1, 1);
        System.out.println(modified.val);

    }

}



class Solution41 {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        // created a linked list for n elements, and remove first and add the second
        Queue<ListNode> queue = new LinkedList<ListNode>();
        ListNode slow = A;
        while (slow != null) {
            // handle if it is the very first element
            if (queue.size() == B + 1) {
                queue.remove();
            }
            queue.add(slow);
            slow = slow.next;
        }
        if (B >= queue.size()) {
            return queue.remove().next;
        }

        ListNode previousElement = queue.remove();
        if (queue.remove().next != null) {
            ListNode nextElement = queue.remove();
            previousElement.next = nextElement;
        } else {
            previousElement.next = null;
        }
        return A;
    }
}