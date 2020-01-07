package leetcode;

/**
 * Created by oukinsei on 2020/1/7.
 * Range Sum of BST
 */
public class _938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;
        if(null == root){
            return result;
        }
        if(L <= root.val && root.val <= R){
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L,R);
        }else if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }else{
            return rangeSumBST(root.left, L, R);
        }
    }
}
