package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int result = Integer.MIN_VALUE, cur = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            cur = dq.isEmpty() ? 0 : dq.peek();
            dp[i] = cur + nums[i];
            result = Math.max(result, dp[i]);
            while(!dq.isEmpty() && dq.getLast() < dp[i]){
                dq.pollLast();
            }
            if(dp[i] > 0){
                dq.offerLast(dp[i]);
            }
            if(i >= k && !dq.isEmpty() && dq.peek() == dp[i-k]){
                dq.pollFirst();
            }
        }
        return result;
    }
}
