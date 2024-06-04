package com.company;

public class SwapNodes {
    public static void main(String[] args) {
        Solution2 obj = new Solution2();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode answer =  obj.swapPairs(one);

        // debug and see if the return is correct
        System.out.println(answer);
    }
}
class Solution2 {
    public ListNode swapPairs(ListNode A) {
        if (A.next == null) {
            return A;
        }

        ListNode list = A;
        ListNode answerNode = A.next;

        while (list != null && list.next != null) {
            ListNode node1 = list;
            ListNode node2 = list.next;
            ListNode node3 = list.next.next;


            if (node3 != null && node3.next != null) {
                node1.next = node3.next;
            } else  {
                node1.next = node3;
            }
            node2.next = node1;
            list = node3;
        }
        return answerNode;


    }
}

/**
 * Definition for singly-linked list. */
 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
