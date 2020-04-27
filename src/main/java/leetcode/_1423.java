package leetcode;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _1423 {
    public int maxScore(int[] cardPoints, int k)  {//拿k个的最大值
        int result = 0;
        int[] sum1 = new int[cardPoints.length+1];
        int[] sum2 = new int[cardPoints.length+1];
        for(int i = 0; i < cardPoints.length; i++){
            sum1[i+1] = sum1[i]+cardPoints[i];
            sum2[i+1] = sum2[i]+cardPoints[cardPoints.length-i-1];
        }
        for(int i = 0; i <= k; i++){
            if(sum1[i]+sum2[k-i] > result){
                result = sum1[i]+sum2[k-i];
            }
        }
        return result;
    }
}
