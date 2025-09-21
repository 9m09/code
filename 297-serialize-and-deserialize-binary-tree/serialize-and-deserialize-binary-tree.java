/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if(root==null)  return "";
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                str.append("#,");
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
            str.append(node.val).append(",");
        }
        System.out.println(str);
        return str.toString();    
    }

    // public TreeNode deserialize(String data) {
    //     if(data.isEmpty())  return null;
    //     String[] arr = data.split(",");
    //     TreeNode node = new TreeNode(Integer.valueOf(arr[0]));
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(node);
    //     int ind=1;
    //     while(!queue.isEmpty()&&ind<arr.length){
    //         TreeNode temp = queue.poll();
    //         if (!arr[ind].equals("#")) {
    //             temp.left=new TreeNode(Integer.valueOf(arr[ind]));
    //             queue.add(temp.left);
    //         }ind++;
    //         if (ind < arr.length && !arr[ind].equals("#")) {
    //             temp.right=new TreeNode(Integer.valueOf(arr[ind]));
    //             queue.add(temp.right);
    //         }ind++;
    //     }
    //     return node;
    // }
   public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) return null;

    String[] arr = data.split(",");
    int n = arr.length;

    TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < n) {
        TreeNode curr = q.poll();

        if (!arr[i].equals("#")) {
            curr.left = new TreeNode(Integer.valueOf(arr[i]));
            q.add(curr.left);
        }
        i++;

        if (i < n && !arr[i].equals("#")) {
            curr.right = new TreeNode(Integer.valueOf(arr[i]));
            q.add(curr.right);
        }
        i++;
    }

    return root;
}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));