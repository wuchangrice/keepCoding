package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/3/25.
 */
public class _233 {
    public static void main(String[] args) {
        new _233().countDigitOne(Integer.MAX_VALUE);
    }
    public int countDigitOne(int n) {
        int result = 0;
        if(n <= 0){
            return result;
        }
        long[] nums = new long[11];//包含N个9包含的1个数（9，99，999）
        nums[1] = 1;
        int temp = 1;
        for(int i = 2; i < 11; i++){
            temp *= 10;
            nums[i] = nums[i-1] * 10 + temp;
        }
        String value = String.valueOf(n);
        while(value.length() > 1){
            int head = value.charAt(0)-48;
            for(int i = 0; i < head; i++){
                if(i == 1){
                    result += (int)Math.pow(10, value.length()-1) + nums[value.length()-1];
                }else{
                    result += nums[value.length()-1];
                }
            }
            if(head == 1){
                result += Integer.valueOf(value.substring(1))+1;
            }
            value = value.substring(1);
        }
        if(Integer.valueOf(value) > 0){
            result += 1;
        }
        return result;
    }
}
