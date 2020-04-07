package leetcode;

/**
 * Created by oukinsei on 2020/4/3.
 */
public class _904 {
    public int totalFruit(int[] tree) {
        int left = 0, right = 0, result = 0, a = tree[0], b = tree[0], change = 0;
        while(right < tree.length){
            if(tree[right] == b){

            }else if(a == b){
                b = tree[right];
                change = right;
            }else if(tree[right] == a){
                int temp = a;
                a = b;
                b = temp;
                change = right;
            }else{
                result = Math.max(result, right - left);
                left = change;
                a = tree[left];
                b = tree[right];
                change = right;
            }
            right++;
        }
        result = Math.max(result, right-left+1);
        return result;
    }
}
