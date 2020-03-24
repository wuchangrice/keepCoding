package leetcode;

/**
 * Created by oukinsei on 2020/3/11.
 */
public class _744 {
    //letters sorted
    public char nextGreatestLetter(char[] letters, char target) {
        //二分查找
        int len = letters.length;
        if(letters[len-1] <= target){
            return letters[0];
        }
        int left = 0, right = len -1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(letters[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(letters[left] > target){
            return letters[left];
        }else{
            return letters[right];
        }
    }
}
