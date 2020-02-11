package lintcode;

import leetcode.TreeNode;

public class _85 {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(null == root){
            return node;
        }
        TreeNode insertPostion = root;
        while(insertPostion != null){
            if(node.val < insertPostion.val){
                if(insertPostion.left == null){
                    insertPostion.left = node;
                    return root;
                }else{
                    insertPostion = insertPostion.left;
                }
            }else if(node.val > insertPostion.val){
                if(insertPostion.right == null){
                    insertPostion.right = node;
                    return root;
                }else{
                    insertPostion = insertPostion.right;
                }
            }
        }
        return root;
    }
    //do without recursion
}
