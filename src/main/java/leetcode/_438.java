package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/5/18.
 */
public class _438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[129];
        int target = p.length(), left = 0, right = 0, cur = 0;
        for(char c : p.toCharArray()){
            count[c]++;
        }
        while(right < s.length()){
            if(right >= target){
                if(count[s.charAt(left)]++ >= 0){
                    cur--;
                }
                left++;
            }
            if(count[s.charAt(right)]-- > 0){
                cur++;
            }
            if(cur == target){
                result.add(left);
            }
            right++;
        }
        return result;
    }
}
