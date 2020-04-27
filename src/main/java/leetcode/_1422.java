package leetcode;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _1422 {
    public int maxScore(String s) { //左0右1的最大和
        int result = 0, c0 = 0, c1 = 0;
        for(int i = 1; i < s.length() -1; i++){
            if(s.charAt(i) == '0'){
                c0++;
                if(c0 > c1){
                    result+= c0;
                    c0 = 0;
                    c1 = 0;
                }
            }else{
                c1++;
            }
        }
        result += c1;
        if(s.charAt(0) == '0'){
            result++;
        }
        if(s.charAt(s.length()-1) == '1'){
            result++;
        }
        return result;
    }
}
