package com.aditya.DSA.Data_Structures;

import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal extends BinaryTree{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.right.right = new Node(9);

        tree.root.right.left.left = new Node(10);
        tree.root.right.left.left.right = new Node(11);
        /*
                     1
                  /     \
                2        3
              /  \      /  \
             4    5    6    7
            /      \  /
           8       9  10
                       \
                       11
         */

        System.out.println("\nInorder: ");
        printInOrder(tree.root);
        System.out.println("\nPre order: ");
        printPreOrder(tree.root);
        System.out.println("\nPost order: ");
        printPostOrder(tree.root);
        System.out.println("\nInorder without recursion: ");
        inOrderStack(tree.root);
        System.out.println("\nPreOrder without recursion: ");
        preOrderStack(tree.root);
        System.out.println("\nPost order without recursion: ");
        postOrderStack(tree.root);
    }

    static void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        // left root right
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    static void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        // root left right
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    static void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        // left right root
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }

    /*
    In-order: left root right
    Step 1: push the current node on stack and set current to current.left, reach left most node
    Step 2: if current = null, pop element and set current = current.right
    Step 3: if current = null and stack is empty, exit
     */
    static void inOrderStack(Node node) {
        Stack<Node> S = new Stack<>();

        Node current = node;

        while (current != null || !S.isEmpty()) {
            while (current != null) {
                S.push(current);
                current = current.left;
            }
            current = S.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }
    }

    /*
    Pre-Order: Root left right
    Step 1: Print current node, push it onto the stack, set current = current.left, reach left most node
    Step 2: Pop an element from stack, set current = current.right
    Step 3: if current is null and stack is empty, exit
     */
    static void preOrderStack(Node node) {
        Stack<Node> S = new Stack<>();

        Node current = node;

        while (current != null || !S.isEmpty()) {

            while (current != null) {
                System.out.print(current.key + " ");
                S.push(current);
                current = current.left;
            }
            current = S.pop();
            current = current.right;
        }
    }

    /*
    Post order: left right root
    Step 1: If current node has a right child, push it first, then push current on the stack,
            set current = current.left, reach left most node
    Step 2: Set current = popped element from stack
    Step 3: if current has a right child AND stack is not empty AND current.right is at top of stack
            pop node from top of stack
            push current on the stack
            set current = popped node
    Step 4: else print current and set current to null
     */
    static void postOrderStack(Node root) {
        Stack<Node> S = new Stack<>();
        Node current = root;

        while (current != null || !S.isEmpty()) {
            // go to left most node in current subtree
            while (current != null) {
                // push right child on stack
                if (current.right != null) S.push(current.right);
                // push current
                S.push(current);
                // move to left child
                current = current.left;
            }
            // current is/becomes null
            // pop item from stack
            current = S.pop();

            // if popped node's right subtree is unprocessed
            // if right child of current is still in stack
            if (!S.isEmpty() && current.right != null && current.right == S.peek()) {
                // pop the right child to process it
                // push the current/parent node on stack to process later
                Node temp = S.pop();
                S.push(current);
                current = temp;
            }
            else {
                // right child is already processed
                // add the current node to result list
                // left subtree is processed or does not have a left child
                // set current to null to skip moving to left subtree in next iteration
                System.out.print(current.key + " ");
                current = null;
            }
        }
    }
}
