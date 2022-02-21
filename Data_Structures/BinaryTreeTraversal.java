package com.aditya.DSA.Data_Structures;

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
        /*
                    1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
         */

        System.out.println("\nInorder: ");
        printInOrder(tree.root);
        System.out.println("\nPre order: ");
        printPreOrder(tree.root);
        System.out.println("\nPost order: ");
        printPostOrder(tree.root);
        System.out.println("\nInorder without recursion: ");
        inOrder(tree.root);
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
    Step 1: push the current node on stack and set current to current.left
    Step 2: if current = null, pop element and set current = current.right
    Step 3: if current = null and stack is empty, exit
     */
    static void inOrder(Node node) {
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
}
