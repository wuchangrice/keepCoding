package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by oukinsei on 2020/4/3.
 */
public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 4){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int head = 0, left, right;
        while(head < nums.length){
            left = head+1;
            right = nums.length-1;
            while(left < right){
                if(nums[right] < 0){
                    break;
                }
                if(nums[left] + nums[right] + nums[head] > 0){
                    right--;
                }else if(nums[left] + nums[right] + nums[head] < 0){
                    left++;
                }else{
                    result.add(Arrays.asList(nums[head], nums[left], nums[right]));
                    while(left < right && nums[head] == nums[left]){
                        left++;
                    }
                }
            }
            while(head+1 < nums.length && nums[head] == nums[head+1]) {
                head++;
            }
            head++;
        }
        return result;
    }
}
