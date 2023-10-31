package GeeksForGeeks;

public class MirrorTree {
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
        MirrorTree mt = new MirrorTree();
        mt.createTree();
        System.out.println("Original tree: ");
        mt.printInorder(mt.root);
        mt.root = mt.mirror(mt.root);
        System.out.println("\nMirrored tree: ");
        mt.printInorder(mt.root);

    }

    public TreeNode mirror(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            root.left = mirror(root.left);
        }
        if (root.right != null) {
            root.right = mirror(root.right);
        }
        return root;
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

    // morris traversal
    public void printInorder(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.val + " ");
                root = root.right;
            }
            else {
                // find rightmost in left subtree
                TreeNode ln = root.left;
                while (ln.right != null && ln.right != root) {
                    ln = ln.right;
                }

                if (ln.right == root) {
                    // left subtree was already visited
                    ln.right = null;
                    System.out.print(root.val + " ");
                    root = root.right;
                } else {
                    // left subtree not visited before
                    ln.right = root;
                    root = root.left;
                }
            }
        }
    }
}
