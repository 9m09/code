class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];   
        int[] count = new int[1];    
        inorder(root, k, count, result);
        return result[0];
    }

    void inorder(TreeNode node, int k, int[] count, int[] result) {
        if (node == null) return;

        inorder(node.left, k, count, result);

        count[0]++;
        if (count[0] == k) {
            result[0] = node.val;
            return; 
            
        }

        inorder(node.right, k, count, result);
    }
}
