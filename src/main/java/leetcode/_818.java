package leetcode;

/**
 * Created by oukinsei on 2020/3/12.
 */
public class _818 {
    public int racecar(int target) {
        int result = 0, jump = 2, remain = 0;
        while(target >= jump-1){
            result++;
            if(target == jump-1){
                return result;
            }
            remain = target-(jump-1);
            jump = jump<<1;
        }
        if(is2Power(remain+1)){
            return Math.min(result + 2 + racecar(remain), result + 2 + racecar(jump - 1 - target));
        }else {
            return Math.min(result + 1 + racecar(remain), result + 2 + racecar(jump - 1 - target));
        }
    }

    boolean is2Power(int n){
        while(n > 1){
            if((n&1) == 1){
                return false;
            }
            n=n>>1;
        }
        return true;
    }

    public static void main(String[] args) {
        new _818().racecar(500);
    }
}
