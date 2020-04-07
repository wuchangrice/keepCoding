package leetcode;

import java.util.*;

public class _493 {
    public int reversePairs(int[] nums) {
        int result = 0;
        List<Long> list = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            result += binarySearch(list, nums[i]);
            int insertPosition = binarySearch(list, nums[i]*2L);
            list.add(insertPosition, nums[i] *2L);
        }
        return result;
    }

    private int binarySearch(List<Long> list, long num){//log(n)
        if(list.isEmpty()){
            return 0;
        }
        int left = 0, right = list.size() -1;
        if(list.get(right) < num){
            return right + 1;
        }
        if(list.get(left) >= num){
            return left;
        }
        while(left + 1 < right){
            int mid = (left + right)/2;
            if(list.get(mid) >= num){
                right = mid;
            }else{
                left = mid;
            }
        }
        System.out.println(list.get(left) + " < " + num + ">=" + list.get(right));
        return left+1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004};
        new _493().reversePairs(nums);
    }
}
