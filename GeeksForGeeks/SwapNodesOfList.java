package GeeksForGeeks;

public class SwapNodesOfList {
    // Swap node without swapping data
    public static Node swap(Node head, int x, int y) {
        // if list has only one element or both the keys are equal
        if (head == null || head.next == null || x == y)
            return head;

        // find x node
        Node prevX = null;
        Node currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // find y node
        Node prevY = null;
        Node currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // if x or y not in the list
        if (currX == null || currY == null) {
            System.out.println("Invalid key/s: Not present in the list.");
            return head;
        }
        // if currX is not head
        if (prevX != null) {
            prevX.next = currY;
        }
        else {
            head = currY;
        }


        // if currY is not head
        if (prevY != null) {
            prevY.next = currX;
        }
        else {
            head = currX;
        }

        // swap the next nodes
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }
    public static void displayList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;

        for (int i = 2; i <= 11; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        displayList(head);
        head = swap(head, 1, 5);
        displayList(head);
    }
}
