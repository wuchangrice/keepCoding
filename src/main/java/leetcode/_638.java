package leetcode;

import java.util.List;

/**
 * Created by oukinsei on 2020/3/26.
 */
public class _638 {
    //多元的背包问题
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] result = new int[2]; //0放当前值，1放结果
        result[1] = Integer.MAX_VALUE;
        dfs(price, special, needs, 0, result);
        return result[1];
    }

    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cur, int[] result){
        if(cur == special.size()){
            int cnt = 0;
            for(int i = 0; i < needs.size(); i++){
                cnt += (needs.get(i) * price.get(i));
            }
            if(result[0] + cnt < result[1]){
                result[1] = result[0] + cnt;
            }
            return;
        }
        List<Integer> curSpecial = special.get(cur);
        int added = 0;
        for(int i = 0; i < 6; i++){
            boolean needContinue = addSpecial(curSpecial, needs);
            result[0] += curSpecial.get(curSpecial.size()-1);
            if(!needContinue){
                added = i;
                break;
            }
            dfs(price, special, needs, cur+1, result);
        }
        for(int i = 0; i <= added; i++){
            deleteSpecial(curSpecial, needs);
            result[0] -= curSpecial.get(curSpecial.size()-1);
        }
        dfs(price, special, needs, cur+1, result);
    }
    private boolean addSpecial(List<Integer> special, List<Integer> needs){
        boolean result = true;
        for(int i = 0; i < needs.size(); i++){
            needs.set(i, needs.get(i) - special.get(i));
            if(needs.get(i) <0){
                result = false;
            }
        }
        return result;
    }
    private void deleteSpecial(List<Integer> special, List<Integer> needs){
        for(int i = 0; i < needs.size(); i++){
            needs.set(i, needs.get(i) + special.get(i));
        }
    }
}
