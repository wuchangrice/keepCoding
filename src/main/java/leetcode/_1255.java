package leetcode;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oukinsei on 2020/4/16.
 */
public class _1255 {
    int result = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //因为是26个字母，所以map可以改为char[26]
        result = 0;
        Map<Character, Integer> remainLetters = new HashMap<>();
        for(char c : letters){
            remainLetters.put(c, remainLetters.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer>[] wordsMap = new Map[words.length];
        int[] wordScore = new int[words.length];
        for(int i = 0; i < words.length; i++){
            Map<Character, Integer> item = new HashMap<>();
            for(char c : words[i].toCharArray()){
                 item.put(c, item.getOrDefault(c, 0)+1);
            }
            int cur = 0;
            for(Map.Entry<Character, Integer> entry : item.entrySet()){
                if(remainLetters.containsKey(entry.getKey()) && remainLetters.get(entry.getKey()) >= entry.getValue()){
                    cur += (score[entry.getKey()-'a']*entry.getValue());
                }else{
                    cur = 0;
                    break;
                }
            }
            wordsMap[i] = item;
            wordScore[i] = cur;
        }
        dfs(wordsMap, 0, 0, remainLetters, wordScore);
        return result;
    }

    private void dfs(Map<Character, Integer>[] words, int position, int cur,  Map<Character, Integer> remainLetters, int[] wordScore){
        if(position == words.length){
            return;
        }
        if(wordScore[position] == 0 || contains(remainLetters, words[position])){
            dfs(words, position + 1, cur, remainLetters, wordScore);
            return;
        }else{
            result = Math.max(result, cur + wordScore[position]);
            dfs(words, position+1, cur+wordScore[position], remainLetters, wordScore);
            back(remainLetters, words[position]);
            dfs(words, position+1, cur, remainLetters, wordScore);
        }
    }

    private boolean contains(Map<Character, Integer> remainLetters, Map<Character, Integer> word){
        boolean result = true;
        for(Map.Entry<Character, Integer> entry : word.entrySet()){
            if(remainLetters.get(entry.getKey()) < entry.getValue()){
                result = false;
                break;
            }
        }
        if(result){
            for(Map.Entry<Character, Integer> entry : word.entrySet()){
                remainLetters.put(entry.getKey(), remainLetters.get(entry.getKey())-entry.getValue());
            }
        }
        return result;
    }

    private void back(Map<Character, Integer> remainLetters, Map<Character, Integer> word){
        for(Map.Entry<Character, Integer> entry : word.entrySet()){
            remainLetters.put(entry.getKey(), remainLetters.get(entry.getKey())+entry.getValue());
        }
    }

}
