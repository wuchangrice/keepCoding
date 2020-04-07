package leetcode;

import org.omg.CORBA.portable.ValueInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by oukinsei on 2020/3/31.
 */
public class _407 {
    public static void main(String[] args) {
        new _407().trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}});
    }

    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length < 2 || heightMap[0].length < 2){
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length;
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        int visitedNum = 0, result = 0;
        //init
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            visitedNum += 2;
            addHeight(heightMap, 0, i, treeMap);
            addHeight(heightMap, m-1, i, treeMap);
        }
        for(int i = 1; i < m-1; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            visitedNum += 2;
            addHeight(heightMap, i, 0, treeMap);
            addHeight(heightMap, i, n-1, treeMap);
        }
        while(visitedNum < m * n){
            int height = treeMap.firstKey();
            List<int[]> cells = treeMap.firstEntry().getValue();
            treeMap.remove(height);
            for(int[] cell : cells){
                int row = cell[0];
                int col = cell[1];
                //up
                if(row > 0 && !visited[row-1][col]){
                    visitedNum++;
                    visited[row-1][col] = true;
                    if(heightMap[row-1][col] < height){
                        result += (height - heightMap[row-1][col]);
                        heightMap[row-1][col] = height;
                    }
                    addHeight(heightMap, row-1, col, treeMap);
                }
                //down
                if(row < m-1 && !visited[row+1][col]){
                    visitedNum++;
                    visited[row+1][col] = true;
                    if(heightMap[row+1][col] < height){
                        result += (height - heightMap[row+1][col]);
                        heightMap[row+1][col] = height;
                    }
                    addHeight(heightMap, row+1, col, treeMap);
                }
                //left
                if(col > 0 && !visited[row][col-1]){
                    visitedNum++;
                    visited[row][col-1] = true;
                    if(heightMap[row][col-1] < height){
                        result += (height - heightMap[row][col-1]);
                        heightMap[row][col-1] = height;
                    }
                    addHeight(heightMap, row, col-1, treeMap);

                }
                //right
                if(col < n-1 && !visited[row][col+1]){
                    visitedNum++;
                    visited[row][col+1] = true;
                    if(heightMap[row][col+1] < height){
                        result += (height - heightMap[row][col+1]);
                        heightMap[row][col+1] = height;
                    }
                    addHeight(heightMap, row, col+1, treeMap);
                }

            }
        }
        return result;
    }

    private void addHeight(int[][] heightMap, int i, int j, TreeMap<Integer, List<int[]>> treeMap){
        if(treeMap.containsKey(heightMap[i][j])){
            treeMap.get(heightMap[i][j]).add(new int[]{i, j});
        }else{
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{i, j});
            treeMap.put(heightMap[i][j], list);
        }
    }
}
