package GeeksForGeeks;

import java.util.ArrayList;

public class SideViewTree {
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

    public static void main(String[] args) {
        SideViewTree lv = new SideViewTree();
        lv.createTree();

        System.out.println("Left view of tree: ");
        System.out.println(lv.leftView(lv.root).toString());

        System.out.println("Right view of tree: ");
        System.out.println(lv.rightView(lv.root).toString());
    }
    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        /*
                    1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
                            \
                             8
         */
    }

    // get left view of the given tree
    ArrayList<Integer> leftView(TreeNode root){
        int height = getHeight(root);
        ArrayList<Integer> view = new ArrayList<>();

        // get first element of each level from 1 to height of the tree
        for (int i = 1; i <= height; i++) {
            view.add((getFirstInLevel(root, i)));
        }
        return view;
    }

    // returns the value of first node in a level of the tree
    int getFirstInLevel(TreeNode root, int level) {
        if (root == null || level < 0) {
            return Integer.MAX_VALUE;
        }
        else if (level == 1) {
            return root.val;
        }

        // get the value of the first node in the given level in the left subtree
        int firstInLevel = getFirstInLevel(root.left, level-1);

        if (firstInLevel == Integer.MAX_VALUE) {
            // if left subtree does not have given level
            // get the first node of the level from right subtree
            firstInLevel = getFirstInLevel(root.right, level-1);
        }

        return firstInLevel;
    }

    // get right view of the tree
    ArrayList<Integer> rightView(TreeNode root) {
        int height = getHeight(root);
        ArrayList<Integer> view = new ArrayList<>();

        // get last node of each level from 1 to height of the tree
        for (int i = 1; i <= height; i++) {
            view.add((getLastInLevel(root, i)));
        }
        return view;
    }

    // returns value of last node in the given level
   int getLastInLevel(TreeNode root, int level) {
       if (root == null || level < 0) {
           return Integer.MAX_VALUE;
       }
       else if (level == 1) {
           return root.val;
       }

       // get the value of last node of the given level in right subtree
       int lastInLevel = getLastInLevel(root.right, level-1);

       if (lastInLevel == Integer.MAX_VALUE) {
           // if right subtree does not have the level
           // get the value of last node of the given level in the left subtree
           lastInLevel = getFirstInLevel(root.left, level-1);
       }

       return lastInLevel;
   }

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
