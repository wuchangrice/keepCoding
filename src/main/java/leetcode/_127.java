package leetcode;

import java.util.*;

/**
 * Created by oukinsei on 2020/1/19.
 * Word Ladder
 */
public class _127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        int result = 1;
        boolean containEndWord = false;
        for(String item:wordList){
            if(item.equals(endWord)){
                containEndWord = true;
                break;
            }
        }
        if(!containEndWord){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=len; i>0;i--){ //1.居然是len--
                String cur = q.poll(); //2.跑到了下面的循环里面。。
                for(String item: wordList){
                    if(visited.contains(item)){ //3.变量搞不清。。
                        continue;
                    }
                    if(oneStep(cur, endWord)){
                        return result+1;
                    }
                    if(oneStep(cur, item)){
                        visited.add(item);
                        q.offer(item);
                    }
                }
            }
            result++;
        }
        return 0;
    }

    public static int ladderLengthNew(String beginWord, String endWord, List<String> wordList) {
        //通过变动word的值，从wordList找到目标值

        Set<String> visited = new HashSet<>();
        return 0;
    }

    private static boolean oneStep(String a, String b){
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff > 1){
                    return false;
                }
            }
        }
        return diff==1;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int result = ladderLength("hit", "cog", wordList);
    }
}
