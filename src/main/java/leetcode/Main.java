package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oukinsei on 2020/1/14.
 */
public class Main {
    public static void main(String[] args) {
        new Main().longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0);
    }
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int left = 0, right = 0, result = 0;
        while(right < nums.length){
            while(!max.isEmpty() && max.peekLast() < nums[right]){
                max.pollLast();
            }
            max.offerLast(nums[right]);
            while(!min.isEmpty() && min.peekLast() > nums[right]){
                min.pollLast();
            }
            min.offerLast(nums[right]);
            if(max.peekFirst() - min.peekFirst() <= limit){
                result = Math.max(result, right-left+1);
            }else{
                while(max.peekFirst() - min.peekFirst() > limit){
                    if(nums[left] == max.peekFirst()){
                        max.pollFirst();
                    }
                    if(nums[left] == min.peekFirst()){
                        min.pollFirst();
                    }
                    left++;
                }
            }
            right++;
        }
        return result;
    }

}