package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oukinsei on 2020/3/25.
 */
public class _808 {
    public static void main(String[] args) {
        new _808().soupServings(100);
        //记忆化搜索，用double[][] 保存中间结果，集体除以25，4800以上剪枝
    }
    Map<String, Double> result = new HashMap<>();
    public double soupServings(int N) {
        return probability(N,N);
    }

    private double probability(int x, int y){
        if(x <= 0 && y <= 0){
            return 0.5;
        }
        if(y <= 0){
            return 0;
        }
        if(x <= 0){
            return 1;
        }
        if(result.containsKey(x +"E" +y)){
            return result.get(x +"E" +y);
        }else{
            double temp = 0.25*(probability(x-100,y) + probability(x-75,y-25) + probability(x-50,y-50) + probability(x-25,y-75));
            result.put(x +"E" +y, temp);
            return temp;
        }
    }
}
