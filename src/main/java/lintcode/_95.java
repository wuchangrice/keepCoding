package lintcode;

import leetcode.TreeNode;

public class _95 {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isValidBST;
    }

    class Result{
        boolean isValidBST;
        Integer min, max;

        public Result(boolean isValidBST, Integer min, Integer max) {
            this.isValidBST = isValidBST;
            this.min = min;
            this.max = max;
        }
    }
    private Result helper(TreeNode root){
        if(root == null){
            return new Result(true, null, null);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if(!left.isValidBST || !right.isValidBST || (left.max != null && root.val <= left.max) || (right.min != null && root.val >= right.min)){
            return new Result(false, null, null);
        }
        return new Result(true, left.min == null?root.val:left.min, right.max==null?root.val:right.max);//分治法的关键在于合怎么写
    }
}
