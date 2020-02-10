package lintcode;

import leetcode.TreeNode;

public class _93 {
    public boolean isBalanced(TreeNode root) { //左右判断和深度可以同时进行
        // write your code here
//        if(root == null){
//            return true;
//        }
//        int left = depth(root.left);
//        int right = depth(root.right);
//        if(left == -1 || right == -1 || Math.abs(left-right) > 1){  //重复计算
//            return false;
//        }
//        return true;
        return depth(root) != -1;
    }

    //如果节点非平衡返回-1
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left, right)+1;
    }


}
