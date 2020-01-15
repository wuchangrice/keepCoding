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

    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;//优化上述代码时，忘记修改result的初始值导致出错
        int maxLast=0;
        for(int num : nums){
            maxLast = Math.max(maxLast + num, num);
            result = Math.max(maxLast, result);
        }
        return result;
    }
}
