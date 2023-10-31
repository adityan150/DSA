package Leetcode;
// https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode walker = head;         // slow pointer
        ListNode runner = head;         // fast pointer

        // loop until null is found
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            // walker == runner; fast pointer caught slow pointer
            //loop present in linked list
            if (walker == runner)
                return true;
        }

        // loop breaks if null pointer is found
        // which means loop is not present in linked list
        return false;
    }
}
