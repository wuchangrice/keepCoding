package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/4/29.
 */
public class _297_2 {
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preOrder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new ArrayDeque<>();
        String[] ss = data.split(",");
        List<String> list = Arrays.asList(ss);
        dq.addAll(list);
        TreeNode root = buildTree(dq);
        return root;
    }

    private void preOrder(TreeNode root, StringBuffer sb){
        if(root == null){
            sb.append("#,");
        }else{
            sb.append(root.val+",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }

    private TreeNode buildTree(Deque<String> dq){
        if(dq.isEmpty()){
            return null;
        }
        String val = dq.poll();
        if("#".equals(val)){
            return null;
        }
        TreeNode result = new TreeNode(Integer.valueOf(val));
        result.left = buildTree(dq);
        result.right = buildTree(dq);
        return result;
    }
}
