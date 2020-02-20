package lintcode;

import java.util.*;

public class _108 {
    //递归公式有问题,时间复杂度O(n^3)
    //        0 when f(i,j) is Palindrome
    //f(i,j)
    //        min{f(i,k) + f(k+1, j) + 1} i<= k < j

    //可以减少时间复杂度的递推公式,时间复杂度为O(n^2)
    // f(0) = -1
    //f(i) = min{f(j)+1} 0<=j<=i  j,i is Palindrome
    //
    public int minCut(String s) {
        int len = s.length();
        if(len <=1){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[][] f = new int[len][len];
        for(int move = 1; move < len; move++){
            for(int i=0; i<len;i++){
                if(i+move < len){
                    if(isPalindrome(chars, i, i+move, f)){
                        f[i][i+move] = 0;
                        continue;
                    }
                    int minCut = Integer.MAX_VALUE;
                    for(int j=0; j<move; j++){
                        minCut = Math.min(minCut, f[i][i+j]+f[i+j+1][i+move]+1);
                    }
                    f[i][i+move] = minCut;
                }else{
                    break;
                }
            }
        }
        return f[0][len-1];
    }

    private boolean isPalindrome(char[] chars, int left, int right, int[][] f){
        if(chars[left] != chars[right]){
            return false;
        }
        if(left == right-1){
            return true;
        }
        return f[left+1][right-1] == 0;
    }

    public static void main(String[] args) {
        String aa = "aaccc";
        new _108().minCut(aa);
    }
}
