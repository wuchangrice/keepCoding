package leetcode;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] dq = new int[100001];
        int start = 0, end = 0;
        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; i++){
            while(end > start && dq[end-1] < nums[i]){
                end--;
            }
            dq[end++] = nums[i];
            if(i >= k-1){
                result[i-k+1] = dq[start];
                if(dq[start] == nums[i-k+1]){
                    start++;
                }
            }
        }
        return result;
    }
}
