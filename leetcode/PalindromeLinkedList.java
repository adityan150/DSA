package com.aditya.DSA.leetcode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode stack = new ListNode();
        ListNode queue = new ListNode();

        ListNode current = head;
        int i = 0;
        while (current != null) {
            ListNode temp = new ListNode(current.val, stack);
            stack = temp;
            current = current.next;
            i++;
        }
        i = (i % 2 == 0)? i/2 : 1 + (1/2);
        current = head;

        while (i-- != 0) {
            if (stack.val != current.val)
                return false;
            stack = stack.next;
            current = current.next;
        }
        return true;
    }
}
