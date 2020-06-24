package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oukinsei on 2020/6/24.
 */
public class _994 {
    //bfs
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int countFresh = 0, step = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        if(countFresh == 0){
            return step;
        }
        while(!rotten.isEmpty()){
            step++;
            int len = rotten.size();
            for(int i = 0; i < len; i++){
                int[] cur = rotten.poll();
                int row = cur[0], col = cur[1];
                if(row > 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    rotten.offer(new int[]{row-1, col});
                    countFresh--;
                }
                if(row < grid.length-1 && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    rotten.offer(new int[]{row+1, col});
                    countFresh--;
                }
                if(col > 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    rotten.offer(new int[]{row, col-1});
                    countFresh--;
                }
                if(col < grid[row].length-1 && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    rotten.offer(new int[]{row, col+1});
                    countFresh--;
                }
                if(countFresh == 0){
                    return step;
                }
            }
        }
        return -1;
    }
}
