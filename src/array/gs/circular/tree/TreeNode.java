package array.gs.circular.tree;

// Class representing a tree node
public class TreeNode {
    int val; // Node value
    TreeNode left, right; // Left and right child references

    // Constructor to initialize a node
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
