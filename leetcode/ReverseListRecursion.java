package com.aditya.DSA.leetcode;

public class ReverseListRecursion {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode current = list;
        for(int i = 1; i <= 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        list = list.next;
        printList(list);
        list = reverseListRec(list);
        printList(list);
    }
    public static void printList(ListNode list) {
        ListNode current = list;
        while (current != null) {
            System.out.print(current.val +" -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // reverse list using recursion
    public static ListNode reverseListRec(ListNode head) {
        // if list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }
        // Get the rest of the list reversed
        ListNode revHead = reverseListRec(head.next);
        // Reverse the link between head and head.next
        head.next.next = head;
        // Head is the last element in the reversed list
        head.next = null;
        // return head of the reversed list
        return revHead;
    }
}
