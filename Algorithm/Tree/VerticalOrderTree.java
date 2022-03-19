package com.aditya.DSA.Algorithm.Tree;

import java.util.*;

// unsorted
public class VerticalOrderTree {
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
    private class Pair {
        int hLevel;
        TreeNode node;

        public Pair(int hLevel, TreeNode node) {
            this.hLevel = hLevel;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        VerticalOrderTree vo = new VerticalOrderTree();
        vo.createTree();
        System.out.println(vo.getVerticalOrder(vo.root).toString());
    }

    /* Create a test binary tree */
    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);
        root.left.right.right.left = new TreeNode(9);

        /*
                      1
                  /       \
                 2         3
              /    \     /    \
             4      5   6      7
                      \
                       --- 8
                         /
                       9

         */

    }

    public List<List<Integer>> getVerticalOrder(TreeNode root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<Pair> bfsQueue = new LinkedList<>();  // contains nodes in level order traversal
        bfsQueue.add(new Pair(0, root));

        int minHLevel = 0;
        int maxHLevel = 0;

        // while there is at least one bfsQueue node
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();

            while (size-- != 0) {
                // if bfsQueue is not empty, dequeue one item and enqueue both its children
                Pair current = bfsQueue.poll();
                minHLevel = Math.min(minHLevel, current.hLevel);
                maxHLevel = Math.max(maxHLevel, current.hLevel);

                if (current.node.left != null) {
                    bfsQueue.add(new Pair(current.hLevel - 1, current.node.left));
                }
                if (current.node.right != null) {
                    bfsQueue.add(new Pair(current.hLevel + 1, current.node.right));
                }

                // process the dequeued item
                map.putIfAbsent(current.hLevel, new ArrayList<>());
                map.get(current.hLevel).add(current.node.val);
            }
        }
        for (int i = minHLevel; i <= maxHLevel; i++) {
            verticalOrder.add(map.get(i));
        }
        return verticalOrder;
    }

}
