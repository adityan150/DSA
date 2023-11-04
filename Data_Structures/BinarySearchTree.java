package Data_Structures;
import java.util.Arrays;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode tree1 = bst.createTree();
        System.out.print("Binary Search Tree 1 preorder: ");
        bst.preOrder(tree1);
        System.out.print("Binary Search Tree 2 preorder: ");

        int[] arr = { 0,1,2,3,4,5,6,7,8,9};
        Arrays.sort(arr);
        TreeNode tree2 = bst.bstFromSortedArray(arr);
        bst.preOrder(tree2);
    }

    TreeNode createTree() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(25);
        root.right = new TreeNode(75);

        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(37);

        root.right.left = new TreeNode(62);
        root.right.right = new TreeNode(87);

        /*
                        50
                      /    \
                     25     75
                    / \    /  \
                   12 37  62  87
         */

        return root;
    }

    // morris traversal preorder
    void preOrder(TreeNode root) {
        if (root == null) return;
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode ln = current.left;

                while (ln.right != null && ln.right != current) {
                    ln = ln.right;
                }

                // left subtree already visited
                if (ln.right == current) {
                    ln.right = null;
                    current = current.right;
                }
                // else left subtree not visited, create thread and move left
                else {
                    ln.right = current;
                    System.out.print(current.val + " ");
                    current = current.left;
                }
            }
            else {
                System.out.print(current.val + " ");
                current = current.right;
            }
        }
        System.out.println();
    }

    // wrapper function
    TreeNode bstFromSortedArray(int[] arr) {
        return bstFromSortedArray(arr, 0, arr.length - 1);
    }

    // creates a binary search tree
    TreeNode bstFromSortedArray(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }

        int mid = lo + (hi - lo) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = bstFromSortedArray(arr, lo, mid);
        root.right = bstFromSortedArray(arr, mid+1, hi);

        return root;
    }
}
