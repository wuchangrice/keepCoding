package leetcode;

import java.util.*;

public class _212 {
    public List<String> findWords(char[][] board, String[] words) {
        TireTree tree = new TireTree();
        Set<String> result = new HashSet<>();
        for(String word : words){
            tree.insertWord(word);
        }
        StringBuffer sb = new StringBuffer();
        boolean[][] helper = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(helper, board, i, j, result, sb, tree.root);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(boolean[][] helper, char[][] board, int i, int j, Set<String> result, StringBuffer sb, TireTree.TreeNode treeNode){
        //使用treeNode可以使用计算过程中间的结果
        Map<Character, TireTree.TreeNode> child = treeNode.child;
        if(!child.containsKey(board[i][j])){
            return;
        }
        TireTree.TreeNode cur = child.get(board[i][j]);
        int m = helper.length;
        int n = helper[0].length;
        sb.append(board[i][j]);
        helper[i][j] = true;
        if(cur.isWord){
            result.add(sb.toString());
        }
        if(i>0 && helper[i-1][j] == false){//up
            dfs(helper, board, i-1, j, result, sb, cur);
        }
        if(i<m-1 && helper[i+1][j] == false) {//down
            dfs(helper, board, i+1, j, result, sb, cur);
        }
        if(j>0 && helper[i][j-1] == false){//left
            dfs(helper, board, i, j-1, result, sb, cur);
        }
        if(j<n-1 && helper[i][j+1] == false){//right
            dfs(helper, board, i, j+1, result, sb, cur);
        }
        sb.setLength(sb.length()-1);
        helper[i][j]=false;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"oath","pea","eat","rain"};
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        new _212().findWords(board,words);
    }
}
