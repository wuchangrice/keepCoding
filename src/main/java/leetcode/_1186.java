package leetcode;

/**
 * Created by oukinsei on 2020/4/1.
 */
public class _1186 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,0,3};
        new _1186().maximumSum(nums);
    }
    public int maximumSum2(int[] arr) {
        //time limit exceeded O(n^2)不行
        int len = arr.length;
        if(len == 0){//bad input
            return 0;
        }
        if(len < 2){
            return arr[0];
        }
        int result = arr[0];
        int[] sum = new int[len+1];
        //init sum
        for(int i = 1; i <= len; i++){
            sum[i] = arr[i-1] + sum[i-1];
        }
        int[] min = new int[len];
        //init min
        for(int i = 0 ; i < len; i++){
            min[i] = arr[i];
        }
        for(int i = 2; i <= len; i++){ //i sum
            for(int j = 0; j+i <= len; j++){
                int s = sum[j+i]-sum[j];
                int m = Math.min(min[j],min[j+1]);
                min[j] = m;
                if(m < 0){
                    result = Math.max(result, s-m);
                }else{
                    result = Math.max(result, s);
                }
            }
        }

        return result;
    }

    public int maximumSum(int[] arr) {
        int len = arr.length, result = arr[0];
        int[] pre = new int[len];
        int[] post = new int[len];
        pre[0] = arr[0];
        post[len-1] = arr[len-1];
        for(int i = 1; i < len; i++){
            if(pre[i-1] > 0){
                pre[i] = pre[i-1] + arr[i];
            }else{
                pre[i] = arr[i];
            }
        }

        for(int i = len-2; i >= 0; i--){
            if(post[i+1] > 0){
                post[i] = post[i+1] + arr[i];
            }else{
                post[i] = arr[i];
            }
        }
        for(int i = 0; i < len; i++){

        }
        return result;
    }
}
