package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by oukinsei on 2020/3/13.
 */
public class _1101 {
    public int earliestAcq(int[][] logs, int N) {
        //并查集
        if(null == logs || logs.length == 0 || logs[0].length == 0){
            return -1;
        }
        Arrays.sort(logs, (a,b) ->(a[0]-b[0]));
        UnionFind uf = new UnionFind(N);
        for(int[] log : logs){
            uf.union(log[1],log[2]);
            if(uf.group == 1){
                return log[0];
            }
        }
        return -1;
    }

    class UnionFind{
        int group;
        int[] father;
        public UnionFind(int N){
            father = new int[N];
            group = N;
            for(int i = 0; i < N; i++){
                father[i] = i;
            }
        }

        public int find(int n){
            if(n == father[n]){
                return n;
            }
            father[n] = find(father[n]);
            return father[n];
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA != rootB){
                father[rootA] = rootB;
                group--;
            }
        }

    }


}
