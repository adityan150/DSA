package Leetcode;

import java.util.*;

public class N_aryTreePreOrder {
    Node root;

    private class Node {
        int val;
        List<Node> children;

        Node() {
            val = 0;
            children = new ArrayList<>();
        }
        Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
        Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static void main(String[] args) {
        N_aryTreePreOrder tree = new N_aryTreePreOrder();
        tree.createTree();
        System.out.println(tree.preorder(tree.root).toString());
    }

    void createTree() {
        Stack<Node> S = new Stack<>();

        root = new Node(1);
        Node current = root;
        S.push(current);

        int i = 2;
        while (i <= 30) {
            int j = (int) (Math.random()*10) % 4;

            while (j-- > 0) {
                current.children.add(new Node());
            }
        }
    }

    // recursive solution
    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();

        LinkedList<Integer> order = new LinkedList<>();
        order.add(root.val);

        for (Node child: root.children) {
            order.addAll(preorder(child));
        }
        return order;
    }

    // non recursive solution
    List<Integer> preorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null)
            return output;
        stack.add(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pollLast();
            output.add(temp.val);
            Collections.reverse(temp.children);

            for (Node child: temp.children) {
                stack.add(child);
            }
        }
        return output;
    }
}
