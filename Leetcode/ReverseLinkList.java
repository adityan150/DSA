package Leetcode;
// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkList {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode current = list;
        for(int i = 1; i <= 10; i++) {
            current.next = new ListNode();
            current = current.next;
            current.val = i;
        }
        list = list.next;
        printList(list);
        list = reverseList(list);
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
    public static ListNode reverseList(ListNode head) {
        // if list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        ListNode previous = head;           // slow pointer
        ListNode current = previous.next;   // fast pointer
        previous.next = null;               // becomes the last node of reversed list

        while (current != null) {
            // store node next to current before reversing the link
            ListNode temp = current.next;
            current.next = previous;        // reverse the link
            // move the pointer forward by one step
            previous = current;
            current = temp;
        }
        // when the list is reversed, current == null
        // and previous stores the last node, which is now first node of reversed list
        head = previous;
        return head;
    }
}
