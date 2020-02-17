package lintcode;

import leetcode.TreeNode;

import java.util.Stack;

public class _86 {
    /*
     * @param root: The root of binary tree.
     */
    Stack<TreeNode> stack = new Stack<>();
    public _86(TreeNode root) {
        // do intialization if necessary
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode result = stack.pop();
        TreeNode toAdd = result.right;
        while(toAdd!=null){
            stack.push(toAdd);
            toAdd = toAdd.left;
        }
        return result;
    }
}
