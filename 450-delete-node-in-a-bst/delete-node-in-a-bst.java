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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)  return root;
        else if(root.left==null&&root.right==null&&root.val==key)  return null;
        else if(root.left==null&&root.right==null)  return root;
        else if(root.val==key){
            if(root.left==null) return root.right;
            else if(root.right==null)   return root.left;
            else{
                TreeNode min=root.right;
                while(min.left!=null){
                    min=min.left;
                }
                min.left=root.left;
                return root.right;
            }
        }
        help(root,key,null);
        return root;
    }
    static void help(TreeNode node,int key,TreeNode par){
        if(node==null)  return;
        if(key<node.val)    help(node.left,key,node);
        else if(key>node.val)   help(node.right,key,node);
        else{
            if(node.left==null&&node.right==null){
                if(par.val<node.val)    par.right=null;
                else    par.left=null;
            }
            else{
                if(node.val<par.val){   // par is towards right
                    if(node.right==null){
                        par.left=node.left;
                        // node.left=null;
                        return;
                    }
                    else if(node.left==null){
                        par.left=node.right;
                        // node.right=null;
                        return;
                    }
                    else{
                        TreeNode min=node.right;
                        while(min.left!=null){
                            min=min.left;
                        }
                        par.left=node.right;
                        min.left=node.left;
                        // node.right=null;
                        // node.left=null;
                        return;
                    }
                }
                else{   // par is towards left
                    if(node.right==null){
                        par.right=node.left;
                        // node.left=null;
                        return;
                    }
                    else if(node.left==null){
                        par.right=node.right;
                        // node.right=null;
                        return;
                    }
                    else{
                        TreeNode max = node.left;
                        while(max.right!=null){
                            max=max.right;
                        }    
                        par.right=node.left;
                        max.right=node.right;
                        // node.right=null;
                        // node.left=null;
                        return;
                    }
                }
            }
        }
    }
}