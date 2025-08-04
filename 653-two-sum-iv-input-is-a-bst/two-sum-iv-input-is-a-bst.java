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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inor(root,list);
        System.out.println(list);
        int l=0,r=list.size()-1;
        while(l<r){
            if((list.get(l)+list.get(r))==k)  return true;
            else if(list.get(l)+list.get(r)>k)  r--;
            else    l++;
        }
        
        return false;
    }
    void inor(TreeNode node,ArrayList<Integer> list){
        if(node==null){
            return;
        }
        inor(node.left,list);
        list.add(node.val);
        inor(node.right,list);
    }
}