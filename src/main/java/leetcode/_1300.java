package leetcode;

import java.util.Arrays;

/**
 * Created by oukinsei on 2020/4/3.
 */
public class _1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length, i = 0, result = 0;
        while(i < arr.length){
            if(arr[i] < target/len){
                target -= arr[i];
                len--;
                i++;
            }else{

                break;
            }
        }
        return result;
    }
}
