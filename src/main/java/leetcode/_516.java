package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oukinsei on 2020/3/13.
 */
public class _516 {
    public static void main(String[] args) {
        new _516().longestPalindromeSubseq("bbbab");
    }
    public int longestPalindromeSubseq(String s) {
        if(s.length() < 2){
            return s.length();
        }
        int[][] matrix = new int[s.length()][s.length()];
        //init
        for(int i = 0; i < s.length(); i++){
            matrix[i][i] = 1;
        }
        //斜坡顺序的计算
        for(int col = 1; col < s.length(); col++){
            for(int row = col-1; row >=0; row--){
                int curMax = Math.max(matrix[row][col-1], matrix[row+1][col]);
                int cur = 0;
                for(int i = row; i < col; i++){
                    if(s.charAt(i) == s.charAt(col)){
                        if(i+1>=col){
                            cur = 2;
                        }else{
                            cur = 2 + matrix[i+1][col-1];
                        }
                        break;
                    }
                }
                matrix[row][col] = Math.max(curMax, cur);
            }
        }
        return matrix[0][s.length()-1];

    }
}
