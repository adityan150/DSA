package Algorithm.Tree;
import Data_Structures.TreeNode;

//public class TreeNode {
//    public int val;
//    public TreeNode left, right;
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}

public class MorrisTraversal {
    TreeNode root;

    // In-order morris traversal
    // print if left subtree is visited
    public void inOrder() {
        // initialize current as root
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // no left child
                // print current and move to right
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                // traverse the left subtree to find the right-most node
                TreeNode ln = current.left;
                while (ln.right != current && ln.right != null) {
                    ln = ln.right;
                }

                // if a right node is equal to current node
                // thread was created, left subtree is already visited
                // break the thread, print current, move to the right

                if (ln.right == current) {
                    ln.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }

                // left subtree was not visited
                // create thread from right-most node in left subtree to current node
                else {
                    ln.right = current;
                    current = current.left;
                }
            }
        }
    }

    // Pre-Order morris traversal
    // print if left subtree is NOT visited
    public void preOrder() {
        // initialize current as root
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // no left child
                // print current and move to right
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                // traverse the left subtree to find the right-most node
                TreeNode ln = current.left;
                while (ln.right != current && ln.right != null) {
                    ln = ln.right;
                }

                // if a right node is equal to current node
                // thread was created, left subtree is already visited
                // break the thread, move to the right

                if (ln.right == current) {
                    ln.right = null;
                    current = current.right;
                }

                // left subtree was NOT visited
                // create thread from right-most node in left subtree to current node
                else {
                    ln.right = current;
                    System.out.print(current.val + " ");
                    current = current.left;
                }
            }
        }
    }

    public void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*
                    1
                  /    \
                2       3
              /  \     /  \
             4    5   6    7
         */
    }

    public static void main(String[] args) {
        MorrisTraversal mt = new MorrisTraversal();
        mt.createTree();
        System.out.println("In Order: ");
        mt.inOrder();
        System.out.println("\nPre Order: ");
        mt.preOrder();
    }

}
