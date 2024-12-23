package array.gs.circular.tree;

public class TreeImpl implements Tree {

    public static void main(String[] args) {
        // Create a sample tree
        // Tree structure:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create TreeImpl instance
        TreeImpl tree = new TreeImpl();

        // Perform preorder traversal
        System.out.println("Preorder Traversal:");
        tree.preorder(root); // Output: 1 2 4 5 3
    }

    // Implementing preorder traversal
    @Override
    public void preorder(TreeNode root) {
        if (root == null) {
            return; // Base case: if the node is null, return
        }
        System.out.print(root.val + " "); // Print the current node value
        preorder(root.left); // Recur for left subtree
        preorder(root.right); // Recur for right subtree
    }
}
