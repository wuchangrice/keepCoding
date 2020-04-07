package leetcode;

import java.util.Arrays;

/**
 * Created by oukinsei on 2020/4/3.
 */
public class _1099 {
    public int twoSumLessThanK(int[] A, int K) {
        int result = -1;
        Arrays.sort(A);
        if(A.length < 2){
            return result;
        }
        int left = 0, right = A.length -1;
        while(left < right){
            if(A[left] + A[right] >= K){
                right--;
            }else{
                result = Math.max(result, A[left]+A[right]);
                left++;
            }
        }
        return result;
    }
}
