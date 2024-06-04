//import java.util.List;
//
////  Definition for singly-linked list.
//class ListNode {
//  int val;
//  ListNode next;
//  ListNode() {}
//  ListNode(int val) { this.val = val; }
//  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//
//class Solution {
//    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode temp = new ListNode();
//        ListNode current = temp;
//        int carry = 0;
//        int addition;
//        while (l1 != null && l2 != null) {
//            addition = l1.val + l2.val + carry;
//            carry = addition / 10;
//            addition %= 10;
//            current.next = new ListNode(addition);
//            current = current.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null) {
//            addition = l1.val + carry;
//            carry = addition / 10;
//            addition %= 10;
//            current.next = new ListNode(addition);
//            current = current.next;
//            l1 = l1.next;
//            // loop, use carry and append l2
//        }
//        while (l2 != null) {
//            addition = l2.val + carry;
//            carry = addition / 10;
//            addition %= 10;
//            current.next = new ListNode(addition);
//            current = current.next;
//            l2 = l2.next;
//            // loop, use carry and append l1
//        }
//
//        if (carry != 0) {
//            current.next = new ListNode(carry);
//        }
//        return temp.next;
//    }
//}
//
//public class AddTwoNumbers {
//    public static void main(String[] args) {
//        Solution obj = new Solution();
//        ListNode obj1 = new ListNode(2);
//        obj1.next = new ListNode(4);
//        obj1.next.next = new ListNode(3);
//
//        ListNode obj2 = new ListNode(5);
//        obj2.next = new ListNode(6);
//        obj2.next.next = new ListNode(6);
//
//        ListNode ste = obj.addTwoNumbers(obj1, obj2);
//        System.out.println(ste.val);
//    }
//}