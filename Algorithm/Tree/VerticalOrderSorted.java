package Algorithm.Tree;

import java.util.*;

public class VerticalOrderSorted {
    TreeNode root;
    private class Tuple {
        int hOffset;  // horizontal level of the node in tree
        int vLevel;  // vertical level of the node in tree
        TreeNode node;

        public Tuple(TreeNode node, int hOffset, int vLevel) {
            this.hOffset = hOffset;
            this.vLevel = vLevel;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        VerticalOrderSorted vo = new VerticalOrderSorted();
        vo.createTree();
        System.out.println(vo.verticalTraversal(vo.root).toString());

    }

    /* Create a test binary tree */
    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);
        root.left.right.right.left = new TreeNode(9);

        /*
                      1
                  /       \
                 2         3
              /    \     /    \
             4      6   5      7
                      \
                       --- 8
                         /
                       9

         */

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // HashMap<Horizontal, TreeMap<Vertical, Sorted elements>>
        HashMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
        Queue<Tuple> bfsQueue = new LinkedList<>();

        bfsQueue.add(new Tuple(root, 0, 0));
        int minHorizontal = 0;  // minimum horizontal offset reached
        int maxHorizontal = 0;  // maximum horizontal offset reached


        while (!bfsQueue.isEmpty()) {
            // dequeue an item
            Tuple current = bfsQueue.poll();

            // add left and right children of current node
            if (current.node.left != null) {
                bfsQueue.add(new Tuple(current.node.left, current.hOffset - 1, current.vLevel + 1));
            }
            if (current.node.right != null) {
                bfsQueue.add(new Tuple(current.node.right, current.hOffset + 1, current.vLevel + 1));
            }

            // initialize value for current horizontal offset
            map.putIfAbsent(current.hOffset, new TreeMap<>());
            // initialize value for current vertical level
            map.get(current.hOffset).putIfAbsent(current.vLevel, new PriorityQueue<>());
            // add value of current node against it's vertical level
            map.get(current.hOffset).get(current.vLevel).offer(current.node.value);

            // update minimum and maximum horizontal offsets
            minHorizontal = Math.min(minHorizontal, current.hOffset);
            maxHorizontal = Math.max(maxHorizontal, current.hOffset);
        }

        // create a list of lists to store vertical order traversal
        List<List<Integer>> verticalOrder = new ArrayList<>();

        // traverse through map
        for (int i = minHorizontal; i <= maxHorizontal; i++) {
            // create a list to store elements in same horizontal offset
            List<Integer> verticalNums = new ArrayList<>();

            // get value from map for the given horizontal offset
            TreeMap<Integer, PriorityQueue<Integer>> verticalMap = map.get(i);

            // traverse through the inner TreeMap
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry: verticalMap.entrySet()) {
                // add all the priority queues in same horizontal but different verticals in a single list
                verticalNums.addAll(new ArrayList<>(entry.getValue()));
            }
            // add the list to the result list of lists
            verticalOrder.add(verticalNums);
        }
        return verticalOrder;
    }



}
