package lintcode;

import leetcode.ListNode;

public class _113 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(0);
        ListNode p = head, toAdd = prev;
        while(p!=null){
            head = head.next;
            if(head == null){
                toAdd.next = p;
                toAdd=p;
                break;
            }
            if(head.val != p.val){
                toAdd.next = p;
                toAdd = p;
                p=head;
                continue;
            }
            while(head!=null && p.val == head.val){
                head = head.next;
            }
            p = head;
        }
        toAdd.next = null;
        return prev.next;
    }
}
