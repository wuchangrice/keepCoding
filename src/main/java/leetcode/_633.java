package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by oukinsei on 2020/3/10.
 */
public class _633 {

    //这是利用sqrt的two pointer的问题，其他做法要注意越界的问题
    public static void main(String[] args) {
        System.out.println(new _633().judgeSquareSum(1000));
    }
    //memory limit exceeded
    public boolean judgeSquareSum1(int c) {
        List<Integer> square = new ArrayList<>();
        square.add(0);
        long cur = 1;
        while(cur*cur < c){
            square.add((int)(cur*cur));
            cur++;
        }
        int left = 0, right = square.size() -1;
        while(left <= right){
            if(square.get(left) + square.get(right) > c){
                right--;
            }else if(square.get(left) + square.get(right) < c){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while(left <= right){
            int cur = left * left + right * right;
            if(cur < c){
                left++;
            }else if(cur > c){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }


}
