
package com.aditya.DSA.leetcode;

//https://leetcode.com/problems/swap-nodes-in-pairs/

//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class SwapNodesInPairs {

    public static void main(String[] args) {

        ListNode l = new ListNode();
        ListNode current = l;

        for(int i = 1; i<=4; i++) {

            current.next = new ListNode();
            current = current.next;
            current.val = i;

        }
        l = l.next;

        l = swapPairs(l);

        current = l;
        while(current != null) {

            System.out.println(current.val);
            current = current.next;

        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // insert a temporary node at the beginning of the list
        ListNode tempHead = new ListNode(0, head);
        ListNode current = tempHead;

        while(current.next != null && current.next.next != null) {

            swap(current);
            current = current.next.next;

        }

        //remove the temporary node
        head = tempHead.next;
        return head;
    }

    // 1 2 3 4 5
    // swaps two nodes next to given node l

    // e.g. l=2
    // temp = 3
    //      l   temp
    // 1 -> 2 -> 3 -> 4 -> 5

    // l.next (2.next) = temp.next (3.next which is 4)
    //   1 -> 2 -> 4 -> 5
    //(temp)  3 ---^

    // temp.next (3.next) = temp.next.next (3.next.next or 4.next which is 5)
    //        l
    //   1 -> 2 -> 4 -> 5
    //      (temp) 3 ---^

    // l.next.next (2.next.next or 4.next) = temp (3)
    //       l        temp
    //  1 -> 2 -> 4 -> 3 -> 5
    static void swap(ListNode l) {

        ListNode temp = l.next;
        l.next = temp.next;

        if(temp.next.next != null)
            temp.next = temp.next.next;
        else
            temp.next = null;

        l.next.next = temp;

    }



}
