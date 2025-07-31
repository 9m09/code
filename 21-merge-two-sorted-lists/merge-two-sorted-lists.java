/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        // ListNode t1 =  list1;
        // ListNode list2 =  list2;
        ListNode temp  = new ListNode(0);
        ListNode ne=temp;

        while(list1!=null || list2!=null){
            if(list1==null){
                ne.next=new ListNode(list2.val);
                ne=ne.next;
                list2=list2.next;
            }
            else if (list2==null){
                ne.next=new ListNode(list1.val);
                ne=ne.next;
                list1=list1.next;
            }
            else{
                if(list1.val<=list2.val){
                    ne.next=new ListNode(list1.val);
                    ne=ne.next;
                    list1=list1.next;
                }
                else{
                    ne.next=new ListNode(list2.val);
                    ne=ne.next;
                    list2=list2.next;
                }    
            }
        }
    return temp.next;
    }
}