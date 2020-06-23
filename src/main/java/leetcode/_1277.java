package leetcode;

/**
 * Created by oukinsei on 2020/5/21.
 */
public class _1277 {
    public int countSquares(int[][] matrix) {
        int result = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] up = new int[m+1][n+1], left = new int[m+1][n+1], dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    left[i+1][j+1] = left[i+1][j] + 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[j][i] == 1){
                    up[j+1][i+1] = up[j][i+1] + 1;
                }
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int temp = Math.min(left[i][j], up[i][j]);
                temp = Math.min(temp, dp[i-1][j-1]+1);
                result += temp;
                dp[i][j] = temp;
            }
        }

        return result;
    }

}
