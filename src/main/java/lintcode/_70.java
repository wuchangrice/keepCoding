package lintcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _70 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> item = new ArrayList<>();
            for(int i=0; i<len;i++){
                TreeNode node = q.poll();
                if(node == null){
                    continue;
                }
                item.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            if(!item.isEmpty()){
                result.add(0,item);
            }
        }
        return result;
    }
}
