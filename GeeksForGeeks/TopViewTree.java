package com.aditya.DSA.GeeksForGeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewTree {
    TreeNode root;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private class Tuple {
        TreeNode node;
        int horizontal;

        Tuple (TreeNode node, int horizontal) {
            this.node = node;
            this.horizontal = horizontal;
        }
    }

    public static void main(String[] args) {
        TopViewTree top = new TopViewTree();
        top.createTree();
        System.out.println(top.topView(top.root).toString());
    }

    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.right = new TreeNode(8);
        root.right.left.right.right = new TreeNode(9);
        root.right.left.right.right.right = new TreeNode(10);

        /*
                    1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
                       \
                        8
                         \
                          9
                           \
                            10
         */
    }

    ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> top = new ArrayList<>();

        Queue<Tuple> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Tuple(root, 0));
        top.add(root.val);
        int minHorizontal = 0;
        int maxHorizontal = 0;

        while (!bfsQueue.isEmpty()) {
            Tuple current = bfsQueue.poll();

            // process the dequeued item
            if (current.horizontal > maxHorizontal || current.horizontal < minHorizontal) {
                top.add(current.node.val);
            }

            // update the minimum and maximum horizontal distances added in result
            minHorizontal = Math.min(minHorizontal, current.horizontal);
            maxHorizontal = Math.max(maxHorizontal, current.horizontal);

            if (current.node.left != null) {
                bfsQueue.add(new Tuple(current.node.left, current.horizontal - 1));
            }
            if (current.node.right != null) {
                bfsQueue.add(new Tuple(current.node.right, current.horizontal + 1));
            }

        }
        return top;
    }
}
