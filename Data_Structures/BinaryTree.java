package Data_Structures;

public class BinaryTree {
    TreeNode root;

    BinaryTree(int key) {
        root = new TreeNode(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(1);

        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);

        /*
                1
              /   \
             2     3
            / \     \
           4   5     6
       */
    }
}
