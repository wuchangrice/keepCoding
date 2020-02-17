package lintcode;

import leetcode.ListNode;

public class _36 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode prev = new ListNode(0);
        ListNode toAdd = prev, tail, p;
        for(int i=1; i<m;i++){
            toAdd.next = head;
            head = head.next;
            toAdd = toAdd.next;
        }
        tail = head;
        p=head;
        for(int i=m; i<=n; i++){
            head = head.next;
            p.next=toAdd.next;
            toAdd.next = p;
            p=head;
        }
        if(tail != null){
            tail.next = head;
        }
        return prev.next;
    }
}
