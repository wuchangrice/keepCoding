package leetcode;

/**
 * Created by oukinsei on 2020/7/6.
 */
public class _289 {
    public void gameOfLife(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if((board[i][j]&1) > 0){
                    updateNeighbour(board, i, j);
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = nextState(board[i][j]);
            }
        }
    }

    private void updateNeighbour(int[][] board, int i , int j){
        addToNeighbour(board, i-1, j-1);
        addToNeighbour(board, i-1, j);
        addToNeighbour(board, i-1, j+1);
        addToNeighbour(board, i, j-1);
        addToNeighbour(board, i, j+1);
        addToNeighbour(board, i+1, j-1);
        addToNeighbour(board, i+1, j);
        addToNeighbour(board, i+1, j+1);
    }

    private void addToNeighbour(int[][] board, int i , int j){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
            board[i][j] += 10;
        }
    }

    private int nextState(int now){
        int cur = now/10;
        if((now&1) > 0){
            if(cur < 2){
                return 0;
            }else if(cur <= 3){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(cur == 3){
                return 1;
            }
            return 0;
        }
    }
}
