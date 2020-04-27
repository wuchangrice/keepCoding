package leetcode;

import java.util.List;

/**
 * Created by oukinsei on 2020/4/27.
 */
public class _1424 {
    //todo
    public int[] findDiagonalOrder(List<List<Integer>> nums) { //对角线式打印数字
        int total = 0, index = 0;
        for(List<Integer> list : nums){
            total += list.size();
        }
        int[] result = new int[total];
        for(int i = 0; i < nums.size();){
            for(int j = i; j >=0; j--){
                List<Integer> list = nums.get(j);
                result[index++] = list.get(0);
                if(index == total){
                    return result;
                }
                list.remove(0);
                if(list.isEmpty()){
                    nums.remove(j);
                    i--;
                }
            }
            if(i < nums.size() -1){
                i++;
            }
        }
        return result;
    }
}
