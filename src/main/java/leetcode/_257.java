package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/1/2.
 * 257. Binary Tree Paths
 * 优化方案是将String改为StringBuilder
 */
public class _257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traverse(root, result, "");
        return result;
    }

    private void traverse(TreeNode root, List<String> result, String path){
        if(null == root){
            return ;
        }
        if(root.left == null && root.right == null){
            result.add((path + "->" + root.val).substring(2));
            return;
        }
        traverse(root.left, result, path + "->" + root.val);
        traverse(root.right, result, path + "->" + root.val);
    }

}
