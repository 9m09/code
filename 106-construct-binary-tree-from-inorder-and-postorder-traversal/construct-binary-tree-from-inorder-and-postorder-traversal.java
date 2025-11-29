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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode node = help(postorder,postorder.length-1,0,
                        inorder,0,inorder.length-1);
        return node;    
    }
    TreeNode help (int[] postorder,int po_S,int po_E,
                    int[] inorder, int in_S,int in_E){
        
        if(in_S>in_E) return null;
        
        int index = map.get(postorder[po_S]);

        // int remaining = in_E - index; 
        // TreeNode root=new TreeNode(postorder[po_S]);
        // root.left=help(postorder, po_S-remaining-1,po_E ,
        //                 inorder,in_S,index-1);
        // root.right=help(postorder,po_S-1,po_S-remaining,
        //                 inorder,index+1,in_E);

        int remaining =  index-in_S; 
        TreeNode root=new TreeNode(postorder[po_S]);
        root.left=help(postorder, po_E+remaining-1,po_E ,
                        inorder,in_S,index-1);
        root.right=help(postorder,po_S-1,po_E+remaining,
                        inorder,index+1,in_E);
        return root;
    }
}