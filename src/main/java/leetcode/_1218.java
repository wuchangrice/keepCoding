package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oukinsei on 2020/3/25.
 */
public class _1218 {
    public static void main(String[] args) {
        int[] nums  = new int[]{1,5,7,8,5,3,4,2,1};
        new _1218().longestSubsequence(nums, -2);
    }
    public int longestSubsequence(int[] arr, int difference) {
        int result = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i-difference)){
                count = map.get(i-difference) + 1;
            }else{
                count = 1;
            }
            map.put(i,count);
            result = Math.max(result, count);
        }
        return result;
    }
}
