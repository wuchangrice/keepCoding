package leetcode;

import java.util.Stack;

/**
 * Created by oukinsei on 2020/4/29.
 */
public class _297 {
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        helper(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("" == data){
            return null;
        }
        TreeNode dummyNode = new TreeNode(0);
        Stack<TreeNode> s = new Stack<>();
        s.push(dummyNode);
        String[] leftLists = data.split("#");
        for(String leftList : leftLists){
            String[] vals = leftList.split(",");
            TreeNode head = s.pop();
            for(int i = 1; i < vals.length; i++) {//因第一字符为,0位置的数据为空
                String val = vals[i];
                boolean hasRight = false;
                if(val.endsWith("R")){
                    hasRight = true;
                    val = val.split("R")[0];
                }
                TreeNode node = new TreeNode(Integer.valueOf(val));
                if(i == 1){
                    head.right = node;
                }else {
                    head.left = node;
                }
                head = node;
                if(hasRight){
                    s.push(node);
                }
            }
        }
        return dummyNode.right;
    }

    void helper(TreeNode root, StringBuffer sb){
        sb.append(","+root.val);
        if(root.right != null){
            sb.append("R");
        }
        if(root.left == null){
            sb.append("#");
        }else{
            helper(root.left, sb);
        }
        if(root.right != null){
            helper(root.right, sb);
        }


    }
}
