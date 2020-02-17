package leetcode;

import sun.nio.cs.ext.MacHebrew;

import java.util.*;

public class _699 {
    //类似俄罗斯方块
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int max = 0;
        PriorityQueue<Node> p = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start - o2.start;
            }
        });
        for(int[] position : positions){
            Node node = new Node(position[0], position[0] + position[1], position[1]);
            int curMax = helper(p, node);
            max = Math.max(max, curMax);
            result.add(max);
        }
        return result;
    }

    private int helper(PriorityQueue<Node> p, Node node){
        int max = 0;
        List<Node> connectedList = new ArrayList<>();
        for(Node sortedNode : p){//优先级队列如何顺序遍历？
            if(sortedNode.interConnect(node)){
                connectedList.add(sortedNode);
                max = Math.max(max, sortedNode.height);
            }
        }
        for(Node sortedNode : connectedList){
            p.remove(sortedNode);
            if(sortedNode.start < node.start){
                Node newNode = new Node(sortedNode.start, node.start, sortedNode.height);
                p.offer(newNode);
            }
            if(sortedNode.end > node.end){
                Node newNode = new Node(node.end, sortedNode.end, sortedNode.height);
                p.offer(newNode);
            }
        }
        Node newNode = new Node(node.start, node.end, max+node.height);
        p.offer(newNode);
        return newNode.height;
    }
    class Node{
        int start;
        int end;
        int height;

        boolean interConnect(Node o){
            if(o.start >= start  && o.start < end){
                return true;
            }
            if(start >= o.start && start < o.end){
                return true;
            }
            return false;
        }

        public Node() {
        }

        public Node(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int[][] positions = new int[][]{{4,1},{6,9},{6,8},{1,9},{9,8}};
        new _699().fallingSquares(positions);
    }
}
