package leetcode;

public class _125 {
    public boolean isPalindrome(String s) {
        boolean result = true;
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = chars.length-1;
        while(left < right){
            while(!Character.isLetterOrDigit(chars[left]) && left < right){
                left++;
            }
            while(!Character.isLetterOrDigit(chars[right]) && right > left){
                right--;
            }
            if(chars[left] != chars[right]){
                return false;
            }else{
                left++;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        boolean result = new _125().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}
