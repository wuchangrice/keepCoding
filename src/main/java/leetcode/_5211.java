package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/7/12.
 */
public class _5211 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Struct>[] neighbour = new PriorityQueue[n];
        Map<String,Double> map = new HashMap<>();
        double[] maxProb = new double[n];
        for(int i = 0; i < n; i++){
            neighbour[i] = new PriorityQueue<>((a,b)->(a.prob-b.prob <=0 ? 1 : -1));
        }
        for(int i = 0; i < succProb.length; i++){
            int left = edges[i][0];
            int right = edges[i][1];
            double prob = succProb[i];
            neighbour[left].add(new Struct(right, prob));
            neighbour[right].add(new Struct(left,prob));
            map.put(left+"#"+right, prob);
            map.put(right+"#"+left, prob);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        return 0;



    }
    class Struct{
        public int end;
        public double prob;

        public Struct(int end, double prob){
            this.end = end;
            this.prob = prob;
        }
    }
}
