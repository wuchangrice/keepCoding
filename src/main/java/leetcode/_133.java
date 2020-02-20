package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/1/19.
 * Clone Graph
 */
public class _133 {
    public Node cloneGraph(Node node) {
        //最暴力的解法
        Queue<Node> q = new LinkedList<>();
        q.poll();
        Map<Integer, Node> createdNode = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        if(null == node){
            return null;
        }
        q.offer(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            Node newNode = createNode(createdNode, n);
            List<Node> newNeighbors = new ArrayList<>();
            for(Node item : n.neighbors){
                newNeighbors.add(createNode(createdNode,item));
                if(!visited.contains(item.val)){
                    q.offer(item);
                }
            }
            newNode.neighbors = newNeighbors;
            visited.add(n.val);
        }
        return createdNode.get(1);
    }

    private Node createNode(Map<Integer,Node> map, Node node){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node.val, newNode);
        return newNode;
    }

    public static Node cloneGraphNewSolution(Node node) {
        //直接在每个node的后边添加复制体
        Queue<Node> q = new LinkedList<>();
        if (null == node){
            return null;
        }
        q.offer(node);
        Set<Integer> visited = new HashSet<>();
        //添加复制
        while(!q.isEmpty()){
            Node n = q.poll();
            if(!visited.contains(n.val)){
                Node newNode = new Node();
                newNode.val = n.val;
                for(Node item : n.neighbors){
                    if(!visited.contains(item.val)){
                        q.offer(item);
                    }
                }
                n.neighbors.add(0, newNode);
                visited.add(n.val);
            }
        }
        //为新节点添加neighbor
        visited.clear();
        q.offer(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            if(!visited.contains(n.val)) { //1.此处第一次写的时候忘记了，如果队列的节点被访问过则直接出队
                Node newNode = n.neighbors.get(0);
                List<Node> newNeighbors = new ArrayList<>();//2.开始neighbors直接当list用了，居然没报空指针异常。。
                for (int i = 1; i < n.neighbors.size(); i++) {
                    Node item = n.neighbors.get(i);
                    newNeighbors.add(item.neighbors.get(0));
                    if (!visited.contains(item.val)) {
                        q.offer(item);
                    }
                }
                newNode.neighbors = newNeighbors;
                visited.add(n.val);
            }
        }

        Node result = node.neighbors.get(0);
        //删除原节点与复制节点的连接关系 //3.deep copy不能改变原来的结构
        visited.clear();
        q.offer(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            if(!visited.contains(n.val)){
                n.neighbors.remove(0);
                for(Node item : n.neighbors){
                    q.offer(item);
                }
                visited.add(n.val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node _1 = new Node(1);
        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        _1.neighbors.add(_2);
        _1.neighbors.add(_4);
        _2.neighbors.add(_1);
        _2.neighbors.add(_3);
        _3.neighbors.add(_2);
        _3.neighbors.add(_4);
        _4.neighbors.add(_1);
        _4.neighbors.add(_3);

        cloneGraphNewSolution(_1);
    }
}
