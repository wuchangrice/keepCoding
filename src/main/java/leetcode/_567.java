package leetcode;

/**
 * Created by oukinsei on 2020/5/18.
 */
public class _567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        int target = s2.length(), cur = 0, left = 0, right = 0, len = s1.length();
        for(int i = 0; i < target; i++){
            count[s2.charAt(i)]++;
        }
        while(right < len){
            char c = s1.charAt(right);
            if(count[c] > 0){
                cur++;
                if(cur == target){
                    return true;
                }
                count[c]--;
            }else{
                while(left <= right){
                    if(s1.charAt(left) == c){
                        left++;
                        break;
                    }
                    count[s1.charAt(left)]++;
                    left++;
                    cur--;
                }
            }
            right++;
        }
        return false;
    }
}
