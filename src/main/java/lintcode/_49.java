package lintcode;

public class _49 {
    public void sortLetters(char[] chars) {
        int left = 0 , right = chars.length-1;
        while(left < right){
            while(chars[left] >= 'a' && chars[left] <= 'z' && left < right){
                left++;
            }
            while(chars[right] >= 'A' && chars[right] <= 'Z' && right > left){
                right--;
            }
            if(left<right){
                swap(chars, left++, right--);
            }
        }
    }

    private void swap(char[] chars, int a, int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
