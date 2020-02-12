package lintcode;

import leetcode.ListNode;

public class _35 {
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = new ListNode(0);
        ListNode p = head;
        while(p!=null){
            head = head.next;
            p.next=prev.next;
            prev.next=p;
            p=head;
        }
        return prev.next;
    }
}
