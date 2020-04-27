package leetcode;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _1422 {
    public int maxScore(String s) { //左0右1的最大和
        int result = 0;
        char[] chars = s.toCharArray();
        int[] l0 = new int[s.length()+1];
        int[] l1 = new int[s.length()+1];
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '0') {
                l0[i + 1] = l0[i] + 1;
            }else{
                l0[i + 1] = l0[i];
            }
        }
        if(chars[chars.length-1] == '1'){
            l1[chars.length] = 1;
        }
        for(int i = chars.length-1; i > 0; i--){
            if(chars[i-1] == '1') {
                l1[i] = l1[i+1] + 1;
            }else{
                l1[i] = l1[i+1];
            }
        }
        for(int i = 1; i <= chars.length; i++){
            if(l0[i]+l1[i] > result){
                result = l0[i]+l1[i];
                if(l0[i] == 0 || l1[i] == 0){
                    result--;
                }
            }
        }
        return result;
    }
}
