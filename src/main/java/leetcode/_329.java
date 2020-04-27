package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oukinsei on 2020/1/21.
 */
public class _329 {
    public static int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int m = matrix.length;
        if (m == 0){ //3.空值判断
            return result;
        }
        int n = matrix[0].length;
        int[][] inDegree = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j< n;j++){
                inDegree[i][j] = calculateInDegree(matrix, i, j, m, n);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        //init queue
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(inDegree[i][j] == 0){ //1.两个矩阵搞混了。。。
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len;i++){
                recalculateInDegree(matrix, inDegree, q.poll(), m, n, q);
            }
            result++;
        };
        return result;

    }
    private static int calculateInDegree(int[][] matrix, int row, int col, int rowLen, int colLen){
        int result = 0;
        int cur = matrix[row][col];
        if(row > 0 && matrix[row-1][col] < cur){
            result++;
        }
        if(row < rowLen -1 && matrix[row+1][col] < cur){
            result++;
        }
        if(col > 0 && matrix[row][col-1] < cur){
            result++;
        }
        if(col < colLen -1 && matrix[row][col+1] < cur){
            result++;
        }
        return result;
    }

    private static void recalculateInDegree(int[][] matrix,int[][] inDegree ,int[] location, int rowLen, int colLen, Queue<int[]> q){
        int row = location[0];
        int col = location[1];
        int cur = matrix[row][col];
        if(row > 0 && matrix[row-1][col] > cur){
            if(inDegree[row-1][col]-- == 1){
                q.offer(new int[]{row-1, col});
            }
        }
        if(row < rowLen -1 && matrix[row+1][col] > cur){
            if(inDegree[row+1][col]-- == 1){
                q.offer(new int[]{row+1, col});
            }
        }
        if(col > 0 && matrix[row][col-1] > cur){
            if(inDegree[row][col-1]-- == 1){
                q.offer(new int[]{row, col-1});
            }
        }
        if(col < colLen -1 && matrix[row][col+1] > cur) {
            if(inDegree[row][col+1]-- == 1){
                q.offer(new int[]{row, col+1}); //2.代码copy复制的锅
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{9,9,4};
        matrix[1] = new int[]{6,6,8};
        matrix[2] = new int[]{2,1,1};
        int result = longestIncreasingPath(matrix);
    }
}
