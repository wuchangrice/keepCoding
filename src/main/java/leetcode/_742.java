package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/3/10.
 */
public class _742 {
    //找到离k最近的叶子节点
    //1.看起来很像bfs，将root拆成邻接表,标记出叶子节点,利用dfs可以得到结果（练习用）
    //2.拓扑排序，容易求出层数，不容易求出数值
    //3.找到k的路径保存parent到map，之后bfs遍历到第一个叶子节点
    public int findClosestLeaf(TreeNode root, int k) {
        List<TreeNode> path = new ArrayList<>();
        dfs(root, path, k);
        int index = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(path.get(index++));
        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        while(!q.isEmpty()){
            int size = q.size();
            if(index < path.size()){
                q.offer(path.get(index));
                visited.add(path.get(index).val);
                index++;
            }
            for(int i = 0; i < size; i++){
                TreeNode item = q.poll();
                if(item.left == null && item.right == null){
                    return item.val;
                }
                if(item.left != null && !visited.contains(item.left.val)){
                    q.offer(item.left);
                }
                if(item.right != null && !visited.contains(item.right.val)){
                    q.offer(item.right);
                }
            }
        }

        return -1; //not found
    }

    private boolean dfs(TreeNode root, List<TreeNode> list, int target){
        if(root == null){
            return false;
        }
        if(root.val == target){
            list.add(root);
            return true;
        }
        if(dfs(root.left, list, target) || dfs(root.right, list, target)){
            list.add(root);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node6.left = node7;
        node6.right = node8;
        List<TreeNode> list = new ArrayList<>();
        new _742().dfs(root, list, 8);
        System.out.println("OK");
    }
}
