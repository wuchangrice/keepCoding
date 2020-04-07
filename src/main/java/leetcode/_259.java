package leetcode;

import java.util.Arrays;

/**
 * Created by oukinsei on 2020/4/3.
 */
public class _259 {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0, head = 0, left, right;
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        while(head < nums.length){
            left = head+1;
            right = nums.length-1;
            while(left < right){
                if(nums[head] + nums[left] + nums[right] < target){
                    left++;
                    result++;
                }else{
                    right--;
                }
            }
            head++;
        }
        return result;

    }
}
