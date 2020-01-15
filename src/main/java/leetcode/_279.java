package leetcode;

/**
 * Created by oukinsei on 2020/1/14.
 */
public class _279 {
    public int numSquares(int n) {
        if(n<4){
            return n;
        }
        int result = Integer.MAX_VALUE;
        int len = new Double(Math.sqrt(n)).intValue();
        if(len * len == n){
            return 1;
        }
        int[] nums = new int[len];
        for(int i=1; i<=len;i++){
            nums[i-1] = i*i;
        }
        for(int i=len-1; i>0; i--){
            int weight = nums[i];
            for(int j=n/weight; j > 0; j--){
                int newPart = j+numSquares(n-j*weight);
                if(newPart < result){
                    result = newPart;
                }else{
                    break;
                }
            }
        }
        return result;
    }
}
