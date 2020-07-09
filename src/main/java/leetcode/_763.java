package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/7/7.
 */
public class _763 {
    public List<Integer> partitionLabels(String s){
        List<Integer> result = new ArrayList<>();
        int[] lastPosition = new int[26];
        int[] stack = new int[26];
        int peek = -1;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            int position = cur-'a';
            if(lastPosition[position] > 0){
                while(peek >= 0 && stack[peek] >= lastPosition[position]){
                    stack[peek] = 0;
                    peek--;
                }
            }
            peek++;
            stack[peek] = i+1; //1 based
            lastPosition[position] = i+1;
        }
        int last = 0;
        for(int i = 0; i <= peek; i++){
            result.add(stack[i]-last);
            last = stack[i];
        }
        return result;
    }

}
