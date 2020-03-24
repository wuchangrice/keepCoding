package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/3/13.
 */
public class _472 {
    //bad case "aaaaaaaaaaa" "aaa" "aaaaaa" "aa"
    public static void main(String[] args) {
        String[] words = new String[]{"a","b","ab","abc","acb","bc"};
        new _472().findAllConcatenatedWordsInADict(words);
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words,(a,b) ->(a.length()-b.length()));
        Tree tireTree = new Tree();
        for(String word : words){
            if(null == word || word.length() == 0){
                continue;
            }
            if(tireTree.isUnion(word.toCharArray(),0)){
                result.add(word);
            }
            tireTree.insert(word);
        }
        return result;
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
