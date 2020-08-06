package practice;

/**
 * Created by oukinsei on 2020/8/6.
 */
public class Atoi {
    public static int atoi(String str){
        //异常,越界返回0
        long result = 0;
        int start = 0;
        if(null == str || str.length() == 0){
            //log
            return 0;
        }
        boolean negative = false;
        if(str.charAt(0) == '-'){
            negative = true;
            start++;
        }else if(str.charAt(0) == '+'){
            start++;
        }
        if(start == str.length()){
            //log
            return 0;
        }
        for(int i = start; i < str.length(); i++){
            char c = str.charAt(i);
            if(c > '9' || c < '0'){
                //log
                return 0;
            }
            result *= 10;
            result += (c-'0');
            if(negative && 0-result < Integer.MIN_VALUE){
                //log
                return 0;
            }else if(!negative && result > Integer.MAX_VALUE){
                //log
                return 0;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(Atoi.atoi("-3238929328923892383293"));
    }
}
