package lintcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DlrStack {
    //非递归实现先序遍历
    public List<TreeNode> dlr(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(null == cur){
                continue;
            }
            result.add(cur);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return result;
    }
}
