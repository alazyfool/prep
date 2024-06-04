package com.company;

import java.util.ArrayList;

public class Util {
    public static <T> ArrayList<ArrayList<T>> getConnections(T[] array) {
        ArrayList<ArrayList<T>> main = new ArrayList<>();
        for (int i = 0; i < array.length; i+=2) {
            ArrayList<T> internal = new ArrayList<>();
            internal.add(array[i]);
            internal.add(array[i+1]);
            main.add(internal);
        }
        return main;
    }

    public static ListNode getHeadNode(int[] array) {
        ListNode head = new ListNode(array[0]);

        ListNode prev = head;

        for (int i = 1; i < array.length; i++) {
            ListNode current = new ListNode(array[i]);
            prev.next = current;
            prev = current;
        }
        return head;
    }

}
