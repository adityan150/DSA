package com.aditya.DSA.leetcode;
import java.util.Scanner;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, current = result;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode l1 = new ListNode();
        int i,j;
        System.out.println("Enter number of elements in list 1");
        i = sc.nextInt();
        System.out.println("Enter number of elements in list 2");
        j = sc.nextInt();
        System.out.println("Enter list 1:");
        inputList(l1, i);

        ListNode l2 = new ListNode();
        System.out.println("Enter list 2:");
        inputList(l2, j);

        ListNode result = addTwoNumbers(l1, l2);
        displayList(result);

    }
    static void inputList(ListNode l, int i) {
        Scanner sc = new Scanner(System.in);
        ListNode head = l;
        while(i-- > 0) {
            head.val = sc.nextInt();
            head.next = new ListNode();
            head = head.next;
        }
    }
    static void displayList(ListNode l) {
        ListNode head = l;
        while(true) {
            System.out.print(head.val + " ");
            if(head.next == null)
                break;
            head = head.next;
        }
        System.out.println();
    }

}
