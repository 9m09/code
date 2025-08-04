/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, k);
    }

    private boolean inorder(TreeNode node, int k) {
        if (node == null) return false;

        // if (inorder(node.left, k)) return true;

        if (set.contains(k - node.val)) return true;
        set.add(node.val);

        return inorder(node.left, k)||inorder(node.right, k);
    }
}