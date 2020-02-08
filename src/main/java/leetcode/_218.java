package leetcode;

import java.util.*;

public class _218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });
        Node[] nodes = new Node[buildings.length*2];
        int i=0;
        for(int[] num : buildings){
            Node node1 = new Node(num[0], true, num[2]);
            Node node2 = new Node(num[1], false, num[2]);
            nodes[i++] = node1;
            nodes[i++] = node2;
        }
        Arrays.sort(nodes);
        for(Node node : nodes){
            if(node.isStart){
                Integer curMax = priorityQueue.peek();
                if(curMax == null || node.height > curMax){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.pos);
                    list.add(node.height);
                    result.add(list);
                }
                priorityQueue.offer(node.height);
            }else{
                priorityQueue.remove(node.height);
                Integer curMax = priorityQueue.peek();
                if(curMax == null){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.pos);
                    list.add(0);
                    result.add(list);
                }else if(curMax < node.height){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.pos);
                    list.add(curMax);
                    result.add(list);
                }
            }

        }
        return result;
    }


    static class Node implements Comparable<Node>{
        int pos;
        boolean isStart;
        int height;

        @Override
        public int compareTo(Node o) {
            if(this.pos != o.pos){
                return pos - o.pos;
            }
            if(this.isStart != o.isStart){
                return this.isStart ? -1 : 1;
            }
            if(this.height != o.height){//此处需要按照isStart分别进行排序
                if(o.isStart) {
                    return o.height - height;
                }else{
                    return height - o.height;
                }
            }
            return 0;
        }

        public Node(int pos, boolean isStart, int height) {
            this.pos = pos;
            this.isStart = isStart;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{{1,2,1},{1,2,2},{1,2,3}};
        new _218().getSkyline(buildings);
    }
}
