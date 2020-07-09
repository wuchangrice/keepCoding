package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by oukinsei on 2020/7/2.
 */
public class _54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        TreeMap<Integer, String> item = new TreeMap<>();
        Map.Entry<Integer, String> aa = item.floorEntry(1);
        if(aa == null){

        }
        aa.getValue();
        return result;
    }

    public void print(int[][] matrix, int left, int right, int up, int down, List<Integer> result){

    }
}
