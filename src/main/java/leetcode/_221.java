package leetcode;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        new _221().maximalSquare(matrix);
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int result = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int[][] up = new int[m+1][n+1];
        int[][] left = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1') {
                    left[i+1][j + 1] = left[i+1][j] + 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[j][i] == '1'){
                    up[j+1][i+1] = up[j][i+1] +1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    if(left[i+1][j+1] > dp[i][j] && up[i+1][j+1] > dp[i][j]){
                        dp[i+1][j+1] = dp[i][j]+1;
                    }else{
                        dp[i+1][j+1] = Math.min(left[i+1][j+1], up[i+1][j+1]);
                    }
                    result = Math.max(result, dp[i+1][j+1]*dp[i+1][j+1]);
                }
            }
        }

        return result;
    }
}
