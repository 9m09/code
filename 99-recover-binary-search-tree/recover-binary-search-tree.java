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
    TreeNode f=null;
    TreeNode s=null;
    TreeNode t=null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);  // Global prev

    public void recoverTree(TreeNode root) {
        // ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root);
        if(t!=null){
            int tem=f.val;
            f.val=t.val;
            t.val=tem;
        }
        else{
            int tem=f.val;
            f.val=s.val;
            s.val=tem;
        }


    }
    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);         
        // list.add(root);
        
        if(prev.val>root.val){
            if(s==null){
                f=prev;
                s=root;
            }
            else{
                t=root;
            }
        }
        prev = root; 
        inorder(root.right);        
    }

}