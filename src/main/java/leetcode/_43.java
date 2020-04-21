package leetcode;

/**
 * Created by oukinsei on 2020/4/7.
 */
public class _43 {
    public String multiply(String num1, String num2) {
        String result = "0", less = "", more = "";
        if(num1.length() > num2.length()){
            less = num2;
            more = num1;
        }else{
            less = num1;
            more = num2;
        }
        for(int i = less.length()-1; i >= 0; i--){
            if(less.charAt(i) != '0') {
                result = add(result, multiply(more, less.charAt(i), less.length() - 1 - i));
            }
        }
        return result;
    }

    private String multiply(String num, char c, int tail){
        char[] result = new char[num.length()+1+tail];
        int pos = result.length-1;
        for(int i = 0; i < tail; i++){
            result[pos--] = '0';
        }
        int carry = 0, i = num.length()-1,sum;
        while(i >= 0){
            sum = (c-'0')*(num.charAt(i)-'0') + carry;
            carry = sum/10;
            result[pos--] = (char)(sum%10+'0');
            i--;
        }
        if(carry > 0){
            result[pos--] = (char)(carry+'0');
        }
        if(result[0] == 0){
            return new String(result).substring(1);
        }
        return new String(result);
    }

    private String add(String num1, String num2){
        char[] result = new char[Math.max(num1.length(), num2.length())+1];
        int carry = 0, i1 = num1.length()-1, i2 = num2.length()-1, i = result.length -1, sum;
        while(i1 >= 0 || i2 >= 0 || carry > 0){
            sum = 0;
            if(i1 >= 0) {
                sum += num1.charAt(i1) - '0';
                i1--;
            }
            if(i2 >= 0) {
                sum += num2.charAt(i2) - '0';
                i2--;
            }
            sum += carry;
            carry = sum/10;
            result[i] = (char)(sum%10 + '0');
            i--;
        }
        if(result[0] == 0){
            return new String(result).substring(1);
        }
        return new String(result);

    }

    public static void main(String[] args) {
        new _43().multiply("720", "144");
    }
}
