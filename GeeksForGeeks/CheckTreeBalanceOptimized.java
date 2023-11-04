package GeeksForGeeks;
import Data_Structures.TreeNode;

/*
Optimized Solution for CheckTreeBalance
Height is calculated in the same function
Height is passed as an object to simulate pass by reference
    - Height object is passed in isBoolean()
    - height variable wrapped by Height object is modified in each recursive call
    - height.height contains height of the current node
 */
public class CheckTreeBalanceOptimized {
    TreeNode root;


    // wrapper class used to modify height across recursive calls
    static class Height {
        int height;
        public Height() {
            height = 0;
        }
    }

    public static void main(String[] args) {
        CheckTreeBalanceOptimized chk = new CheckTreeBalanceOptimized();
        Height height = new Height();
        chk.createTree();
        System.out.println(chk.isBalanced(chk.root, height));
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
         */
    }

    /* Returns true if the tree is balanced */
    boolean isBalanced(TreeNode root, Height height)
    {
        // base condition
        if (root == null) {
            height.height = 0;
            return true;
        }

        // calculate heights of left and right subtrees
        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean L= isBalanced(root.left, lHeight);
        boolean R = isBalanced(root.right, rHeight);

        // After the recursive calls,
        // lHeight and rHeight objects contains height of left and right subtrees respectively

        int lh = lHeight.height;
        int rh = rHeight.height;

        // store height of current node in height object
        height.height = (Math.max(lh, rh)) + 1;

        if (Math.abs(lh - rh) > 1) {
            // if difference of heights of left and right subtree is more than 1
            // tree not balanced
            return false;
        }

        // return true only when Left and Right subtrees are balanced
        // else return false
        return L && R;
    }
}
