package leetcode;

import org.omg.CORBA.BAD_CONTEXT;

/**
 * Created by oukinsei on 2020/3/13.
 */
public class balloon {
    public static void main(String[] args) {
        new balloon().maxScore(new int[]{3,2,5,4});
    }
    public int maxScore(int[] balloons){
        //分数最大
        return maxScore(1,0,balloons,balloons.length-1, 1);
    }

    private int maxScore(int edgeLeft, int left, int[] balloons, int right, int edgeRight){
        int result = 0;
        if(left > right){
            return 0;
        }
        if(left == right){
            return edgeLeft * balloons[left] * edgeRight;
        }
        for(int i = left; i <= right; i++){
            int curSum = edgeLeft*balloons[i]*edgeRight+maxScore(edgeLeft,left,balloons,i-1,balloons[i])+maxScore(balloons[i], i+1,balloons, right, edgeRight);
            if(curSum > result) {
                result = curSum;
            }
        }
        return result;
    }
}
