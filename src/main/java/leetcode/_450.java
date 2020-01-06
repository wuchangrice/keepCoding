package leetcode;

/**
 * Created by oukinsei on 2020/1/6.
 * 450. Delete Node in a BST
 *
 */
public class _450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(null == root){
            return null;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode leftMax = findLeftMax(root.left);
                root.val = leftMax.val;
                root.left = deleteNode(root.left,leftMax.val);
            }
        }else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    public TreeNode findLeftMax(TreeNode root){
        if(root.right != null){
            return findLeftMax(root.right);
        }
        return root;
    }

}
