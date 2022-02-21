package com.aditya.DSA.GeeksForGeeks;

import com.aditya.DSA.leetcode.ListNode;

public class ReverseListInGroup {
    public static Node reverse(Node node, int k) {
        int i = 1;
        Node current = node;
        while (current != null) {
            if (i % k == 0) {
                node = reverseBetween(node, i-(k-1), i);
            }
            current = current.next;
            i++;
        }

        return node;
    }

    // reverse middle part of the list from node position left to node position right
    public static Node reverseBetween(Node head, int left, int right) {
        Node beforeLeft = null;                  //  stores node previous to left node
        Node leftNode;

        Node current = head;
        Node previous = null;
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
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;

            count ++;
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

    // Test client
    public static void main(String[] args) {
        Node list = new Node(0);
        Node current = list;

        // push values
        for(int i = 1; i <= 14; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        // trim
        list = list.next;

        printList(list);
        list = reverse(list, 5);
        printList(list);
    }

    public static void printList(Node list) {
        Node current = list;
        while (current != null) {
            System.out.print(current.data +" -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
