package lintcode;

import leetcode.TreeNode;

public class _94 {
    public int maxPathSum(TreeNode root) {
        return helper(root).max;
    }

    private Result helper(TreeNode root){
        if(root == null){
            return new Result(Integer.MIN_VALUE,0); //1.负数节点时,不能返回0
        }
        //分
        Result left = helper(root.left);
        Result right = helper(root.right);
        //治
        int curMax = Math.max(left.curMax+root.val, right.curMax + root.val);//包含当前节点单线的最大值
        if(curMax < root.val){
            curMax = root.val;
        }
        int max = Math.max(curMax, left.curMax+root.val+right.curMax);//包含当前节点双线的最大值
        int lrMax = Math.max(left.max, right.max); //左右的最大值
        max = Math.max(max, lrMax);
        return new Result(max,curMax);
    }

    class Result{
        int max; //当前最大值
        int curMax;//经过当前节点的最大值

        public Result(int max, int curMax){
            this.max = max;
            this.curMax = curMax; //构造函数写错了
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        new _94().maxPathSum(root);
    }

}
