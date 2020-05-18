package leetcode;

/**
 * Created by oukinsei on 2020/5/6.
 */
public class _227 {
    public static void main(String[] args) {
        new _227().calculate("4+2*-3");
    }
    public int calculate(String s) {
        int depth = 0, num = 0, result = 0;
        int[] stack = new int[s.length()];
        char[] chars = s.toCharArray();
        char sign = '+';
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){
                num = num*10+chars[i]-'0';
            }
            if((!Character.isDigit(chars[i]) && ' '!= chars[i]) || i==chars.length-1){
                if(sign == '-'){
                    stack[depth++] = -num;
                }else if(sign == '+'){
                    stack[depth++] = num;
                }else if(sign == '*'){
                    stack[depth-1] *= num;
                }else if(sign == '/'){
                    stack[depth-1] /= num;
                }
                sign = chars[i];
                num = 0;
            }
        }
        for(int i = 0; i < depth; i++){
            result += stack[i];
        }
        return result;
    }
    //没有括号的加减乘除
    //旁门左道，效率慢，改为stack的正宗做法
    public int calculateDlete(String s) {
        s = s.replaceAll(" ", "");
        s = "+"+s;
        int left = 0, right  = 0, cur, a = 0, result = 0;
        char first = '+',second= '+';
        while(left < s.length()){
            second = s.charAt(left);
            right = left + 2;
            while(right < s.length()){
                int c = s.charAt(right);
                if(c >= '0' && c <= '9'){
                    right++;
                }else{
                    break;
                }
            }
            cur = Integer.valueOf(s.substring(left+1, right));
            left = right;
            if(second == '+' || second == '-'){
                if(first == '+'){
                    result += a;
                    a = cur;
                    first = second;
                }else{
                    result -= a;
                    a = cur;
                    first = second;
                }
            }else if(second == '*'){
                a *= cur;
            }else{
                a /= cur;
            }

        }
        if(a != 0){
            if(first == '+'){
                result += a;
            }else{
                result -= a;
            }
        }
        return result;
    }
}
