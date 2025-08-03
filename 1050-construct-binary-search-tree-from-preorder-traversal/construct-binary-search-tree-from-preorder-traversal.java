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
    public TreeNode bstFromPreorder(int[] pre) {
        int ub=Integer.MAX_VALUE;
        int[] ind={0};        
        return help(pre,ind,ub);  
    }
    TreeNode help(int[] pre,int[] ind,int ub){
        if(ind[0]==pre.length||pre[ ind[0] ]>ub)  return null;
        TreeNode temp = new TreeNode(pre[ind[0]++]);
        temp.left=help(pre,ind,temp.val);
        temp.right=help(pre,ind,ub);
        return temp;
    }
}