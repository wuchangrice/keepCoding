package leetcode;

import java.util.Map;

/**
 * Created by oukinsei on 2020/4/29.
 */
public class _124 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(null == root){
            return result;
        }
        curSum(root);
        return result;
    }

    private int curSum(TreeNode root){
        if(null == root){
            return 0;
        }
        int left = curSum(root.left);
        int right = curSum(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        result = Math.max(result, left+right+root.val);
        return Math.max(left, right) + root.val;

    }
}
