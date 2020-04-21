package leetcode;

/**
 * Created by oukinsei on 2020/4/17.
 */
public class _200 {
    public int numIslands(char[][] grid) {
        //1.练习使用unionFind
        //2.BFS的题
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    if(j < n-1 && grid[i][j+1] == '1'){
                        uf.union(i*n+j, i*n+j+1);
                    }
                    if(i < m-1 && grid[i+1][j] == '1'){
                        uf.union(i*n+j, i*n+j+n);
                    }
                }
            }
        }
        return uf.island;
    }

    class UnionFind{
        int[] father;
        int island;
        public UnionFind(char[][] grid){
            father = new int[grid.length * grid[0].length];
            island = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        island++;
                        father[i*grid[0].length+j] = i*grid[0].length+j;
                    }
                }
            }
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                island--;
                father[rootX] = rootY;
            }
        }

        public int find(int x){
            if(x == father[x]){
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
    }
}
