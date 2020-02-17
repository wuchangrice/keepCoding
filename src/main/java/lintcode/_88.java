package lintcode;

import leetcode.TreeNode;

public class _88 {
    //二叉查找树简单,现在要求的是普通二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        return ContainsNode(root, A, B).ancestor;


    }

    private ResultType ContainsNode(TreeNode root, TreeNode A, TreeNode B){
        if(root == null){
            return new ResultType(false, null);
        }
        //divide
        ResultType left = ContainsNode(root.left, A, B);
        ResultType right = ContainsNode(root.right, A, B);
        //conquer
        //退出条件
        if(left.ancestor != null || right.ancestor != null){
            return new ResultType(true, left.ancestor != null ? left.ancestor : right.ancestor); //此处有一笔误
        }
        if((root.val == A.val || root.val == B.val) && (left.contains || right.contains)){
            return new ResultType(true, root);
        }
        if(left.contains && right.contains){
            return new ResultType(true, root);
        }
        //计算
        if(root.val == A.val || root.val == B.val){
            return new ResultType(true, null);
        }

        if(left.contains || right.contains){
            return new ResultType(true, null);
        }
        return new ResultType(false, null);

    }

    class ResultType{
        boolean contains;
        TreeNode ancestor;

        public ResultType(boolean contains, TreeNode ancestor) {
            this.contains = contains;
            this.ancestor = ancestor;
        }
    }
}
