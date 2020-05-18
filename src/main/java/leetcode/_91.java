package leetcode;

/**
 * Created by oukinsei on 2020/5/6.
 */
public class _91 {
    public int numDecodings(String s) {
        if(s.startsWith("0")){
            return 0;
        }
        int f1 = 1, f2 = 0, lastNum = s.charAt(0)-'0', nf2;
        for(int i = 1; i < s.length(); i++){
            int cur = s.charAt(i) -'0';
            if(lastNum*10+cur < 27){
                nf2 = f1;
            }else{
                nf2 = 0;
            }
            if(cur == 0){
                if(lastNum != 1 && lastNum != 2){
                    return 0;
                }
                f1 = 0;
            }else {
                f1 = f1 + f2;
            }
            f2 = nf2;
            lastNum = cur;
        }
        return f1+f2;
    }
}
