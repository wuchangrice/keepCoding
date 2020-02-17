package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TireTree {
    class TreeNode {
        char val;
        Map<Character, TreeNode> child = new HashMap<>();
        boolean isWord;

        public TreeNode() {
        }

        public TreeNode(char val) {
            this.val = val;
        }
    }
    TreeNode root;

    public TireTree() {
        root = new TreeNode();
    }

    public void insertWord(String word){
        TreeNode cur = root;
        Map<Character,TreeNode> curChild = cur.child;
        for(Character c : word.toCharArray()){
            if(curChild.containsKey(c)){
                cur = curChild.get(c);
            }else{
                cur = new TreeNode(c);
                curChild.put(c, cur);
            }
            curChild = cur.child;
        }
        cur.isWord=true;
    }

    public boolean searchWord(String word){
        TreeNode treeNode = getWordPos(word);
        if(treeNode == null){
            return false;
        }
        return treeNode.isWord;
    }

    public boolean startWith(String word){
        TreeNode treeNode = getWordPos(word);
        if(treeNode == null){
            return false;
        }
        return true;
    }

    public TreeNode getWordPos(String word){
        TreeNode cur = root;
        Map<Character, TreeNode> curChild = root.child;
        for(Character c : word.toCharArray()){
            if(!curChild.containsKey(c)){
                return null;
            }
            cur = curChild.get(c);
            curChild = cur.child;
        }
        return cur;
    }
}
