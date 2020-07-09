package leetcode;

/**
 * Created by oukinsei on 2020/7/9.
 */
public class _79 {
    public boolean exist(char[][] board, String word){
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, visited, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int wordPosition, int i, int j){
        if(word.length() == wordPosition){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
            return false;
        }
        if(board[i][j] == word.charAt(wordPosition)){
            visited[i][j] = true;
            if(dfs(board, visited, word, wordPosition+1, i-1, j)
                    || dfs(board, visited, word, wordPosition+1, i+1, j)
                    || dfs(board, visited, word, wordPosition+1, i, j-1)
                    || dfs(board, visited, word, wordPosition+1, i, j+1)){
                return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
