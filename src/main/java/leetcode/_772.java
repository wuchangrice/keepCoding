package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/4/29.
 */
public class _772 {
    public static void main(String[] args) {
        int result = new _772().calculate("4+-1");
        System.out.println(result);
    }
    public int calculate(String s) {
        int result = 0;
        while(s.contains("(")){
            int end = s.indexOf(")");
            int start = s.substring(0,end).lastIndexOf("(");
            s = s.substring(0, start) + calculate(s.substring(start+1, end)) + s.substring(end+1, s.length());
        }
        s = s.replaceAll(" ", "");
        List<Long> nums = new ArrayList<>();
        List<Character> operates = new ArrayList<>();
        int left = 0, right = 1;
        while(right < s.length()){
            char c = s.charAt(right);
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                nums.add(Long.valueOf(s.substring(left, right)));
                left = right+1;
                operates.add(c);
                if(right+1 < s.length() && s.charAt(right+1) == '-'){//负数
                    right++;
                }
            }
            right++;
        }
        nums.add(Long.valueOf(s.substring(left, right)));
        char lastOperate = '+';
        long a = nums.get(0);
        for(int i = 0; i < operates.size(); i++){
            char curOperate = operates.get(i);
            if(curOperate == '+' || curOperate == '-'){
                if(lastOperate == '+'){
                    result += a;
                }else{
                    result -= a;
                }
                lastOperate = curOperate;
                a = nums.get(i+1);
            }else if(curOperate == '*'){
                a *= nums.get(i+1);
            }else{
                a /= nums.get(i+1);
            }
        }
        if(lastOperate == '+'){
            result += a;
        }else{
            result -= a;
        }
        return result;
    }
}
