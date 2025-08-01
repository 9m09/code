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
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
        
//     }
// }










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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode node = help(preorder,0,preorder.length-1,
                        inorder,0,inorder.length-1);
        return node;
    }
    TreeNode help(int[] preorder,int pr_S,int pr_E,
                int[] inorder, int in_S,int in_E){
        if(pr_S>pr_E)    return null;
        TreeNode root = new TreeNode(preorder[pr_S]);

        int  index = map.get(preorder[pr_S]);
        int remaining = index-in_S;

        root.left=help(preorder,pr_S+1,pr_S+remaining,inorder,in_S,index-1);
        root.right=help(preorder,pr_S+remaining+1,pr_E,inorder,index+1,in_E);

        return root;
        }
}