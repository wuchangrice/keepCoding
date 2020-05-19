package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by oukinsei on 2020/5/19.
 */
public class StockSpanner {
    //Deque的使用，deque使用不太熟练，放弃使用int[][]来模拟的双端队列
    int[][] stack = new int[10000][2];
    int len = 0;
    public StockSpanner() {
    }

    public int next(int price) {
        int result = 1;
        while(len > 0 && stack[len-1][0] <= price){
            result += stack[len-1][1];
            len--;
        }
        stack[len][0] = price;
        stack[len][1] = result;
        len++;
        return result;
    }
}
