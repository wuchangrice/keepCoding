package lintcode;

import leetcode.TreeNode;

public class _97 {
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
