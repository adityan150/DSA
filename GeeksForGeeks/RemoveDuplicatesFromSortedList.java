package com.aditya.DSA.GeeksForGeeks;

//https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1/

class Node
{
    int data;
    Node next;
    Node() {data = 0; next = null;}
    Node(int d) {data = d; next = null; }
}
public class RemoveDuplicatesFromSortedList {
    static Node removeDuplicates(Node head) {
        if (head.next == null)
            return head;
        Node current = head;
        Node temp;

        while(current != null && current.next != null) {

            if (current.data == current.next.data){
                temp = current.next;
                current.next = current.next.next;
                temp.next = null;      // avoid loitering
            }
            else {
                current = current.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;

        // create a sorted list with repetitions
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j < (Math.random()*10) %5; j++) {
                current.next = new Node(i);
                current = current.next;
            }
        }
        displayList(head);
        head = removeDuplicates(head);
        displayList(head);
    }
    static void displayList(Node head) {
        Node current = head;
        while(current!= null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

}
