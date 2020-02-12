package lintcode;

import leetcode.ListNode;

public class _112 {
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return head;
        }
        ListNode p1, p2;
        p1 = head;
        p2 = p1.next;
        while(p2!=null){
            if(p2.val == p1.val){
                p1.next = p2.next;
                p2=p2.next;
            }else{
                p1=p2;
                p2=p2.next;
            }
        }
        return head;
    }
}
