package leetcode;

/**
 * Created by oukinsei on 2020/7/27.
 */
public class _25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || null == head){
            return head;
        }
        int len = nodeLength(head);
        ListNode dummyNode = new ListNode();
        reverse(dummyNode, head, k, len);
        return dummyNode.next;
    }

    private int nodeLength(ListNode head){
        int result = 0;
        while(head != null){
            head = head.next;
            result++;
        }
        return result;
    }

    private void reverse(ListNode front, ListNode start, int k, int len){
        if(len < k){
            front.next = start;
            return;
        }
        ListNode nextFront = start;
        ListNode temp;
        for(int i = 0; i < k; i++){
            temp = start.next;
            start.next = front.next;
            front.next = start;
            start = temp;
        }
        reverse(nextFront, start, k, len-k);
    }
}
