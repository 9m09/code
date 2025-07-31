/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)  return head;
        Node temp=head;
        traverse(temp);
        return head;
    }
    Node traverse(Node temp){
        Node ret=null;
        while(temp!=null){
            ret=temp;
            if(temp.child==null)    temp=temp.next;
            else{
                Node last= traverse(temp.child);
                Node after =temp.next;      // 9
                temp.next=temp.child;       // 8 -> 11
                temp.child.prev=temp; // 8 <- 11
                temp.child=null;    // 8 child =null
                last.next=after;
                if(after!=null)
                after.prev=last;
            }
        }
        return ret;    
    }

}