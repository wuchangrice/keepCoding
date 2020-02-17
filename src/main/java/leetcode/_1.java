package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1 {
    public int[] twoSum(int[] nums, int target) {
        //1.nums并不保证有序
        //2.Arrays.sort 之后返回的序列跟原序列不一致
        int[] result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<>();
        int i=0;
        for(int num : nums){
            if(numsMap.containsKey(target-num)){
                result[0] = numsMap.get(target-num);
                result[1] = i;
                return result;
            }
            numsMap.put(num, i++);
        }
        return result;
    }
}
