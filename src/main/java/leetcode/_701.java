package leetcode;

/**
 * Created by oukinsei on 2020/1/7.
 * Insert into a Binary Search Tree
 */
public class _701 {
    /*
     It is guaranteed that the new value does not exist in the original BST.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode treeNode = new TreeNode(val);
        if(null == root){
            return treeNode;
        }
        if(val < root.val){
            if(null == root.left){
                root.left = treeNode;
            }else{
                insertIntoBST(root.left, val);
            }
        }else{
            if(null == root.right){
                root.right = treeNode;
            }else{
                insertIntoBST(root.right, val);
            }
        }
        return root;
    }

    //工程中迭代优于递归
    public TreeNode solution(TreeNode root, int val){
        TreeNode treeNode = new TreeNode(val);
        if(null == root){
            return treeNode;
        }
        TreeNode cur = root;
        while(true){
            if(val < cur.val){
                if(null == cur.left){
                    cur.left = treeNode;
                    break;
                }
                cur = cur.left;
            }else{
                if(null == cur.right){
                    cur.right = treeNode;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
