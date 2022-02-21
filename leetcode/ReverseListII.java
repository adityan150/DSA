package com.aditya.DSA.leetcode;

// https://leetcode.com/problems/reverse-linked-list-ii/


public class ReverseListII {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode current = list;

        // push values
        for(int i = 1; i <= 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        // trim
        list = list.next;

        printList(list);
        list = reverseBetween(list, 5, 12);
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

    // reverse middle part of the list from node position left to node position right
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode beforeLeft = null;                  //  stores node previous to left node
        ListNode leftNode;

        ListNode current = head;
        ListNode previous = null;
        // counter
        int count = 0;

        // reach the left node
        while (current != null && count != left) {
            // if next node is the left point
            if (count + 1 == left) {
                beforeLeft = previous;
            }
            previous = current;
            current = current.next;
            count ++;
        }
        // loop breaks when count == left, previous stores the left node
        leftNode = previous;

        while (current != null && count != right) {
            ListNode nextNode = current.next;        //  temporary variable
            // reverse link of current node
            current.next = previous;
            previous = current;
            current = nextNode;

            count++;
        }
        // previous stores the last node with reverse link
        if (beforeLeft == null) {
            head = previous;
        }
        else {
            beforeLeft.next = previous;
        }
        // current stores the first node with unreversed link
        leftNode.next = current;

        return head;
    }

}
