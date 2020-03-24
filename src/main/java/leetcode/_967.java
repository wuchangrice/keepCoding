package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/3/24.
 */
public class _967 {
    public static void main(String[] args) {
        int[] result = new _967().numsSameConsecDiff(3,0);
        System.out.println(result);
    }

    public int[] numsSameConsecDiff(int N, int K) {
        if(N == 1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        List<Integer> result = new ArrayList<>();
        int[] item = new int[N];
        dfs(item,0, result, K);
        int[] nums = new int[result.size()];
        int index = 0;
        for(int i : result){
            nums[index++] = i;
        }
        return nums;
    }

    private void dfs(int[] item, int position, List<Integer> result, int K){
        if(position == item.length){
            int cur = 0;
            for(int i = 0; i < item.length; i++){
                cur = cur * 10 + item[i];
            }
            result.add(cur);
            return;
        }
        if(position == 0){
            for(int i = 1; i < 10; i++){
                item[position] = i;
                dfs(item, position+1, result, K);
            }
        }else{
            for(int i = 0; i < 10; i++){
                if(Math.abs(item[position-1]-i) == K){
                    item[position] = i;
                    dfs(item, position+1, result, K);
                }
            }
        }
    }
}
