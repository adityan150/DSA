package Algorithm.Tree;

//    public class TreeNode {
//        int value;
//        TreeNode left, right;
//        TreeNode(int value) {
//            this.value = value;
//            left = right = null;
//        }
//    }

public class LevelOrderTraversal {
    TreeNode root;

    public static void main(String[] args) {
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.root = lvl.createTree();
        lvl.printLevelOrder(lvl.root);
    }

    // create a test binary tree
    public TreeNode createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(8);

        /*
                     1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
                   \
                    8
         */

        return root;
    }

    // call printLevel() function from level 1 to height of binary tree
    public void printLevelOrder(TreeNode root) {
        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
        }
    }

    public void printLevel(TreeNode root, int level) {
        if (level == 0 || root == null) {
            return;
        }
        else if (level == 1) {
            System.out.print(root.value + " ");
        }
        printLevel(root.left, level-1);
        printLevel(root.right, level-1);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        else {
            return rightHeight + 1;
        }
    }


}
