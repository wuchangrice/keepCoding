package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oukinsei on 2020/1/7.
 *1302. Deepest Leaves Sum
 */
public class _1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(null == root){
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            result = helper(queue);
            if(result > -1){
                return result;
            }
        }
        return result;
    }

    //return -1 means not the deepest leaves,
    private int helper(Queue<TreeNode> queue){
        int len = queue.size();
        int result = 0;
        for(int i=0; i< len; i++){
            TreeNode treeNode = queue.poll();
            if(treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right != null){
                queue.offer(treeNode.right);
            }
            result += treeNode.val;
        }
        if(queue.size() > 0){
            return -1;
        }else {
            return result;
        }
    }

    //most vote
    /*
    The number of nodes in the tree is between 1 and 10^4
     */
    public int solution(TreeNode root) {
        int result = 0, i ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            for(i=queue.size(),result=0; i>0; i--){
                TreeNode treeNode = queue.poll();
                result += treeNode.val;
                if(treeNode.left != null) queue.offer(treeNode.left);
                if(treeNode.right!= null) queue.offer(treeNode.right);
            }
        }
        return result;
    }
}
