package leetcode;

/**
 * Created by oukinsei on 2020/1/13.
 * Construct Binary Search Tree from Preorder Traversal
 */
public class _1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        return helper(preorder, 0 , preorder.length);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        if(start >= end){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[start]);
        if(start == end-1){
            return treeNode;
        }
        int leftEnd = start+1;
        for(; leftEnd<end; leftEnd++){
            if(preorder[leftEnd] > preorder[start]){
                break;
            }
        }
        treeNode.left = helper(preorder, start+1, leftEnd);
        treeNode.right = helper(preorder, leftEnd, end);
        return treeNode;
    }
}
