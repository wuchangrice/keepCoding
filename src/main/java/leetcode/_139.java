package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oukinsei on 2020/3/13.
 */
public class _139 {
    //todo
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        new _139().wordBreak("cars", wordDict);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Tree tireTree = new Tree();
        for(String word : wordDict){
            tireTree.insert(word);
        }
        return tireTree.isUnion(s.toCharArray(), 0);
    }

    class Node{
        char c;
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;

        public Node(){

        }

        public Node(char c){
            this.c = c;
        }
    }

    class Tree{
        Node root;
        public Tree(){
            root = new Node();
        }
        public void insert(String word){
            char[] s = word.toCharArray();
            Node search = root;
            for(int i = 0; i < s.length; i++){
                if(search.children.containsKey(s[i])){
                    search = search.children.get(s[i]);
                }else{
                    Node node = new Node(s[i]);
                    search.children.put(s[i], node);
                    search = node;
                }
            }
            search.isWord = true;
        }

        public List<Integer> slice(char[] s, int start){
            List<Integer> result = new ArrayList<>();
            Node search = root;
            for(int i = start; i < s.length; i++){
                if(search.children.containsKey(s[i])){
                    search = search.children.get(s[i]);
                    if(search.isWord){
                        result.add(i+1);
                    }
                }else{
                    break;
                }
            }
            return result;

        }

        public boolean isUnion(char[] s, int start){
            if(start == s.length){
                return true;
            }
            List<Integer> positions = slice(s, start);
            for(int i = positions.size()-1; i >=0; i--){
                if(isUnion(s, positions.get(i))){
                    return true;
                }
            }
            return false;
        }
    }
}
