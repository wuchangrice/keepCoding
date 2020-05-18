package leetcode;

/**
 * Created by oukinsei on 2020/5/12.
 */
public class _410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length, max = 0;
        int[] sums = new int[n+1];
        for(int i = 0; i < n; i++){
            sums[i+1] = sums[i] + nums[i];
            max = Math.max(max, nums[i]);
        }
        int left = max, right = sums[n];
        while(left < right){
            int mid = (left+right)/2;
            int need = part(sums, mid);
            if(need > m){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int part(int[] nums, int mid){
        int result = 0, cur = 0;
        for(int num : nums){
            if(cur + num > mid){
                result++;
                cur = 0;
            }
            cur += num;
        }
        result++;
        return result;
    }
}
