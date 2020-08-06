package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by oukinsei on 2020/7/30.
 */
public class _767 {
    public String reorganizeString(String input){
        if(null == input || input.length() < 2){
            return input;
        }
        int[] count = new int[256];
        char maxChar = 0;
        int curMax = -1, p = 1;
        for(char c : input.toCharArray()){
            if(count[c]++ >= curMax){
                curMax = count[c];
                maxChar = c;
            }
        }
        if(curMax > (input.length()+1)/2){
            return "";
        }
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < curMax; i++){
            list.add(maxChar);
        }
        for(int i = 0; i < 256; i++){
            if(i == maxChar){
                continue;
            }
            int curLen = count[i];
            char curChar = (char)i;
            while(curLen > 0){
                list.add(p, curChar);
                p += 2;
                curLen--;
                p = p > list.size() ? 1 : p;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new _767().reorganizeString("aab");
    }
}
