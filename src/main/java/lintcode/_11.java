package lintcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _11 {

    //练习分治法,优化方向:1.利用二叉查找树的特点,提前结束循环,2.List<Integer>作为参数,可以减少对象的创建
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        if(root.val >= k1 && root.val <= k2){
            result.add(root.val);
        }
        List<Integer> left = searchRange(root.left, k1, k2);
        List<Integer> right = searchRange(root.right, k1,k2);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    public void searchRange(TreeNode root, int k1, int k2, List<Integer> result) {
        // write your code here
        if(null == root){
            return ;
        }
        if(root.val >= k1 && root.val <= k2){
            result.add(root.val);
        }
        if(root.val > k1) {
            searchRange(root.left, k1, k2, result);
        }
        if(root.val < k2){
            searchRange(root.right, k1,k2, result);
        }
    }
}
