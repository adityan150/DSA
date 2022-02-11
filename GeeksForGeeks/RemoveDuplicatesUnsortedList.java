package com.aditya.DSA.GeeksForGeeks;

import java.util.Arrays;

public class RemoveDuplicatesUnsortedList {

    public static Node removeDuplicates(Node head) {
        boolean[] visited = new boolean[10000];
        Node current = head;
        visited[current.data] = true;

        while (current.next != null) {
            // number not visited = new number
            if (!visited[current.next.data]) {
                visited[current.next.data] = true;
                current = current.next;
            }
            // number already visited = repeated
            else {
                current.next = current.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node current = head;
        for (int i= 0; i<= 1000; i++) {
            current.next = new Node((int) (Math.random()*10));
            current = current.next;
        }
        displayList(head);
        head = removeDuplicates(head);
        displayList(head);
    }
    public static void displayList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

}
