package leetcode;

/**
 * Created by oukinsei on 2020/1/15.
 * maxSubArray
 */
public class _53 {
    public int maxSubArray(int[] nums) {
        //全是负数的情况，答案是错误的
        int result = 0;
        int maxLast=0;
        int curMax = nums[0];
        for(int num : nums){
            maxLast = Math.max(0, maxLast + num);
            result = Math.max(maxLast, result);
            curMax = Math.max(curMax, num);
        }
        if(curMax < 0){
            return curMax;
        }
        return result;
    }
}
